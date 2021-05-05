	.equ	SFR_BASE_HI, 0xBF88
	.equ	TRISE, 0x6100
	.equ	LATE, 0x6120
	.equ	getChar, 2
	.equ 	resetCoreTimer, 12
	.equ	readCoreTimer, 11
	.data
	.text
	.globl main

main:
	addiu 	$sp, $sp, -12
	sw	$ra, 0($sp)
	sw	$s0, 4($sp)
	
	lui	$s0, SFR_BASE_HI
	lw	$t0, TRISE($s0)
	andi	$t0, $t0, 0xFFE0
	sw	$t0, TRISE($s0)

loop:
	li	$v0, getChar
	syscall
	move 	$t0, $v0
	
	lw	$t1, LATE($s0)
	andi	$t1, $t1, 0xFFE0
if:	
	bne	$t0, '0', elseif1
	ori	$t1, $t1, 0x0001
	sw	$t1, LATE($s0)
	j	endif
elseif1:
	bne	$t0, '1', elseif2
	ori	$t1, $t1, 0x0002
	sw	$t1, LATE($s0)
	j	endif
elseif2:
	bne	$t0, '2', elseif3
	ori	$t1, $t1, 0x0004
	sw	$t1, LATE($s0)
	j	endif
elseif3:
	bne	$t0, '3', else
	ori	$t1, $t1, 0x0008
	sw	$t1, LATE($s0)
	j	endif
else:
	ori	$t1, $t1, 0x0010
	sw	$t1, LATE($s0)
	li	$a0, 2000
	jal 	delay
	andi	$t1, $t1, 0xFFE0
	sw	$t1, LATE($s0)
endif:
	j	loop
	
	sw	$ra, 0($sp)
	sw	$s0, 4($sp)
	addiu 	$sp, $sp, 12
	li	$v0, 0
	jr	$ra


delay:
for:	ble	$a0, $0, endfor
	li	$v0, resetCoreTimer
	syscall
while:
	li	$v0, readCoreTimer
	syscall
	blt	$v0, 20000, while
	addi	$a0, $a0, -1
	j	for
endfor:
	jr	$ra


