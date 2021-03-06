	.text
	.globl abss
	
abss:					# int abs(int val) {
	move	$v0, $a0		#	
if:	bge	$v0, 0, endif		#	if(val > 0) {
	mul	$v0, $v0, -1		#		val = - val;
endif:					#	}
					#	return val;
	jr	$ra			# } fim do programa