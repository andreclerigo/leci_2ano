	.data
str1:	.asciiz	"O argumento tem "
str2:	.asciiz	" caracteres\n"
	.eqv	print_int10, 1
	.eqv	print_char, 11
	.eqv	print_string, 4
	.text
	.globl main
	
# Mapa de Registos
# $t0 - max
# $t1 - &argc
# $t2 - &argv
# $t3 - i
# $t4 - i*4
# $t5 - j
# %t6 - &(argv[i])

main:					# int main(int argc, char*argv[]) {
	li	$t0, 0			#	int max = 0;
	move	$t1, $a0		#	$t1 = argc
	move	$t2, $a1		#	$t2 = &(argv[0]);
	li	$t3, 0			#	int i = 0;
while:	bge	$t3, $t1, endw		#	while(i < argc) {
	li	$t5, 0			#		int j = 0;
while2:	sll	$t4, $t3, 2		#		$t4 = i*4;
	addu	$t6, $t2, $t4		#		$t6 = &(argv[i]);
	lw	$t6, 0($t6)		#		$t6 = argv[i];
	addu	$t6, $t6, $t5		#		$t6 = &(argv[i][j]);
	lb	$t6, 0($t6)		#		$t6 = array[i][j];
	beq	$t6, '\0', endw2	#		while(array[i][j] != '\0') {
#FAZER IF array[i][j] PARA VER SE É MAIUSCULO OU MINUSCULO
	addi	$t5, $t5, 1		#			j++
	j	while2			#		}
endw2:					#
	la	$a0, str1		#
	li	$v0, print_string	#
	syscall				#		print_string(str1);		
	move	$a0, $t5		#		
	li	$v0, print_int10	#		
	syscall				#		print_int10(j);	
	la	$a0, str2		#
	li	$v0, print_string	#
	syscall				#		print_string(str2);
	addi	$t3, $t3, 1		#		i++;
	j	while			#	}
endw:	
	jr 	$ra			# } fim do programa
