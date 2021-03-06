	.data
	.text
	.globl main
main:	ori $t0, $0, 0x5C1B # susbstituir val_1 e val_2 pelos
	ori $t1, $0, 0xA3E4 # valores de entrada desejados
	and $t2, $t0, $t1 # $t2 = $t0 & $t1 (and bit a bit)
	or  $t3, $t0, $t1 # $t3 = $t0 | $t1 (or bit a bit)
	nor $t4, $t0, $t1 # $t4 = $t0 nor $t1 (nor bit a bit)
	xor $t5, $t0, $t1 # $t5 = $t0 nor $t1 (xor bit a bit)
	jr  $ra