# Mapa de registos:
# str: $a0 -> $s0 (argumento é passado em $a0)
# p1: $s1 (registo callee-saved)
# p2: $s2 (registo callee-saved)

strrev: 				# char * strrev(char *str) {
	addiu 	$sp, $sp, -16 		# 	reserva espaço na stack
 	sw 	$ra, 0($sp) 		# 	guarda endereço de retorno
	sw 	$s0, 4($sp) 		# 	guarda valor dos registos
	sw 	$s1, 8($sp) 		# 	$s0, $s1 e $s2
	sw 	$s2, 12($sp) 		#
	move 	$s0, $a0 		# 	registo "callee-saved"
	move 	$s1, $a0 		# 	p1 = str
	move 	$s2, $a0 		# 	p2 = str
while1: lb	$t1, 0($s2)		#	$t1 = *p2;
	beq	$t1, '\0', endw1	# 	while( *p2 != '\0' ) {
	addiu	$s2, $s2, 1 		# 		p2++;
	j 	while1 			# 	}
endw1:	addiu	$s2, $s2, -1 		# 	p2--;
while2: bge	$s1, $s2, endw2		# 	while(p1 < p2) {
	move 	$a0, $s1 		#
	move 	$a1, $s2		#
 	jal 	exchange 		# 		exchange(p1,p2);
 	addiu	$s1, $s1, 1
 	addiu	$s2, $s2, -1
	j 	while2 			# 	}
endw2:	move 	$v0, $s0 		# 	return str
	lw 	$ra, 0($sp) 		# 	repõe endereço de retorno
 	lw 	$s0, 4($sp) 		# 	repõe o valor dos registos
	lw 	$s1, 8($sp)		# 	$s0, $s1 e $s2
	lw 	$s2, 12($sp) 		#
	addiu 	$sp, $sp, 16		# 	liberta espaço da stack
	jr 	$ra 			# }	termina a sub-rotina
	
exchange:				# void cxchange(char *c1, char *c2) {
	lb	$t0, 0($a0)		#	$t0 = *c1:
	lb	$t1, 0($a1)		#	$t1 = *c2;
	sb	$t0, 0($a1)
	sb	$t1, 0($a0)
	jr	$ra			# } fim do programa
	
