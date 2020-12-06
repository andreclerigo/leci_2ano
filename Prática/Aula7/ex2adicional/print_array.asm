	.data
str:	.asciiz	", "
	.eqv print_int10, 1
	.eqv print_string, 4
	.text
	.globl print_array
	
print_array:			# void print_array(int *a, int n) {
	move	$t0, $a0	#	$t0 = &a;
	move	$t1, $a1	#	$t1 = n;
	sll	$t1, $t1, 2	#	n = n*4;
	addu	$t2, $t0, $t1	#	p = &(a + n);
for:	bge	$t0, $t2, endfor#	for(; a < p; a++) {
	lw	$a0, 0($t0)	#		$a0 = *a;
	li	$v0, print_int10#		
	syscall			#		print_int10(*a);
	la	$a0, str	#		$a0 = ", ";
	li	$v0, print_string#
	syscall			#		print_string(", ");
	addiu	$t0, $t0, 4	#		a++;
	j	for		#	}
endfor:				#
	jr	$ra		# } fim do programa