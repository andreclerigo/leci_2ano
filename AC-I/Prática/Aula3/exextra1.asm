# Mapa de Registos:
# $t0 - gray
# $t1 - mask
# $t2 - bin

	.data
str1:	.asciiz "Introduza um numero: "
str2:	.asciiz "\nValor em código Gray: "
str3:	.asciiz	"\nValor em binario: "
	.eqv	print_string, 4
	.eqv	read_int, 5
	.eqv	print_int16, 34
	.text
	.globl 	main
	
main:	la	$a0, str1		# $a0 = str1
	li	$v0, print_string	# $v0 = 4
	syscall				# print_string(str1);
	li	$v0, read_int		# $v0 = 5
	syscall				# read_int()
	move 	$t0, $v0		# grayt = read_int();
	srl	$t1, $t0, 1		# mask = gray >> 1;
	move	$t2, $t0		# bin = gray;
					#
while:	beqz	$t1, endw		# while(mask |= 0) [
	xor	$t2, $t2, $t1		#	bin = bin ^ mask;
	srl	$t1, $t1, 1		#	mask = mask >> 1;
	j	while			# }

endw: 	la	$a0, str2		# $a0 = str2
	li	$v0, print_string	# $v0 = 4
	syscall				# print_string(str2);
	move	$a0, $t0		# $a0 = gray
	li	$v0, print_int16	# $v0 = 34
	syscall				# printª_int16(gray);
	la	$a0, str3		# $a0 = str3
	li	$v0, print_string	# $v0 = 4
	syscall				# print_string(str3);
	move	$a0, $t2		# $a0 = bin
	li	$v0, print_int16	# $v0 = 34
	syscall				# print_16(bin);
	jr	$ra
	
	
	