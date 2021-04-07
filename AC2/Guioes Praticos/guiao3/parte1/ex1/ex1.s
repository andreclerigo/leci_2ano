	.equ SFR_BASE_HI, 0xBF88
	.equ TRISE, 0x6100
	.equ LATE, 0x6120
	.equ TRISB, 0x6040
	.equ PORTB, 0x6060
	.data
	.text
	.globl main

main:					# int main(void) {
	lui	$t0, SFR_BASE_HI	#
	lw	$t1, TRISE($t0)		#	$t1 = 0xBF886100 = TRISE
	andi	$t1, $t1, 0xFFFE	#	RE0 = 0 (OUTPUT)
	sw	$t1, TRISE($t0)		#	WRITE TRISE register
					#
	lw	$t2, TRISB($t0)		#	$t1 = 0xBF886100 = TRISB
	ori	$t2, $t2, 0x1		#	RB0 = 1 (INPUT)
	sw	$t2, TRISB($t0)		#	WRITE TRISB register

loop:					#	while(true) {
	lw	$t3, PORTB($t0)		#		$t3 = READ (Read PORTB register)
	andi	$t3, $t3, 1		#		$t3 = PORTB0
	sw	$t3, LATE($t0)		#		WRITE LATE register with PORTB0
	j	loop			#	}
	jr	$ra 			# }