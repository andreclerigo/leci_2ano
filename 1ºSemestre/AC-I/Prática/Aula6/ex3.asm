	.data
str1:	.asciiz "Array"
str2:	.asciiz "de"
str3:	.asciiz "ponteiros"
str4:	.asciiz "\nString #"
str5:	.asciiz  ": "
	.align	2
array:	.word	str1, str2, str3
	.eqv	SIZE, 3
	.eqv	print_char, 11
	.eqv	print_int10, 1
	.eqv	print_string, 4
	.text
	.globl main

# Mapa de Registos
# $t0 - i
# $t1 - SIZE
# $t2 - j
# $t3 - array[i]
# $t4 - i*4
# $t6 - array

main:					#void main(void) {
	li	$t0, 0			#	int i = 0;
	li	$t1, SIZE		#	$t1 = SIZE;
	la	$t6, array		#	
while:	beq	$t0, $t1, endw		#	while( i < SIZE ) {
	la	$a0, str4		#		
	li	$v0, print_string	#
	syscall				#		print_string("\nString #");
	move	$a0, $t0		#		$a0 = i;
	li	$v0, print_int10	#
	syscall				#		print_int10(i);
	la	$a0, str5		#		$a0 = ": ";
	li	$v0, print_string	#
	syscall				#		print_string(": ");
	li	$t2, 0			#		int j = 0;
while2:	sll	$t4, $t0, 2		#		$t4 = i * 4;
	addu	$t3, $t6, $t4		#		$t3 = &(array[i]);	
	lw	$t3, 0($t3)		#		$t3 = array[i];
	addu	$t3, $t3, $t2		#		$t3 = &array[i][j];
	lb	$t3, 0($t3)		#		$t3 = array[i][j];
	beq	$t3, '\0', endw2	#		while(array[i][j] != '\0') {
	move	$a0, $t3		#
	li	$v0, print_char		#
	syscall				# 			print_char(array[i][j]);
	li	$a0, '-'		#			
	li	$v0, print_char		#
	syscall				#			print_char('-');
	addi	$t2, $t2, 1		#			j++;
	j 	while2			#		}
endw2:		
	addi	$t0, $t0, 1		#		i++;
	j	while			# 	}
endw:					#
	jr	$ra			# } fim do programa
	