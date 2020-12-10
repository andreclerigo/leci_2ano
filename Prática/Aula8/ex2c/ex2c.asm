	.data
	.eqv	read_int, 5
	.eqv	print_string, 4
str1:	.asciiz "Introduza o valor: "
str2:	.asciiz "Introduza a base: "
str3:	.asciiz "\n"
	.text
	.globl main
	
main:					# int main(void) {
	addiu	$sp, $sp, -4		#	por espaco na pilha
	sw	$ra, 0($sp)		#	salvar o valor de $
					#
	la	$a0, str1		#	$a0 = str1
	li	$v0, print_string	#
	syscall				#	print_string(str1);
	li	$v0, read_int		#	
	syscall				#	$v0 = read_int();
	move	$t0, $v0		#	$a0 = read_int();
					#
	la	$a0, str3		#	$a0 = str3
	li	$v0, print_string	#
	syscall				#	print_string(str3);
					#
	la	$a0, str2		#	$a0 = str2
	li	$v0, print_string	#
	syscall				#	print_string(str2);
	li	$v0, read_int		#	
	syscall				#	$v0 = read_int();
	move	$t1, $v0		#	$a0 = read_int();
					#
	la	$a0, str3		#	$a0 = str3
	li	$v0, print_string	#
	syscall				#	print_string(str3);
					#
	move	$a0, $t0		#	val = $t0
	move	$a1, $t1		#	base = $t1
	jal	print_int_ac1		#	print_int_10(val, base);
					#
	lw	$ra, 0($sp)		#	repor o valor de $ra
	addiu	$sp, $sp, 4		# 	repor o tamanho da pilha
	jr	$ra			# } fim do programa