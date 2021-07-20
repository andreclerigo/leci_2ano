	.data
str1:	.asciiz "Array"
str2:	.asciiz "de"
str3:	.asciiz "ponteiros"
	.align	2
array:	.word	str1, str2, str3
	.eqv	SIZE, 3
	.eqv	print_char, 11
	.eqv	print_string, 4
	.text
	.globl main
	
main:					# void main(void) {
	li 	$t0, 0			# 	int i = 0
	la	$t2, array		#	$t2 = &array[0]
while:	bge	$t0, SIZE, endw		# 	while(i < SIZE) {
	sll	$t1, $t0, 2		#		$t1 = i * 4;
	addu	$t3, $t2, $t1		#		$t3 = $(array[i]);
	lw	$t3, 0($t3)		#		$t3 = array[i];
	move 	$a0, $t3		#		$ao = array[i]
	li	$v0, print_string	#	
	syscall				#		print_string(array[i]);
	li	$a0, '\n'		#
	li	$v0, print_char		#
	syscall				#		print_chr('\n');
	addi	$t0, $t0, 1		#		i++
	j 	while			#	}
endw:					#
	jr 	$ra			# } fim do programa
	