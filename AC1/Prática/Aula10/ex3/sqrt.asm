	.data
x0:	.double 1.0
x1:	.double 0.5
x2:	.double 0.0
	.text
	.globl sqrt

# Mapa de Registos
# $f12 - val
# $f2 - aux
# $f4 - xn
# $f6 = 0.5
# $t0 - i

sqrt:				# double sqrt(double val) {
	la	$t0, x0		#	$t0 = &x0
	l.d	$f4, 0($t0)	#	xn = 1.0;
	la	$t0, x1		#	$t0 = &x1;
	l.d	$f6, 0($t0)	#	$f6 = 0.5
	la	$t0, x2
	l.d	$f8, 0($t0)
	li	$t0, 0		#	i = 0;
	
if:	c.le.d	$f12, $f8	#	if(val > 0.0) {
	bc1t	else		#
do:				#		do {
	mov.d	$f2, $f4	#			aux = xn
	div.d	$f4, $f12, $f2	#			xn = val/xn
	add.d	$f4, $f4, $f2	#			xn = (val/xn + xn)
	mul.d	$f4, $f6, $f4	#			xn = 0.5 * (xn + val/xn)
while:	c.eq.d	$f2, $f4	#		} while((aux != xn) 
	bc1t	endif		#			&&
andd:	addi	$t0, $t0, 1	#			++i
	blt	$t0, 25, do	#			   < 25));	
	j	endif		#	
else:				#	else {
	mov.d	$f4, $f8	#		xn = 0.0;
endif:				#	}
	mov.d	$f0, $f4	# 	return xn;
	jr	$ra		# } fim do programa