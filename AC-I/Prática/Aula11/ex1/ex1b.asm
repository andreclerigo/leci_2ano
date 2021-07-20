	.data
	.eqv id_number, 0
	.eqv first_name, 4
	.eqv last_name, 22
	.eqv grade, 40
	.eqv read_int, 5
	.eqv read_str, 8
	.eqv print_str, 4
	.eqv print_intu10, 36
	.eqv print_char, 11
	.eqv print_float, 2
stg:	.space 22
	.asciiz "Bonaparte"
	.space 5
	.float 5.1
str1:	.asciiz "\nN. Mec: "
str2:	.asciiz "\nNome: "
str3:	.asciiz "\nNota: "
str4:	.asciiz "\nPrimeiro Nome: "
	.text
	.globl main

main:					# int main(void) {
	la	$t0, stg		#	$t0 = stg;
	la	$a0, str1		#	$a0 = str1
	li	$v0, print_str		#	
	syscall				#	print_str(str1);
	li	$v0, read_int		#	
	syscall				#	read_int();
	sw	$v0, id_number($t0)	#	stg.id_nunmber = $v0
	la	$a0, str4		#	$a0 = str4
	li	$v0, print_str		#	
	syscall				#	print_str(str4);
	addiu	$t1, $t0, first_name	#	$t1 = $t0 + 4
	move	$a0, $t1		#	$a0 = $t1
	li	$a1, 18			#	$a1 = 18
	li	$v0, read_str		#	
	syscall				#	read_str();
	
	la	$a0, str1		#	$a0 = str1
	li	$v0, print_str		#	
	syscall				#	print_str(str1);
	lw	$a0, id_number($t0)	#	$a0 = $stg
	li	$v0, print_intu10	#	
	syscall				#	print_intu10(stg.id_number);
	la	$a0, str2		#	$a0 = str2
	li	$v0, print_str		#	
	syscall				#	print_str(str2);
	addiu	$a0, $t0, last_name	#
	li	$v0, print_str		#
	syscall				#	print_str(stg.last_name);
	li	$a0, ','		#	$a0 = ',';
	li	$v0, print_char		#
	syscall				#	print_char(',');
	addiu	$a0, $t0, first_name	#	
	li	$v0, print_str		#
	syscall				#	print_str(stg.first_name);
	la	$a0, str3		#	$a0 = str3
	li	$v0, print_str		#	
	syscall				#	print_str(str3);
	l.s	$f12, grade($t0)	#	
	li	$v0, print_float	#
	syscall				#	print_float(stg.grade);
	li	$v0, 0			#	return 0
	jr	$ra			# }