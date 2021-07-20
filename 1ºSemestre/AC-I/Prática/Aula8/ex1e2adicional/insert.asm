	.text
	.globl insert

# Mapa de Registos
# $t0 - len_dst
# $t1 - len_src
# $t2 - i

insert:						# char *insert(char *dst, char *src, int pos) {
	addiu	$sp, $sp, -4			#	abir espaco na pilha
	sw	$ra, 0($sp)			#	guardar valor na pilha
	move	$s0, $a0			#	$s0 = dst
	move	$s1, $a1			#	$s1 = src
						#	
	jal	strlen				#	strlen(dst)
	move	$t0, $v0			#	len_dst = strlen(dst);
	move	$a0, $s1			#	
	jal	strlen				#	strlen(src)
	move	$t1, $v0			#	len_src = strlen(src);
	
if:	bgt	$a2, $t0, endif			#	if (pos <= len_dst) {
	move	$t2, $t0			#		i = len_dst;
for:	blt	$t2, $a2, endor			#		for(i = len_dst; i >= pos; i--) {
	
	addi	$t2, $t2, -1			#			i--;
	j	for				#		}
endfor:	
endif:						#	}
	
	lw	$ra, 0($sp)			#	repor valor de $ra
	addiu	$sp, $sp, 4			#	repor tamanho da pilha
	jr	$ra				# } fim do programa