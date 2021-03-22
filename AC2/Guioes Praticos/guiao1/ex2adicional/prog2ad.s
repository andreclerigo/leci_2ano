        .equ STR_MAX_SIZE, 20
        .equ printStr, 8
        .equ readStr, 9
        .equ printInt, 6
        .equ printInt10, 7
        .data
s1:     .asciiz "Introduza 2 strings: "
s2:     .asciiz "Resultados:\n"
str1:   .space 21
str2:   .space 21
str3:   .space 41
        .text
        .globl main

main:                                   # int main(void) {
        addiu   $sp, $sp, -             #      abrir espaco na pilha
        sw      $ra, 0($sp)             #      salvaguarda $ra


        

        lw      $ra, 0($sp)             #      repor valor de $ra
        addiu   $sp, $sp,               #      repor espaco na pilha
        li      $v0, 0                  #      return 0;
        jr      $ra                     # }


strlen:                                 # int strlen(char *s) {
        move    $t1, $a0                #      $t1 = &s
        li      $t0, 0                  #      len = 0;
        li      $v0, 0                  #      $v0 = 0;
for:    lb      $t2, 0($t1)             #      $t2 = *s
        beq     $t2, '\0', endfor       #      for(len = 0; *s != '\0'; len++, s++) {
        addiu   $t1, $t1, 1             #          $t1++;   //next position of string
        addi    $v0, $v0, 1             #          len++;
        j       for                     #      }
endfor:                                 #      
        jr      $ra                     # }


strcpy:                                 # char *strcpy(char *dst, char *src) {
        move    $v0, $a0                #      $v0 = dst;
        move    $t0, $a0                #
        move    $t1, $a1                #
for2:   
endfor2:
        jr      #ra                     # }


strcmp: