        .equ putChar, 3
        .equ printInt, 6
        .equ inKey, 1
        .data
        .text
        .globl main

main:                                   # int main(void) {
        addiu   $sp, $sp, -12           #      abrir
        sw      $ra, 0($sp)             #      guardar o $ra
        sw      $s0, 4($sp)             #      guardar o $s0
        sw      $s1, 8($sp)             #      guardar o $s1

        li      $s0, 0                  #       s = 0;
        li      $s1, 0                  #       cnt = 0;
do:                                     #       do {
        li      $a0, '\r'               #           $a0 = '\r'
        li      $v0, putChar            #
        syscall                         #           putChar('\r');  // Carriage return character 
        li      $t1, 3                  #           $t1 = 3;
        sll     $t1, $t1, 4             #           $t1 = 3 << 16
        ori     $t1, $t1, 10            #           $t1 = 10 | 3 << 16
        move    $a1, $t1                #           base = $t1
        move    $a0, $s0                #       
        li      $v0, printInt           #           $v0 = 6
        syscall                         #           printInt(cnt, base);  // 0x0003000A: decimal w/ 3 digits 

        li      $a0, '\t'               #           $a0 = '\t'
        li      $v0, putChar            #
        syscall                         #           putChar('\t');  // Tab character 
        li      $t1, 8                  #           $t1 = 8;
        sll     $t1, $t1, 4             #           $t1 = 8 << 16
        ori     $t1, $t1, 2             #           $t1 = 2 | 8 << 16
        move    $a1, $t1                #           base = $t1
        move    $a0, $t1                #
        li      $v0, printInt           #           $v0 = 6
        syscall                         #           printInt(cnt, base);  // 0x00080002: binary w/ 8 bits
        li      $a1, 5                  #       
        jal     wait                    #           wait(5);

        li      $v0, inKey              #
        syscall                         #           inKey();
        move    $t1, $v0                #           $t1 = char c = inKey();
                                     
if:     beq     $t1, '+', endif         #           if(c == '+') {
        li      $s0, 0                  #               s = 0;
endif:                                  #           }

if2:    beq     $t1, '-', endif2        #           if(c == '-') {
        li      $s0, 1                  #               s = 1;
endif2:                                 #           }

if3:    beq     $s0, 0, else            #           if(s == 0) {
        addi    $s1, $s1, 1             #               cnt = cnt + 1;
        andi    $s1, $s1, 0xFF          #               cnt = (cnt + 1) & 0xFF;
        j       endif3                  #
else:                                   #           else {
        addi    $s1, $s1, -1            #               cnt = cnt - 1;
        andi    $s1, $s1, 0xFF          #               cnt = (cnt + 1) & 0xFF;
endif3:                                 #           }
while:  bne     $s1, 'q', do            #       } while(c != 'q');
        lw      $ra, 0($sp)             #       repor $ra
        lw      $ra, 4($sp)             #       repor $s0
        lw      $ra, 8($sp)             #       repor $s1
        li      $v0, 0                  #       return 0;
        jr      $ra                     # }


wait:                                   # void wait(int ts) {
        li      $t1, 515000             #       const = 515000
        mul     $t1, $t1, $a0           #       const = 515000 * ts
        li      $t2, 0                  #       i = 0;
for:    bge     $t2, $t1, endfor        #       for(i=0; i < 515000 * ts; i++) {
        addi    $t2, $t2, 1             #               i++;
        j       for                     #       }
endfor:                                 #
        li      $v0, 0                  #       return 0;
        jr      $ra                     # }