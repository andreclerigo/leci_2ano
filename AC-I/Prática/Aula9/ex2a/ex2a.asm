	.data
str1:	.asciiz	"Temperatura em Fahrenheit: "
str2:	.asciiz "\nTemperatura em Celsius: "
	.text
	.globl main

main:				# int main(void) {
	addiu	$sp, $sp, -4	# 	poem espaco na pilha
	sw	$ra, 0($sp)	#	guarda o $ra
	
	la	$a0, str1	#	$a0 = str1
	li	$v0, 4		#
	syscall			#	print_string(str1);
				#
	li	$v0, 7		#	
	syscall			#	$f0 = read_double();
	mov.d	$f12, $f0	#	$f2 = $f0
	jal 	f2c		#	f2c(read_double());

	la	$a0, str2	#	$a0 = str2;
	li	$v0, 4		#	
	syscall			#	print_string(str2);
				#
	mov.d	$f12, $f0	#	$f12 = return(f2c);
	li	$v0, 3		#	
	syscall			#	print_double(return);
	lw	$ra, 0($sp)	#	repoem o valor de $ra
	addiu	$sp, $sp, 4	#	repoem o tamnhao da pilha
	li	$v0, 0		#	return 0;
	jr	$ra		# } fim do programa