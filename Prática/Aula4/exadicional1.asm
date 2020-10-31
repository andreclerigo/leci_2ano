# Mapa de Registos
# $t0 - p
# $t1 - *p

	.data
frase:	.asciiz "Introduza uma string: "
	.eqv	SIZE, 20
	.eqv	read_string, 8
	.eqv	print_string, 4
str:	.space	20
	.text
	.globl main
	
main:	la	$a0, frase		# $a0 = frase
	li	$v0, print_string	# $v0 = 4
	syscall				# print_string(frase)
	la	$a0, str	 	# $a0 = buf
	li	$a1, SIZE	 	# $a1 = length
	li 	$v0, read_string 	# $v0 = 8
	syscall				# read_string()
					# 
	la	$t0, str		# p = str
while: 	lb	$t1, 0($t0)		# *p = str
	beqz	$t1, endw		# while( *p != '\0') {
	addi	$t1, $t1, -0x20		#	*p = *p - 0x20
	sb	$t1, 0($t0)		# 	Renova o registo com os novos caracteres
	addi	$t0, $t0, 1		#	p++;
	j	while			# }
endw:	la 	$a0, str		# $a0 = str
	li 	$v0, print_string	# $v0 = 4
	syscall				# print_string(str)
	jr	$ra			# fim do programa
