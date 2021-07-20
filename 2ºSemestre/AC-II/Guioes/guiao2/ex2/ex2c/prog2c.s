        .equ    RESET_CORE_TIMER, 12
        .equ    READ_CORE_TIMER, 11
        .equ putChar, 3
        .equ printInt, 6
        .data
        .text
        .globl main

main:                                   # int main(void) {
        addiu   $sp, $sp, -8            #       abrir espaco na pilha
        sw      $ra, 0($sp)             #       guardar o $ra
        sw      $s0, 4($sp)             #       guardar o $s0
        li      $s0, 0                  #       counter = 0;
while:                                  #       while(1) {
        li      $a0, 1000               #               $a0 = 1000;
        jal     delay                   #               delay(1000);

        addi    $s0, $s0, 1             #
        move    $a0, $s0                #               $a0 = ++counter;
        li      $a1, 0x0004000A         #               $a1 = 10 | 4 << 16
        li      $v0, printInt           #               $v0 = 6;
        syscall                         #               printInt(++counter, 10 | 4 << 16);
        li      $a0, '\r'               #               $a0 = '\r'
        li      $v0, putChar            #               $v0 = 3;
        syscall                         #               putChar('\r');
        j       while                   #       }
        li      $v0, 0                  #       return 0;
        lw      $ra, 0($sp)             #       report o $ra
        lw      $s0, 4($sp)             #       repor o $s0
        addiu   $sp, $sp, 8             #       repor espaco da pilha
        jr      $ra                     # }


delay:                                  # void delay(int ms) {
        move    $t0, $a0                #       $t0 = ms;
        
for:    ble     $t0, 0, endfor          #       for(; ms > 0; ms--) {
        li      $v0, RESET_CORE_TIMER   #               
        syscall                         #               resetCoreTimer();
read:   li      $v0, READ_CORE_TIMER    #
        syscall                         #               readCoreTimer();
        blt     $v0, 20000, read        #               while(readCoreTimer() < K);
        addi    $t0, $t0, -1            #               ms--;
        j       for                     #       }
endfor:                                 #       
        jr      $ra                     # }