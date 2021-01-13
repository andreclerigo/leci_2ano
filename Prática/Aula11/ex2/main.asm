	.data
	.eqv 	id_number, 0
	.eqv 	first_name, 4
	.eqv 	last_name, 22
	.eqv 	grade, 40
	.eqv 	MAX_STUDENTS, 4
	.eqv 	print_str, 4
	.eqv 	print_float, 2
st_array:.space 176
str1:	.asciiz "\nMedia"
str2:	.asciiz "\n"
	.align 2
media:	.space 4
	.text
	.globl main
	
main:					# int main(void) {
	addiu	$sp, $sp, -8		#	por espaco na pilha
	sw	$ra, 0($sp)		#	guardar o $ra
	sw	$s0, 4($sp)		#	guardar o $s2
					#
	la	$a0, st_array		#	$a0 = st_array;
	li	$a1, MAX_STUDENTS	#	$a1 = MAX_STUDENTS;
	jal	read_data		#	read_data(st_array, MAX_STUDENTS);
	la	$a0, st_array		#	$a0 = st_array;
	li	$a1, MAX_STUDENTS	#	$a1 = MAX_STUDENTS;
	la	$a2, media		#	$a2 = $media;			
	jal	max			#	max(st_array, MAX_STUDENTS, &media);
	move	$s0, $v0		#	$s0 = return(max);
					
													
	la	$a0, str1		#	$a0 = str1;
	li	$v0, print_str		#		
	syscall				#	print_str(str1);
	la	$t0, media		#	$t0 = &media;
	l.s	$f12, 0($t0)		#	$f12 = media;
	li	$v0, print_float	#	
	syscall				#	print_float(media);
	la	$a0, str2		#	$a0 = "\n"
	li	$v0, print_str		#
	syscall				#	print_str("\n");
	
	move	$a0, $s0		#	
	jal	print_student		#	print_student(pmax);
					#
	lw	$ra, 0($sp)		#	repoem o valor de $ra
	lw	$s0, 4($sp)		#	repoem o s2
	addiu	$sp, $sp, 8		#	repoem o tamanho da pilha
	li	$v0, 0			# 	return 0;
	jr	$ra			# }
