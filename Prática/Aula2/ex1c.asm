	.data
	.text
	.globl main
main:	ori  $t0, $0,  0xE543  # $t0 = valor
	xori $t1, $t0, 0xFFFF  # $t1 = $t0 xor 11111111111
	#nor $t1, $t0, $0
	jr   $ra