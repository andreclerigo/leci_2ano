strcat:						# char *strcat(char *dst, char *src) {
	addiu	$sp, $sp, -8			#
	sw	$ra, 0($sp)			#
	sw	$s0, 4($sp)			#
						#
	move	$t0, $a0
	move 	$t1, $a1
						#
	lw	$ra, 0($sp)			#
	lw	$s0, 4($sp)			#
	addiu	$sp, $sp, 8			#
	jr	$ra				# }
	
strcpy:					# char *strcpy(char *dst char *src) {
	li	$t0, -1			#	int i = 0;
	move	$t2, $a0		#
do:					#	do {
	addi	$t0, $t0, 1		#		i++;
	addu	$a0, $a0, $t0		#		$a0 = &(dst[i]);
	lb	$t1, 0($a1)		#		$t1 = src[i];
	sb	$t1, 0($a0)		#		dts[i] = src[i];
while:	bne	$t1, '\0', do		#	} while(src[i] != '\0');
	move	$v0, $t2		#	return dst;
	jr	$ra			# }	fim do programa