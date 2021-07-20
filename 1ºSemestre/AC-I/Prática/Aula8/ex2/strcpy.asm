	.text
	.globl strcpy

strcpy:					# char *strcpy(char *dst char *src) {
	li	$t0, -1			#	int i = 0;
	move	$t2, $a0			#
do:					#	do {
	addi	$t0, $t0, 1		#		i++;
	addu	$a0, $a0, $t0		#		$a0 = &(dst[i]);
	lb	$t1, 0($a1)		#		$t1 = src[i];
	sb	$t1, 0($a0)		#		dts[i] = src[i];
while:	bne	$t1, '\0', do		#	} while(src[i] != '\0');
	move	$v0, $t2			#	return dst;
	jr	$ra			# }	fim do programa
