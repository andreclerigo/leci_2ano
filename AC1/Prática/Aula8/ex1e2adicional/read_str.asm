	.data
	.eqv	read_string, 8
	.text
	.globl read_str

read_str:				# void read_str(char *s, int size) {
	addiu	$sp, $sp, -8		#	abir espaco na pilha
	sw	$ra, 0($sp)		#	guardar valor na pilha
	sw	$s0, 4($sp)		#	
					#
	li	$v0, read_string	# 	$v0 = 8;
	move	$s0, $a0		#	
	syscall				# 	read_string(s, size);
	move	$a0, $s0		#	
	jal	strlen			#	strlen(s)
	move	$t0, $v0		#	len = strlen(s);
	addi	$t1, $t0, -1		#	$t1 = len-1;
	addiu	$t1, $s0, $t1		#	$t1 = &(s[len-1]);
	lb	$t2, 0($t1)		#	$t2 = s[len-1];
if:	bne	$t2, 0x0A, endif	#	if(s[len-1] == 0x0A) {
	sb	'\0', 0($t2)		#		s[len-1] = '\0';
endif:					#	}
	lw	$ra, 0($sp)		#	repor valor de $ra
	lw	$s0, 4($sp)		#	
	addiu	$sp, $sp, 8		#	repor tamanho da pilha
	jr	$ra			# }