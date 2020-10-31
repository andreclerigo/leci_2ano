# Mapa de registos
# num - $t0
# p - $t1
# *p - $t2
	
	.data
str:	.space 	20
	.eqv	SIZE, 20
	.eqv	read_string, 8
	.eqv	print_int10, 1
	.text
	.globl main

main:	li	$t0, 0			# num = 0;
	la	$a0, str		# buf = str
	li	$a1, SIZE		# length = SIZE
	li	$v0, read_string	# %v0 = 8
	syscall				# read_string()
	
	la 	$t1, str		# p = &str
while:	lb	$t2, 0($t1)		# *p = str
					#
condit:	beqz	$t2, endw		# while( *p != '\0') {
					#
if:	blt	$t2, '0', endif		# 	if( *p >= '0' &&
andd:	bgt	$t2, '9', endif		#	    *p <= '9') 
	addi	$t0, $t0, 1		# 		num++;
endif:	addi	$t1, $t1, 1             #	p++;
	j	while			# }
endw:	move	$a0, $t0		#
	li	$v0, print_int10	#
	syscall				# print_int10(num)
	jr	$ra			# fim do programa

	
