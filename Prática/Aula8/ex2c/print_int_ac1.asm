	.data
buf:	.space 33
	.text
	.globl print_int_ac1
	
print_int_ac1:				# void print_int_ac1(unsigned int val, unsigned int base) {
	addiu	$sp, $sp, -4		#	por espaco na pilha
	sw	$ra, 0($sp)		#	salvar o valor de $ra
					#
	la	$a2, buf		#	$a2 = buf;
	jal	itoa			#	itoa(val, base, buf);
	move	$a0, $v0		#	$a0 = return itoa(val, base, buf)
	li	$v0, 4			#	$v0 = 4
	syscall				#	print_string(return);
					#
	lw	$ra, 0($sp)		#	repor o valor de $ra
	addiu	$sp, $sp, 4		# 	repor o tamanho da pilha
	jr	$ra			# } fim do programa
