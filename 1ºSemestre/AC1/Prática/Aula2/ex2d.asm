	.data
	.text
	.globl main
main: ori $t0, $0, 2      # $t0 = valor
      srl $t2, $t0, 1	  # $t2 = $t0 >> 1 
      xor $t1, $t0, $t2   # $t1 = $t0 xor $t2
      jr  $ra
