	.data
str1:	.asciiz "Ola o meu nome e Andre\n"
str2:	.asciiz "AC1 - P"
	.text
	.globl main
main:	ori $v0, $0, 4
	#la  $a0, str1
	#syscall
	la  $a0, str2
	syscall
	jr $ra