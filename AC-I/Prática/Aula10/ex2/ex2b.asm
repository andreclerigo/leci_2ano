	.data
str1:	.asciiz "Valor de X: "
str2:	.asciiz "\nResultado: "
	.eqv print_string, 4
	.eqv read_double, 7
	.eqv print_double, 3
	.text
	.globl main
	
main:					# int main(void) {
	addiu	$sp, $sp, -4		# 	poem espaco na pilha
	sw	$ra, 0($sp)		#	guarda o $ra
					#
	la	$a0, str1		#	$a0 = str1
	li	$v0, print_string	#	$v0 = 4
	syscall				#	print_string(str1);
	li	$v0, read_double	#	$v0 = 3;
	syscall				#	read_double();
	mov.d	$f12, $f0		#	val = read_double;
	jal	sqrt			#	xtoy(val)
	la	$a0, str2		#	$a0 = str2;
	li	$v0, print_string	#	$v0 = 4
	syscall				#	prin_string(str2);
	mov.d	$f12, $f0		#
	li	$v0, print_double	#	print_double(return(xtoy(val)));
	syscall	
					#
	lw	$ra, 0($sp)		#	repoem o valor de $ra
	addiu	$sp, $sp, 4		#	repoem o tamnhao da pilha
	li	$v0, 0			#	return 0;
	jr	$ra			# }
	