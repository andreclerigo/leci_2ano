	.data
str1:	.asciiz "Nr. de parametros: "
str2:	.asciiz "\nP"
str3:	.asciiz  ": "
	.eqv	print_int10, 1
	.eqv	print_string, 4
	.text
	.globl main
	
# Mapa de Registos
# $t0 - i
# $t1 - argc
# $t2 - argv;
# $t3 - i*4;
# $t4 - argv[i]
	
main:					# int main(int argc, char*argv[]) {
	li	$t0, 0			#	int i = 0;
	move	$t1, $a0		#	$t1 = argc
	move	$t2, $a1		#	$t2 = &(argv[0]);
	la	$a0, str1		#	$a0 = str1;
	li	$v0, print_string	#
	syscall				#	print_string(str1);
	move	$a0, $t1		#	$a0 = $t1;
	li	$v0, print_int10	#	
	syscall				#	print_int10(argc);
while:	bge	$t0, $t1, endw		# 	while( i < argc ) {
	la	$a0, str2		#		$a0 = str2;
	li	$v0, print_string	#
	syscall				#		print_string(str2);
	move	$a0, $t0		#		$a0 = i;
	li	$v0, print_int10	#
	syscall				#		print_int10(i);
	la	$a0, str3		#		$a0 = str3;
	li	$v0, print_string	#
	syscall				#		print_string(str3);
	sll	$t3, $t0, 2		#		$t3 = i *4;
	addu	$t4, $t2, $t3		#		$t4 = &(array[i*4]);
	lw	$t4, 0($t4)		#		$t4 = array[i*4];
	move	$a0, $t4		#		$a0 = array[i*4];
	li	$v0, print_string	#	
	syscall				#		print_string(argv[i]);
	addi	$t0, $t0, 1		#	i++;
	j	while			# 	}
endw:	
	li	$v0, 0			#	return 0;
	jr	$ra			# } fim do programa