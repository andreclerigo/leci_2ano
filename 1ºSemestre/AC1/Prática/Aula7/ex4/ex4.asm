	.data
str1:	.asciiz	"Arquitetura de "
str2:	.space	50
str4:	.asciiz "Computadores I"
str3:	.asciiz "\n"

	.text
	.globl main
	
main: 
	addiu	$sp, $sp, -4
	sw	$ra, 0($sp)
	
	la	$a0, str2
	la	$a1, str1
	jal	strcpy
	
	move	$a0, $v0
	li	$v0, 4
	syscall
	
	la	$a0, str3
	li	$v0, 4
	syscall
	
	la	$a0, str2
	la	$a1, str4
	jal	strcat
	move	$a0, $v0
	li	$v0, 4
	syscall
	
	li	$v0, 0
	lw	$ra, 0($sp)
	addiu	$sp, $sp, 4
	jr	$ra