	.data
x0:	.double 0.0
	.text
	.globl var
	
# Mapa de registos
# $t0 - i
# $t1 - &array
# $t2 - i*8
# $t3 - &(array[i])
# $f2 - soma
# $f4 - media
# $f12 - array[i] - media
# $f0 - res
	
#ESTE EXERCICIO NAO ESTA BEM FEITO
var:					# double var(double *array, int nval) {
	addiu	$sp, $sp, -4		# 	poem espaco na pilha
	sw	$ra, 0($sp)		#	guarda o $ra
					#
	la	$t0, x0			#	$t0 = &x0
	l.d	$f2, 0($t0)		#	$f2 = x0;
	li	$t0, 0			#	i = 0;
	jal	average			#	average(array, nval);
	mov.d	$f4, $f0			#	media = average(array, nval);
	move	$t1, $a0			#	$t1 = &array
					#	
for:	bge	$t0, $a1, endfor	#	for(i = 0, soma = 0.0; i < nval; i++) {
	sll	$t2, $t0, 3		#		i = i * 8;
	addu	$t3, $t1, $t2		#		$t3 = &(array[i])
	l.d	$f12, 0($t3)		#		$f12 = array[i]
	sub.d	$f12, $f12, $f4		#		$f12 = array[i] - media;
	li	$a0, 2			#		$a0 = 2
	jal	xtoy			#		xtoy(array[i]-media, 2);
	add.d	$f2, $f2, $f0		#		soma += return(xtoy(array[i]-media, 2))
	addi	$t0, $t0, 1		#		i++;
	j	for			#	}
endfor:					#
					#
	lw	$ra, 0($sp)		#	repoem o valor de $ra
	addiu	$sp, $sp, 4		#	repoem o tamanho da pilha
	jr	$ra			# } fim do programa
