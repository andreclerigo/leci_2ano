	.data
	.eqv 	id_number, 0
	.eqv 	first_name, 4
	.eqv 	last_name, 22
	.eqv 	grade, 40
	.eqv	print_str, 4
	.eqv 	read_float, 6
	.eqv	read_str, 8
	.eqv	read_int, 5
str1:	.asciiz "N. Mec: "
str2:	.asciiz "Primeiro Nome: "
str3:	.asciiz "Ultimo Nome: "
str4:	.asciiz "Nota: "
	.text
	.globl read_data

read_data:				#void read_data(student *st, int ns) {
	li	$t0, 0			#	int = 0;
	move	$t4, $a1		#
	move	$t1, $a0		#	$t1 = &st;
for:	bge	$t0, $t4, endfor	#	for(i = 0; i < ns; i++) {
	la	$a0, str1		#		$a0 = str1
	li	$v0, print_str		#		$v0 = 4
	syscall				#		print_str(str1);
	li	$v0, read_int		#		read_int();
	syscall
	mul	$t2, $t0, 44		#
	addu	$t2, $t1, $t2		#		$t2 = &st[i];
	sw	$v0, id_number($t2)	#		st[i].id_number = read_int();
					#
	la	$a0, str2		#		$a0 = str2
	li	$v0, print_str		#		$v0 = 4
	syscall				#		print_str(str2);
	addiu	$a0, $t2, first_name	#		$a0 = st[i].first_name;
	li	$a1, 18			#		$a1 = 18;
	li	$v0, read_str		#		read_str();
	syscall
					#
	la	$a0, str3		#		$a0 = str3
	li	$v0, print_str		#		$v0 = 4
	syscall				#		print_str(str3);
	addiu	$a0, $t2, last_name	#		$a0 = st[i].last_name;
	li	$a1, 15			#		$a1 = 15;
	li	$v0, read_str		#		read_str();
	syscall
					#
	la	$a0, str4		#		$a0 = str4
	li	$v0, print_str		#		$v0 = 4
	syscall				#		print_str(str4);				
	li	$v0, read_float		#		read_float();
	syscall
	addiu	$t2, $t2, grade		#		$t2 = st[i].grade;
	s.s	$f0, 0($t2)		#		st[i].grade = read_float();
					#
	addi	$t0, $t0, 1		#		i++;
	j	for			#	}
endfor:					#
	jr	$ra			# }
