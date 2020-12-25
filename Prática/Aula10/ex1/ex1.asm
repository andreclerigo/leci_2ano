	.data
	.eqv print_string, 4
	.eqv print_double, 3
	.eqv read_double, 7
	.eqv read_int, 5
str1:	.asciiz "\nQual o valor de X? "
str2:	.asciiz "\nQual o valor de Y? "
str3:	.asciiz "\nResultado: "
	.text
	.globl main

main:					# int main(void) {
	addiu	$sp, $sp, -4		# 	poem espaco na pilha
	sw	$ra, 0($sp)		#	guarda o $ra
					#
	la	$a0, str1		#	$a0 = str1
	li	$v0, print_string	#	$v0 = 4
	syscall				#	print_string(str1)
	li	$v0, read_double		#	$v0 = 7;
	syscall				#	read_double();
	mov.d	$f12, $f0		#	x = read_double();
					#
	la	$a0, str2		#	$a0 = str2
	li	$v0, print_string	#	$v0 = 4
	syscall				#	print_string(str2)
	li	$v0, read_int		#	$v0 = 5;
	syscall				#	read_int();
	move	$a0, $v0			#	y = read_int();
	
	jal	xtoy			#	xtoy(x, y);
	mov.d 	$f12, $f0		#	result = return(xtoy(x, y));
	
	la	$a0, str3		#	$a0 = str3
	li	$v0, print_string	#	$v0 = 4
	syscall				#	print_string(str3)
	li	$v0, print_double	#
	syscall				#	print_double(result);
					#	
	lw	$ra, 0($sp)		#	repoem o valor de $ra
	addiu	$sp, $sp, 4		#	repoem o tamanho da pilha
	li	$v0, 0			#	return 0;
	jr	$ra			# }
