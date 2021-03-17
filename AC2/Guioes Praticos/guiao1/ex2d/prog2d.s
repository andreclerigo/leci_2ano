        .equ readInt10, 5
        .equ printInt10, 7
        .equ printStr, 8
        .equ printInt, 6
        .data
str1:   .asciiz "\nIntroduza um numero (sinal e modulo): "
str2:   .asciiz "\nValor lido, em base 2: "
str3:   .asciiz "\nValor lido, em base 16: "
str4:   .asciiz "\nValor lido, em base 10 (unsigned): "
str5:   .asciiz "\nValor lido, em base 10 (signed): "
        .text
        .globl main

main:                                        # int main(void) {
while:  bne     $0, $0, endw                 #     while(true) {
        la      $a0, str1                    #         
        li      $v0, printStr                #
        syscall                              #         printStr("\nIntroduza um numero (sinal e modulo): ");
        li      $v0, readInt10               #         
        syscall                              #         value = readInt();
        move    $t1, $v0                     #         value = $v0;

        la      $a0, str2                    #         
        li      $v0, printStr                #
        syscall                              #         printStr("\nValor lido, em base 2: ");
        move    $a0, $t1                     #
        li      $a1, 2                       #         printInt(value, 2);
        li      $v0, printInt                #
        syscall

        la      $a0, str3                    #
        li      $v0, printStr                #
        syscall                              #         printStr("\nValor lido, em base 16: ");
        move    $a0, $t1                     #
        li      $a1, 16                      #         printInt(value, 16);
        li      $v0, printInt                #
        syscall

        la      $a0, str4                    #
        li      $v0, printStr                #
        syscall                              #         printStr("\nValor lido, em base 10 (unsigned): ");
        move    $a0, $t1                     #
        li      $a1, 10                      #         printInt(value, 10);
        li      $v0, printInt                #
        syscall

        la      $a0, str5                    #
        li      $v0, printStr                #
        syscall                              #         printStr("\nValor lido, em base 10 (signed): ");
        move    $a0, $t1                     #
        li      $v0, printInt10              #         printInt10(value);
        syscall                              #
        j       while                        #
endw:                                        #     }
        li      $v0, 0                       #     return 0;
        jr      $ra                          # }   fim do programa