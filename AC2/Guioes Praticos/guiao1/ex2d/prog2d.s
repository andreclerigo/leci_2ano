        .equ readInt10, 4
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

main:                                    # int main(void) {
while:  bne $0, $0, endw                 #     while(true) {
        
endw: