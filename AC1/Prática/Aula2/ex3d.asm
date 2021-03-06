	.data
str1:	.asciiz "Introduz 2 numeros\n"
str2:	.asciiz "A soma dos dois numeros e': "
	.eqv	print_string, 4
	.eqv 	read_int, 5
	.eqv	print_int10, 1
	
	.text
	.globl 	main
main:	la  $a0, str1			
	ori $v0, $0, print_string	
	syscall				# print_string(str1);
	ori $v0, $0, read_int		
	syscall				# o valor lido e´ retornado em $v0
	or  $t0, $v0, $0		# $t0 = read_int() = a
	
	ori $v0, $0, read_int		
	syscall				# o valor lido e´ retornado em $v0
	or  $t1, $v0, $0		# $t1 = read_int() = b
	
	add $t2, $t1, $t0		# $t2 = $t1 + $t0 ($t2 = a + b)
	
	la  $a0, str2
	ori $v0, $0, print_string
	syscall				# print_string(str2);
	
	or  $a0, ,$0, $t2
	ori $v0, $0, print_int10
	syscall				# print_int10($t2)  print_int10(a+b);
	
	jr  $ra