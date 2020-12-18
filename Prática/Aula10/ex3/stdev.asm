	.text
	.globl stdev
	
stdev:				# double stdev(double *array, int nval) {
	addiu	$sp, $sp, -4	# 	poem espaco na pilha
	sw	$ra, 0($sp)	#	guarda o $ra
				#	
	jal	var		#	var(double *array, int nval);
	mov.d	$f12, $f0	#	arg = return
	jal	sqrt		#	sqrt(var(double *array, int nval))
				#	
	lw	$ra, 0($sp)	#	repoem o valor de $ra
	addiu	$sp, $sp, 4	#	repoem o tamanho da pilha
	jr	$ra		# } fim do programa
