	.data
	.eqv	print_intu10, 36
	.eqv 	print_string, 4
	.eqv	read_int, 5
str1:	.asciiz "Introduza o dividendo: "
str2:	.asciiz "\nIntroduza o divisor: "
str3:	.asciiz "\nResultado: "
	.text
	.globl main

# Mapa de Registos
# $t0 - dividendo
# $t1 - divisor

main:					# int main(void) {
	addiu	$sp, $sp, -4		#	fazer espaco na pilha
	sw	$ra, 0($sp)		#	guardar o $ra na pilha
	la	$a0, str1		#	$a0 = str1;
	li	$v0, print_string	#
	syscall				#	print_string(str1);
	li	$v0, read_int		#	
	syscall				#	read_int();
	move	$t0, $v0		#	dividendo = read_int();
					#
	la	$a0, str2		#	$a0 = str2;
	li	$v0, print_string	#
	syscall				#	print_string(str2);
	li	$v0, read_int		#	
	syscall				#	read_int();
	move	$t1, $v0		#	divisor = read_int();
					#
	move	$a0, $t0		#	$a0 = dividendo;
	move	$a1, $t1		#	$a1 = divisor;
	jal	divv			#	div(dividendo, divisor);
	move	$t2, $v0		#	$t2 = return div(dividendo, divisor);
					#
	la	$a0, str3		#	$a0 = str3;
	li	$v0, print_string	#
	syscall				#	print_string(str3);
					#
	move	$a0, $t2		#	$a0 = return div(dividendo, divisor);
	li	$v0, print_intu10	#	
	syscall				#	print_intu10(return);
	li	$v0, 0			#	return 0;
	lw	$ra, 0($sp)		#	repor o valor de $ra
	addiu	$sp, $sp, 4		#	repor o tamanho da pilha
	jr	$ra			# }