	.text
	.globl max

max:				# double max(double *p, unsigned int n) {
	move	$t0, $a0		#	$t0 = &(p)
	move	$t1, $a1		#	$t1 = n
	addi	$t1, $t1, -1	#	n = n -1;
	sll	$t1, $t1, 3	#	n = (n-1)*8;
	addu	$t2, $t0, $t1	#	u = &(p[n-1]);
	l.d	$f0, 0($t0)	#	max = *p;
	addiu	$t0, $t0, 8	#	p++;
for:	bgt	$t0, $t2, endfor	#	for(; p <= u; p++) {
	l.d	$f2, 0($t0)	#		$f2 = *p;
if:	c.le.d	$f2, $f0		#		*p <= max
	bc1t	endif		#		if(*p > max) {
	mov.d	$f0, $f2		#			max = *p;
endif:				#		}
	addiu	$t0, $t0, 8	#		p++;
	j	for		#	}
endfor:				#
	jr	$ra		# } fim do programa
