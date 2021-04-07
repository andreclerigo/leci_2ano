        .equ    RESET_CORE_TIMER, 12
        .equ    READ_CORE_TIMER, 11
        .equ    SFR_BASE_HI, 0xBF88
	.equ    TRISE, 0x6100
	.equ    PORTE, 0x6110
	.equ    LATE, 0x6120
        .data
        .text
        .globl main

main:                                   # void main(void) {
        addiu   $sp, $sp, -12           #       abrir espaco na stack
        sw      $ra, 0($sp)             #       salvaguardar $ra
        sw      $s0, 4($sp)             #       salvaguardar $s0
        sw      $s1, 8($sp)             #       salvaguardar $s1

        li      $s0, 0                  #       v = 0;
        lui     $s1, SFR_BASE_HI        #       
        lw      $t1, TRISE($s1)         #       $t1 = [TRISE];
        andi    $t1, $t1, 0xFFFE        #       TRISE0 = 0;
        sw      $t1, TRISE($s1)         #       WRITE TRISE

loop:                                   #       while(1) {
        lw      $t1, LATE($s1)          #               
        andi    $t1, $t1, 0xFFFE        #               LATE0 = 0;
        or      $t2, $t1, $s0           #               LATE0 = v;
        sw      $t2, LATE($s1)          #               WRITE LATE Register
        li      $a0, 500                #               $a0 = 500;
        jal     delay                   #               delay(500);
        xori    $s0, $s0, 1             #               v ^= 1;
        j       loop                    #       }

        lw      $ra, 0($sp)             #       repor valor de $ra
        lw      $s0, 4($sp)             #       repor valor de $s0
        lw      $s1, 8($sp)             #       repor valor de $s1
        addiu   $sp, $sp, 12            #       repor espaco na stack
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