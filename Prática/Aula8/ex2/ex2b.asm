	.data
	.eqv	MAX_STR_SIZE, 33# dfines MAX_STR_SIZE 33
	.eqv	read_int, 5
	.eqv	print_string, 4
str:	.space 	33
str1:	.asciiz "\n"	
	.text
	.globl 	main

main:					# int main(void) {
	addiu	$sp, $sp, -8		#
	sw	$ra, 0($sp)		#
	sw	$s0, 4($sp)		#
do:					#	do {
	li	$v0, read_int		#		$v0 = read_int;
	syscall				#		read_int();
	move	$s0, $v0		#		val = read_int();
	
	move	$a0, $s0		#
	li 	$a1, 2			#
	la	$a2, str		#
	jal	itoa			#		itoa(val, 2, str);
	move	$a0, $v0		#
	li	$v0, print_string	#	
	syscall				#		print_string(itoa(val, 2, str));
	
	li	$v0, print_string
	la	$a0, str1
	syscall
	
	move	$a0, $s0		#
	li 	$a1, 8			#
	la	$a2, str		#
	jal	itoa			#		itoa(val, 8, str);
	move	$a0, $v0		#
	li	$v0, print_string	#	
	syscall				#		print_string(itoa(val, 8, str));

	li	$v0, print_string
	la	$a0, str1
	syscall
	
	move	$a0, $s0		#
	li 	$a1, 16			#
	la	$a2, str		#
	jal	itoa			#		itoa(val, 16, str);
	move	$a0, $v0		#
	li	$v0, print_string	#	
	syscall				#		print_string(itoa(val, 16, str));
	
	li	$v0, print_string
	la	$a0, str1
	syscall
	
while:	bne	$s0, 0, do		# 	while(val != 0);
	
	li	$v0, 0			#
	lw	$ra, 0($sp)		#
	lw	$s0, 0($sp)		#
	addiu	$sp, $sp, 8		#
	jr	$ra			# }
