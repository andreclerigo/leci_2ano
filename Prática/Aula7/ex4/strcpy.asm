	.text
	.globl strcpy
	
strcpy:					# char *strcpy(char *dst char *src) {
	move	$t2, $a0		#
do:					#	do {
	lb	$t1, 0($a1)		#		$t1 = src[i];
	sb	$t1, 0($a0)		#		dts[i] = src[i];
	addiu	$a0, $a0, 1
	addiu	$a1, $a1, 1
while:	bne	$t1, '\0', do		#	} while(src[i] != '\0');
	move	$v0, $t2		#	return dst;
	jr	$ra			# }	fim do programa
