# Mapa de registos
# n: $a0 -> $s0
# b: $a1 -> $s1
# s: $a2 -> $s2
# p: $s3
# digit: $t0
# Sub-rotina intermédia 
	.text
	.globl itoa
itoa:					# char *itoa(unsigned int n, unsigned int b, char *s) {
	addiu	$sp, $sp, -20		#	meter espaco na pilha
	sw	$ra, 0($sp)		#	guardar o $ra na pilha
	sw	$s0, 4($sp)		#	guardar registos $sX na pilha
	sw	$s1, 8($sp)		#
	sw	$s2, 12($sp)		#
	sw	$s3, 16($sp)		#
					#	passa n, b e s para callee-saved
	move	$s0, $a0		# 	s0 = n
	move	$s1, $a1		#	s1 = b
	move	$s2, $a2		#	s2 = s
	move	$s3, $a2		#	s3 = s
	
do:					#	do{
	rem	$t0, $s0, $s1		#		digit = n % b;
	div	$s0, $s1		#		n/b;
	mflo	$s0			#		n = n/b
	move	$a0, $t0		#		$a0 = digit
	jal	toascii			#		toascii(digit)
	sb	$v0, 0($s3)		#		*p = return toascii(digit)
	addiu	$s3, $s3, 1		#		p++;
while:	bgt	$s0, 0, do		#	while(n > 0);
	sb	$0, 0($s3)		#	*p = '\0';
	move	$a0, $s2		#	$a0 = s;
	jal	strrev			#	strrev(s);
	move	$v0, $s2		#
					#
	lw	$ra, 0($sp)		#	ir buscar o $ra
	lw	$s0, 4($sp)		#	repor registos $sX na pilha
	lw	$s1, 8($sp)		#
	lw	$s2, 12($sp)		#
	lw	$s3, 16($sp)		#
	addiu 	$sp, $sp, 20		#	repor o tamanho da pilha
	jr	$ra			# } fim do programa
