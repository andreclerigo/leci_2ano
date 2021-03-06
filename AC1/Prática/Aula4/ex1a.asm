# Mapa de Variaveis
# $t0 - num
# $t1 - i
# %t2 - &array[i}  -- endereco
# $t3 - array[i]  -- valor
	
	.data
	.eqv	SIZE, 20
	.eqv	read_string, 8
	.eqv	print_int10, 1
str:	.space	20
	.text
	.globl main

main:	la	$a0, str		
	li	$a1, SIZE			
	li	$v0, read_string	# $v0 = 8
	syscall				# read_string()
	
	li $t0, 0			# num = 0
	li $t1, 0			# int = 0
	
while:	la	$t2, str		# $t2 = str
	add	$t2, $t2, $t1		# $t2 = &str[i]		
	lb	$t3, 0($t2)		# $t3 é copia do valor str[i] -- Colocado no registo de CPU
		
condit:	beqz	$t3, endw		# while(str[i] != '\0') {
					#
if:	blt	$t3, '0', endif		#	if (cond1 &&
andd:	bgt	$t3, '9', endif		#	    cond2){
	addi	$t0, $t0, 1		# 	num++:
endif:	addi	$t1, $t1, 1		# 	i++;
	j	while			# }
					#
endw:	move	$a0, $t0		# $a0 = $t0
	li 	$v0, print_int10	# $v0 = 1
	syscall				# print_int10(num)
	jr 	$ra			# fim do programa
	