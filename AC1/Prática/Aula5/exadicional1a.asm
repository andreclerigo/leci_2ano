# Mapa de Registos
# $t0 - i
# $t1 - lista
# $t2 - aux
# $t3 - SIZE-1
# $t4 - j
# $t5 - tmp1
# $t6 - tmp2
# $t7 - aux1
# $t8 - aux2

	.data
str1:	.asciiz "\nIntroduza um numero: "
str2:	.asciiz "Conteudo do array: "
str3:	.asciiz "; "
	.align	2		# align 2^2
lista:	.space	40				
	.eqv	FALSE, 0
	.eqv	TRUE, 1
	.eqv	SIZE, 10
	.eqv	read_int, 5
	.eqv	print_string, 4
	.eqv	print_int10, 1
	.text
	.globl main
main:				# void main(void) {
	li	$t0,0		#	i = 0
while:	bge	$t0, SIZE, endw	#	while(i < SIZE) {
	la	$a0, str1	#		$a0 = str1
	li	$v0, print_string#		$v0 = 4
	syscall			#		print_string(str1)
	li	$v0, read_int	#		
	syscall			#		$v0 = read_int();		
	sll	$t2, $t0, 2	#		int aux = i * 4;		
	la	$t1, lista	#		int *p = $(lista[0])		
	addu	$t1, $t1, $t2	#		p+= aux;
	sw	$v0, 0($t1)	#		lista[i] = read_int()
	addi	$t0, $t0, 1	#		i++;
	j	while		#	}
endw:				#
	li	$t0,0		#	i = 0;
	li	$t3, 9		#	$t3 = SIZE -1;
while2: bge	$t0, $t3, endw2	#	while(i < SIZE-1) {
	addi	$t4, $t0, 1	#		j = i + 1;
while3:	bge	$t4, SIZE, endw3#		while( j < SIZE) {
	la	$t1, lista	#			int p* = lista;
	sll	$t5, $t0, 2	#			int tmp1 = i*4;
	addu	$t5, $t1, $t5	#			tmp1 = lista + i
	sll	$t6, $t4, 2	#			int tmp2 = j*4;
	addu	$t6, $t1, $t6	#			tmp2 = lista + j;
	lw	$t7, 0($t5)	#			int aux1 = lista[i];
	lw	$t8, 0($t6)	#			int aux2 = lista[j];
if:	ble	$t7, $t8, endif	#			if( lista[i] > lista[j]) {
	sw	$t7, 0($t6)	#				lista[i] = lista[j];
	sw	$t8, 0($t5)	#				lista[j] = lista[i];	
endif:				#			}
	addi	$t4, $t4, 1	#			j++;
	j 	while3		#		}
endw3:				#
	addi	$t0, $t0, 1	#		i++;
	j	while2		#	}
endw2:				#
	li	$t0, 0		#	i = 0
while4:	bge	$t0, SIZE, endw4#	while(i<SIZE) {
	la	$t1, lista	#		int *p = &(lista[0])
	sll	$t2, $t0, 2	#		int aux = i * 4
	addu	$t2, $t1, $t2	#		aux = &(lista[i])
	
	li	$v0, print_int10#
	lw	$a0, 0($t2)	#
	syscall			#		print_int10(lista[i])
	
	li	$v0, print_string#
	la	$a0, str3	#
	syscall			#		print_string(";");
	addi	$t0, $t0, 1	#		i++;
	j	while4		#	}
endw4:	
	jr	$ra		# } fim do programa