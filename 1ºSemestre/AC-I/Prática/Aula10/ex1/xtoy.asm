	.data
x0:	.double 1.0
	.text
	.globl xtoy

# Mapa de Registos
# $s0 - i
# $s1 - y
# $f20 - result
# $f22 - x

xtoy:					# double xtoy(double x, int y) {
	addiu	$sp, $sp, -28		# 	poem espaco na pilha
	sw	$ra, 0($sp)		#	guarda o $ra
	sw	$s0, 4($sp)		#	guarda o $s0
	sw	$s1, 8($sp)		#	guarda o $s1
	s.d	$f20, 12($sp)		#	guarda o $f20
	s.d	$f22, 20($sp)		#	guarda o $f22
	
	li	$s0, 0			#	i = 0;
	la	$t0, x0			#	$t0 = &x0;
	l.d	$f20, 0($t0)		#	$f20 = res = 1.0;
	move	$s1, $a0			#	$s1 = y
	mov.d  	$f22, $f12		#	$f22 = x
	move	$a0, $s1
	jal	abss			#	abss(y);
	move	$t1, $v0			#	$t1 = return(abs(y))
for:	bge	$s0, $t1, endfor 	#	for(i = 0, result = 1.0; i < abs(y); i++) {
if:	ble	$s1, 0, else		#		if(y > 0) {
	mul.d	$f20, $f20, $f22		#			result *= x;
	j	endif			#			
else:					#		else {
	div.d	$f20, $f20, $f22		#			result /= x;
endif:					#		}
	addi	$s0, $s0, 1		#		i++;
	j	for			#	}
endfor:					#
	mov.d	$f0, $f20		#	return result;
	lw	$ra, 0($sp)		#	repoem o valor de $ra
	lw	$s0, 4($sp)		#	repoem o $s0
	lw	$s1, 8($sp)		#	repoem o $s1
	l.d	$f20, 12($sp)		#	repoem o $f20
	l.d	$f22, 20($sp)		#	repoem 0 $f22
	addiu	$sp, $sp, 28		#	repoem o tamnhao da pilha

	jr	$ra			# } fim do programa
