# Mapa de Registos
# array - $t0  -- endereco
# i - $t1
# str[iultimo] - $t2
# soma - $t3
# size-1 - $t4
# array[i] - $t5  -- valor

	.data
array:	.word	7692,23,5,234
	.eqv	print_int10, 1
	.eqv	SIZE, 4
	.text
	.globl main

main:	li	$t3, 0			# soma = 0
	li	$t1, 0			# i = 0
	li 	$t4, SIZE		#
	sub	$t4, $t4, 1		# $t4 = 3
	sll	$t4, $t4, 2		# $t4 = $t4 * 4
	la	$t0, array		# $t0 = array;
	addu	$t2, $t0, $t4		# iultimo = array + SIZE-1		
					#
while:	la	$t0, array		# $t0 = array;
	add	$t0, $t0, $t1		# &str[i] = str + 1
	lw	$t5, 0($t0)		# $t5 = str[i] 	
	bgtu	$t0, $t2, endw		# while (str[i] <= str[iultimo]){
	add	$t3, $t3, $t5		#	soma = soma + str[i];
	addiu	$t1, $t1, 4		#	i++:
	j	while			# }
endw:	move	$a0, $t3		# $a0 = soma
	li	$v0, print_int10	# $v0 = 1
	syscall				# print_int10(soma)				
	jr 	$ra			# termina o programa