# Mapa de Registos:
# $t0 - res
# $t1 - i
# $t2 - mdor
# $t3 - mdo

	.data
str1:	.asciiz	"Introduza dois numeros: "
str2:	.asciiz "Resultado: "
	.eqv	print_string, 4
	.eqv	read_int, 5
	.eqv	print_int10, 1
	.text
	.globl 	main
	
main:	li	$t0, 0			# res = 0
	li	$t1, 0			# i = 0
	la	$a0, str1		# $a0 = str1
	li	$v0, print_string	# $v0 = 4
	syscall				# print_string(str1);
	li	$v0, read_int		# 
	syscall				# read_int()
	andi	$t2, $v0, 0x0F		# mdor = read_int() & 0x0F; 
	li	$v0, read_int		# 
	syscall				# read_int()
	andi	$t3, $v0, 0x0F		# mdo = read_int() & 0x0F; 
					#
while:					# while( 
	beqz	$t2, endw		# 	mdor != 0
	addi	$t1, $t1, 1		# 	i++
	bge	$t1, 4, endw		# 	i++ < 4
	andi	$t4, $t2, 0x00000001	# 	$t4 = mdor & 0x00000001 
					# ) [
if:	beqz	$t4, endif		# if( (mdor & 0x00000001) != 0 ) {
	add	$t0, $t0, $t3		# 	res = res + mdo;
	j	endif			# }
endif:	sll	$t3, $t3, 1		# mdo = mdo << 1;
	srl	$t2, $t2, 1		# mdor = mdor >> 1;	
	j	while			# }
					#
endw:	la	$a0, str2		# $a0 = str2
	li	$v0, print_string	# $v0 = 4
	syscall				# print_string(str2);
	move	$a0, $t0		#
	li	$v0, print_int10	# $v0 = 1
	syscall				# print_int10(res);
	jr	$ra			# fim do programa