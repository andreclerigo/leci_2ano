	.data
	.eqv SIZE, 11
	.eqv print_string, 4
	.eqv print_double, 3
	.eqv read_double, 7
arr:	.space	88
str1:	.asciiz "\nTemp em Fahrenheit: "
str2:	.asciiz "\nValor maximo: "
str3:	.asciiz ", "
str4:	.asciiz "\nConteudo do array:\n"
str5:	.asciiz "\nValor max: "
str6:	.asciiz "\nValor medio: "
str7:	.asciiz "\nMediana: "
str8:	.asciiz "\nVariancia: "
str9:	.asciiz "\nDesvio Padrao: "
	.text
	.globl main
	
# Mapa de Registos
# $t0 - i
# $t1 - &arr
# $t2 - &(arr[n])
	
main:					# int main(void) {
	addiu	$sp, $sp, -12		# 	poem espaco na pilha
	sw	$ra, 0($sp)		#	guarda o $ra
	sw	$s0, 4($sp)		#
	sw	$s1, 8($sp)		#
	li	$s0, 0			#	i = 0;
	la	$s1, arr			#	$s1 = &arr;
					#	Preenche o array com valores em Graus introduzindo Fahrenheit
for:	bge	$s0, SIZE, endfor	#	for(i = 0; i < SIZE; i++) {
	la	$a0, str1		#		$a0 = str1;
	li	$v0, print_string	#		$v0 = 4;
	syscall				#		print_string(str1);
	li	$v0, read_double		#		$v0 = 7;		
	syscall				#		read_double();
	mov.d	$f12, $f0		#		
	jal	f2c			#		f2c(read_double());
	sll	$t3, $s0, 3		#		n = i*8
	addu	$t2, $s1, $t3		#		$t2 = &(arr[n])
	s.d	$f0, 0($t2)		#		arr[n] = read_double();
	addi	$s0, $s0, 1		#		i++;
	j	for			#	}
endfor:					#
					#	Print ao conteudo do array em Celsius
	la	$a0, str4		#	$a0 = str4
	li	$v0, print_string	#	$v0 = 4
	syscall				#	print_string(str4);
	li	$s0, 0			#	i = 0;
for2:	bge	$s0, SIZE, endfor2	#	for ( i=0; i<SIZE; i++) {
	sll	$t3, $s0, 3		#		n = i*8;
	addu	$t2, $s1, $t3		#		$t5 = &(arrc[n])
	l.d	$f12, 0($t2)		#		
	li	$v0, print_double	#		$v0 = 3
	syscall				#		print_double()
	la	$a0, str3		#		$a0 = str3
	li	$v0, print_string	#		$v0 = 4
	syscall				#		print_string(str3)
	addi	$s0, $s0, 1		#		i++
	j	for2			#	}
endfor2:				#	
					#	Mostrar o valor maximo
	la 	$a0, str5		#	$a0 = str5
	li	$v0, print_string	#	$v0 = 4
	syscall				#	print_string(str5)
	move	$a0, $s1			#	
	li	$a1, SIZE		#
	jal	max			#	max(arr, SIZE)
	mov.d	$f12, $f0		#	$f12 = return(max)
	li	$v0, print_double	#	$v0 = 3
	syscall				#	print_double(return(max));
					#
					#	Mostrar o valor medio
	la 	$a0, str6		#	$a0 = str6
	li	$v0, print_string	#	$v0 = 4
	syscall				#	print_string(str6)
	move	$a0, $s1			#	
	li	$a1, SIZE		#
	jal	average			#	average(arr, SIZE);
	mov.d	$f12, $f0		#	$f12 = return(average)
	li	$v0, print_double	#	$v0 = 3
	syscall				#	print_double(return(average));
					#
					#	Mostrar a mediana
	la 	$a0, str7		#	$a0 = str7
	li	$v0, print_string	#	$v0 = 4
	syscall				#	print_string(str7)
	move	$a0, $s1			#	
	li	$a1, SIZE		#
	jal	median			#	median(arr, SIZE);
	mov.d	$f12, $f0		#	$f12 = return(median)
	li	$v0, print_double	#	$v0 = 3
	syscall				#	print_double(return(median));
					#
					#	Mostrar a variancia
	la 	$a0, str8		#	$a0 = str8
	li	$v0, print_string	#	$v0 = 4
	syscall				#	print_string(str8)
	move	$a0, $s1			#	
	li	$a1, SIZE		#
	jal	var			#	var(arr, SIZE);
	mov.d	$f12, $f0		#	$f12 = return(var)
	li	$v0, print_double	#	$v0 = 3
	syscall				#	print_double(return(var));
					#
					#	Mostrar desvio padrao
	la 	$a0, str9		#	$a0 = str9
	li	$v0, print_string	#	$v0 = 4
	syscall				#	print_string(str9)
	move	$a0, $s1			#	
	li	$a1, SIZE		#
	jal	stdev			#	stdev(arr, SIZE);
	mov.d	$f12, $f0		#	$f12 = return(stdev)
	li	$v0, print_double	#	$v0 = 3
	syscall				#	print_double(return(var));
	
	
	lw	$ra, 0($sp)		#	repoem o valor de $ra
	lw	$s0, 4($sp)		#	repoem o s0
	lw	$s1, 8($sp)		#	repoem o s1
	addiu	$sp, $sp, 12		#	repoem o tamnhao da pilha
	li	$v0, 0			#	return 0;
	jr	$ra			# } fim do programa
