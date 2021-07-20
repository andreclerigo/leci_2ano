# Mapa de registos
# res: $v0
# s: $a0
# *s: $t0
# digit: $t1
# Sub-rotina terminal: não devem ser usados registos $sx 

atoi: 					# unsigned int atoi(char *s) {
	li	$v0, 0			# 	res = 0;
while:	lb	$t0, 0($a0)		#	*s = s[0];
	blt	$t0, '0', endw		#	while(*s >= '0' &&
	bgt	$t0, '9', endw		#	      *s <= '9') {
	addi	$t1, $t0, -0x30		#		digit = *s -'0'
	addiu	$a0, $a0, 1		#		s++;
	mul	$v0, $v0, 10		#		res = 10 * res;
	add	$v0, $v0, $t1		#		res = res + digit;
	j	while			# 	}
endw:					# 
	jr	$ra			# } fim do programa