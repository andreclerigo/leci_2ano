        .equ    RESET_CORE_TIMER, 12
        .equ    READ_CORE_TIMER, 11
        .data
        .text
        .globl main

main:                                   # int main(void) {
        addiu   $sp, $sp, -4            #       abrir espaco na pilha
        sw      $ra, 0($sp)             #       salvaguardar o valor de $ra

        lw      $ra, 0($sp)             #       repor o valor de $ra
        addiu   $sp, $sp, 4             #       repor o espaco na pilha
        jr      $ra                     # }


timeDone:                               # usigned int timeDone(int ms, unsigned char reset) {
        li      $t0, 0                  #       usigned int retValue = 0;
if:     ble     $a1, 0, else            #       if (reset > 0) {
        li      $v0, RESET_CORE_TIMER   #               $v0 = 12;
        syscall                         #               resetCoreTimer();
        j       endif                   #       } else {
else:   li      $v0, READ_CORE_TIMER    #               $v0 = 11;
        syscall                         #               curCount = readCoreTimer();
        mul     $t1, $a0, 20000         #               ms * 20000;
if2:    ble     $v0, $t1, endif2        #               if (curCount > (ms * 20000)) {
        div     $t0, $v0, 20000         #                       retValue = curCount / 20000;
endif2:                                 #               }
endif:                                  #       }
        move    $v0, $t0                #       return retValue;
        jr      $ra                     # }