	.equ SFR_BASE_HI, 0xBF88
	.equ TRISE, 0x6100
	.equ PORTE, 0x6110
	.equ LATE, 0x6120
	.equ TRISB, 0x6040
	.equ PORTB, 0x6050
	.equ LATB, 0x6060
	.data
	.text
	.globl main

main:					# int main(void) {
	lui	$t0, SFR_BASE_HI	#
	lw	$t1, TRISE($t0)		#	$t1 = [TRISE]
	andi	$t1, $t1, 0xFFF0	#	RE0, RE1, RE2, RE3 = 0 (OUTPUT)
	sw	$t1, TRISE($t0)		#	WRITE TRISE register
					#
	lw	$t1, TRISB($t0)		#	$t1 = [TRISB]
	ori	$t1, $t1, 0x000F	#	RB0, RB1, RB2, RB3 = 1 (INPUT)
	sw	$t1, TRISB($t0)		#	WRITE TRISB register

loop:					#	while(1) {
	lw	$t1, PORTB($t0)		#		$t1 = [PORTB]
	andi	$t1, $t1, 0x0000F	#		$t1 = RB3, RB2, RB1, RB0
	xori    $t1, $t1, 0x00009	#		RB0 = RB0\ && RB3 = RB3\
	lw	$t2, LATE($t0)		#		$t2 = [LATE]
	andi	$t2, $t2, 0xFFF0	#		RE3, RB2, RB1, RB0 = 0
	or	$t2, $t2, $t1		#		RE3 = RB3\, RE2 = RB2, RE1 = RB1, RE0 = RB0\
	sw	$t2, LATE($t0)		#               
	j	loop			#	}
	li 	$v0, 0			#	return 0;
	jr	$ra 			# }