	.data
	.eqv SIZE, 10
a:	.space 80
	.text
	.globl main

# Mapa de registos
# $t0 - i
# $t1 - &a;
# $t2 - aux;
# $t3 = &(a[i]);
		
main:					# int main(void) {
	addiu	$sp, $sp, -4		# 	poem espaco na pilha
	sw	$ra, 0($sp)		#	guarda o $ra
	la	$t1, a			#	$t1 = &a;
	li	$t0, 0			#	i = 0;
for:	bge	$t0, SIZE, endfor	#	for(i = 0; i < SIZE; i++) {
	sll	$t2, $t0, 3		#		aux = i*8;
	addu	$t3, $t1, $t2		#		$t3 = &(a[i]);
	
	li	$v0, 5			#		$v0 = 5;
	syscall				#		$v0 = read_int();
	mtc1	$v0, $f2			#		$f2 = $v0
	cvt.d.w	$f2, $f2			#		$f2 = (double)$v0
	s.d	$f2, 0($t3)		#		a[i} = (double)$v0;
	
	addi	$t0, $t0, 1		#		i++;
	j	for			#	}
endfor:	la	$a0, a			#	$a0 = a;
	li	$a1, SIZE		#	$a1 = SIZE;
	jal	average			#	average(a, SIZE);
	mov.d	$f12, $f0		#	$f12 = $f0
	li	$v0, 3			#	$v0 = 3;
	syscall				#	print_double();
					#
	lw	$ra, 0($sp)		#	repoem o valor de $ra
	addiu	$sp, $sp, 4		#	repoem o tamnhao da pilha
	li	$v0, 0			#	return 0;
	jr	$ra			# } fim do programa