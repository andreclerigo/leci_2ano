        .equ READ_CORE_TIMER, 11
        .equ RESET_CORE_TIMER, 12
        .equ putChar, 3
        .equ printInt, 6
        .data
        .text
        .globl main

main:                                   # int main(void) {
        li      $t0, 0                  #       counter = 0;
while:  li      $v0, READ_CORE_TIMER    #       while(1) {
        syscall                         #               
        blt     $v0, 2000000, while     #               while(READ_CORE_TIMER < 2000000);
        li      $v0, RESET_CORE_TIMER   #               $v0 = 12;
        syscall                         #               resetCoreTimer();

        addi    $t0, $t0, 1             #
        move    $a0, $t0                #               $a0 = ++counter;
        li      $a1, 0x0004000A         #               $a1 = 10 | 4 << 16
# 2nd Method
#       lui     $a1, 4
#       ori     $a1, $a1, 10
# 3rd Method
#       ori     $a1, $0, 4
#       sll     $a1, $a1, 16
#       ori     $a1, $a1, 10
        li      $v0, printInt           #               $v0 = 6;
        syscall                         #               printInt(++counter, 10 | 4 << 16);
        li      $a0, '\r'               #               $a0 = '\r'
        li      $v0, putChar            #               $v0 = 3;
        syscall                         #               putChar('\r');
        j       while                   #       }
        li      $v0, 0                  #       return 0;
        jr      $ra                     # }