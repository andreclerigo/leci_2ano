        .equ    RESET_CORE_TIMER, 12
        .equ    READ_CORE_TIMER, 11
        .equ    putChar, 3
        .equ    printInt, 6
        .equ    inKey, 1
        .data
        .text
        .globl main

main:                                   # int main(void) {
        addiu   $sp, $sp, -24           #       abrir espaco na pilha
        sw      $ra, 0($sp)             #       guardar o $ra
        sw      $s0, 4($sp)             #       guardar o $s0
        sw      $s1, 8($sp)             #       guardar o $s1
        sw      $s2, 12($sp)            #       guardar o $s2
        sw      $s3, 16($sp)            #       guardar o $s3
        sw      $s4, 20($sp)            #       guardar o $s4
        li      $s0, 0                  #       cnt10 = 0;
        li      $s1, 0                  #       cnt5 = 0;
        li      $s2, 0                  #       cnt1 = 0;
        li      $s3, 100                #       t = 100;
        li      $s4, 1                  #       del = true;

while:                                  #       while(1) {
input:  li      $v0, inKey              #               $v0 = 1
        syscall                         #               c = inkey();

if3:    bne     $v0, 'A', endif3        #               if (c == 'A') {
        li      $s3, 50                 #                   t = 50;
endif3:                                 #               }
if4:    bne     $v0, 'N', endif4        #               if (c == 'N') {
        li      $s3, 100                #                   t = 100;
endif4:                                 #               }

if5:    bne     $v0, 'S', endif5        #               if (c == 'S') {
        li      $s4, 0                  #                   del = false;
endif5:                                 #               }
if6:    bne     $v0, 'R', endif6        #               if (c == 'R') {
        li      $s4, 1                  #                   del = true;
endif6:                                 #               }
                                        #
if7:    beq     $s4, 1, endif7          #               if (del == true) {
        j       input                   #                   inkey();
endif7:                                 #               }
        move    $a0, $s3                #                   $a0 = t;
        jal     delay                   #                   delay(t);
        li      $a0, '\r'               #               $a0 = '\r'
        li      $v0, putChar            #               $v0 = 3;
        syscall                         #               putChar('\r');
                                        #
        addi    $s0, $s0, 1             #               cnt10++;
        move    $a0, $s0                #               $a0 = ++cnt10;
        li      $a1, 0x0005000A         #               $a1 = 10 | 4 << 16
        li      $v0, printInt           #               $v0 = 6;
        syscall                         #               printInt(++cnt10, 10 | 5 << 16);

if:     rem     $t0, $s0, 2             #               if(cnt10 % 2 == 0) {
        bne     $t0, 0, endif           #
        addi    $s1, $s1, 1             #                       cnt5++;
endif:                                  #               }

if2:    rem     $t0, $s0, 10            #               if(cnt10 % 10 == 0) {
        bne     $t0, 0, endif2          #
        addi    $s2, $s2, 1             #                       cnt1++;
endif2:                                 #               }
                                        #
        li      $a0, ' '                #               $a0 = ' '
        li      $v0, putChar            #               $v0 = 3;
        syscall                         #               putChar(' ');
        move    $a0, $s1                #
        li      $a1, 0x0005000A         #               $a1 = 10 | 4 << 16
        li      $v0, printInt           #               $v0 = 6;
        syscall                         #               printInt(cnt5, 10 | 5 << 16);
                                        #
        li      $a0, ' '                #               $a0 = ' '
        li      $v0, putChar            #               $v0 = 3;
        syscall                         #               putChar(' ');
        move    $a0, $s2                #
        li      $a1, 0x0005000A         #               $a1 = 10 | 4 << 16
        li      $v0, printInt           #               $v0 = 6;
        syscall                         #               printInt(cnt1, 10 | 5 << 16);
                                        #
        j       while                   #       }
        li      $v0, 0                  #       return 0;
        lw      $ra, 0($sp)             #       report o $ra
        lw      $s0, 4($sp)             #       repor o $s0
        lw      $s1, 8($sp)             #       repor o $s1
        lw      $s2, 12($sp)            #       repor o $s2
        lw      $s3, 16($sp)            #       repor o $s3
        lw      $s4, 20($sp)            #       repor o $s3
        addiu   $sp, $sp, 24            #       repor espaco da pilha
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