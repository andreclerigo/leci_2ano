	.text
	.globl divv

# Mapa de Registos
# $t0 - i
# $t1 - bit
# $t2 - quociente
# $t3 - resto
# $t4 - dividendo
# $t5 - divisor

divv:					# unsigned int divv(unsigned int dividendo, unsigned int divisor) {
	move	$t4, $a0		#	dividendo - $a0;
	move 	$t5, $a1		#	divisor - $a1;
	sll	$t5, $t5, 16		#	divisor = divisor << 16;
	andi	$t4, $t4, 0xFFFF	#	dividendo = dividendo &0xFFFF;
	sll	$t4, $t4, 1		#	dividendo = (dividendo &0xFFFF) << 1;
	li	$t0, 0			#	i = 0;
for:	bge	$t0, 16, endfor		#	for(i = 0; i < 16; i++) {
	li	$t1, 0			#		bit = 0;
if:	blt	$t4, $t5, endif		#		if(dividendo >= divisor) {
	sub	$t4, $t4, $t5		#			dividendo = dividendo - divisor;
	li	$t1, 1			#			bit = 1;
endif:					#		}
	sll	$t4, $t4, 1		#		dividendo = dividendo << 1;
	or	$t4, $t4, $t1		#		dividendo = (dividendo << 1) | bit;
	addi	$t0, $t0, 1		#		i++;
	j	for			#	}
endfor:					#
	srl	$t3, $t4, 1		#	resto = dividendo >> 1;
	andi	$t3, $t3, 0xFFFF0000	#	resto = (dividendo >> 1) & 0xFFFF0000;
	andi	$t2, $t4, 0xFFFF	#	quociente = dividendo & 0xFFFF;
	or	$v0, $t3, $t2		#	return (resto | quociente);
	jr	$ra			# }