# Mapa de resgistos:
# $t0 - soma
# $t1 - value
# $t2 - i

	.data
str1: 	.asciiz "Introduz uma numero: "
str2: 	.asciiz "Valor ignorado\n"
str3: 	.asciiz "A soma dos positivos e´: "
	.eqv 	print_string, 4
	.eqv	read_int, 5
	.eqv	print_int10, 1
	.text
	.globl main

main: 	li 	$t0, 0			# soma = 0
	li 	$t1, 0			# i = 0
					#
for: 	bge	$t2, 5, endfor		# while( i < 5) {
	ori	$v0, $0, print_string	# 	$v0 = 4
	la	$a0, str1		#	
	syscall				# 	print_string(str1)
	ori	$v0, $0, read_int	#	
	syscall				#	read_int()
	or	$t1, $0, $v0		#	value = read_int()
					#
if:	ble 	$t1, $0, else		# 	if( value > 0) {
	add	$t0, $t0, $t1		#		soma += value
	j	endif			#	
else:	la	$a0, str2		#	else
	ori	$v0, $0, print_string	#
	syscall				#		print_string(str2)
endif: 	addi	$t2, $t2, 1		#	i++:
	j	for			# 	}
					#
endfor:					#
	la	$a0, str3		#
	ori	$v0, $0, print_string	#	$v0 = 4
	syscall				# 	print_string(str3);
	move	$a0, $t0		# 	$a0 = soma
	ori	$v0, $0, print_int10	#	$v0 = 1
	syscall				#	print_int10(soma)
	jr	$ra			# fim do programa