	.text
	.globl strcat
	
strcat:						# char *strcat(char *dst, char *src) {
	addiu	$sp, $sp, -8			# 	reservar espaco na pilha
	sw	$ra, 0($sp)			# 	salvaguardar $ra
	sw	$s0, 4($sp)			#
	move	$s0, $a0				#	$t0 = &(dst)
while:	lb	$t0, 0($a0)			#	*p = dst[0]
	beq	$t0, '\0', endw			#	while(*p != '\0') {
	addiu	$a0, $a0, 1			#		p++;
	j	while				#	}
endw:						#
	jal	strcpy				#	strcpy(&dst[fim], src)	
	move	$v0, $s0				#
	lw	$ra, 0($sp)			#	repor $ra na pilha
	lw	$s0, 4($sp)			#	
	addiu	$sp, $sp, 8			#	restabelecer tamanho da pilha
	jr	$ra				# } fim do programa