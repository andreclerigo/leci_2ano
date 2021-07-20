	.data
	.text
	.globl main
	
main:	ori $t0, $0, 8      	# $t0 = valor para gray
      	srl $t3, $t0, 1	  	# $t0 = $t0 >> 1 
      	xor $t0, $t0, $t3  	# $t0 = $t0 xor $t3
      				# $t0 = valor em codigo gray
      				
	or  $t1, $0, $t0	# $t1 = $t0 (num = gray)
	srl $t3, $t1, 4		# $t3 = num >> 4
	xor $t1, $t1, $t3	# $t1 = $t1 xor $t3  (num = num ^ $t3) 
	srl $t3, $t1, 2
	xor $t1, $t1, $t3
	srl $t3, $t1, 1
	xor $t1, $t1, $t3
	
	or  $t2, $0, $t1	# $t2 = $t1 (bin = num)
	jr  $ra
