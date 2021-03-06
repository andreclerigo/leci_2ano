	.data
				# nada a colocar aqui
	.text
	.globl main
main:	ori $v0, $0, 5		# guarda o valor no $v0
	syscall			# chamada do system call "read_int()"
	or  $t0, $0, $v0	# $t0 = $0 + $v0
	ori $t2, $0, 8 		# $t2 = 8
	add $t1, $t0, $t0 	# $t1 = $t0 + $t0 = x + x = 2 * x
	sub $t1, $t1, $t2 	# $t1 = $t1 + $t2 = y = 2 * x - 8
	or  $a0, $0, $t1	# $a0 = $t1 = y
	ori $v0, $0, 36		# print_int16
	syscall			# syscall da funcao print_intu10()
	jr  $ra			# fim do programa