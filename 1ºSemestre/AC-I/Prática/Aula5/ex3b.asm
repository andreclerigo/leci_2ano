	.data
str1:	.asciiz "\nIntroduza um numero: "
str2:	.asciiz "Conteudo do array: "
str3:	.asciiz "; "
	.align	2				# align 2^2
lista:	.space	40				# static int lista[SIZE];
	.eqv	FALSE, 0
	.eqv	TRUE, 1
	.eqv	SIZE, 10
	.eqv	read_int, 5
	.eqv	print_string, 4
	.eqv	print_int10, 1	
	.text
	.globl main

main:					# void main(void) {
	li	$t0,0			#	i = 0
while:	bge	$t0, SIZE, endw		#	while(i < SIZE) {
	la	$a0, str1		#		$a0 = str1
	li	$v0, print_string	#		$v0 = 4
	syscall				#		print_string(str1)
	li	$v0, read_int		#		
	syscall				#		int tmp = read_int();		// tmp - $t0
	sll	$t1, $t0, 2		#		int tmp1 = i * 4;		// tmp1 - $t1
	la	$t2, lista		#		int *p = $(lista[0])		// p - $t2
	addu	$t2, $t2, $t1		#		p+= tmp1;
	sw	$v0, 0($t2)		#		lista[i] = read_int()
	addi	$t0, $t0, 1		#		i++;
	j	while			#	}
endw:					#											
	#$t1 -> houveTroca		
do:					#	do{
	li	$t1, FALSE		#		houveTroca = FALSE
	li	$t0, 0			#		i = 0
while1:	bge	$t0, 9, endw1		#		while(i < SIZE-1) {
	la	$t2, lista		#			int *p = &(lista[0])
	sll	$t3, $t0, 2		#			int tmp1 = i *4;
	addu	$t3, $t2, $t3		#			tmp1 = lista+i;
	
	lw	$t4, 0($t3)		#			int aux1 = lista[i];	//$t4 - aux1
	lw	$t5, 4($t3)		#			int aux2 = lista[i+1];  //$t5 - aux2
if:	ble	$t4, $t5, endif		#			if( lista[i] > lista[i+1])
	sw	$t4, 4($t3)		#				lista[i+1] = aux;
	sw	$t5, 0($t3)		#				lista[i] = aux2;
	li	$t1, TRUE		#				houveTroca = True;	
endif:					#			}
	addi	$t0, $t0, 1		#			i++
	j	while1			#		}
endw1:					#
					#
endd:	beq	$t1, TRUE, do		#	} while(houveTroca == True);
	li	$v0, print_string	#
	la	$a0, str2		#	
	syscall				#	print_string("Conteudo do array: ")
	li	$t0, 0			#	i = 0;
whil2:	bge	$t0, SIZE, endw2	#	while(i<SIZE) {
	la	$t2, lista		#		int *p = &(lista[0])
	sll	$t3, $t0, 2		#		int tmp1 = i * 4
	addu	$t3, $t2, $t3		#		tmp1 = &(lista[i])
	
	li	$v0, print_int10	#
	lw	$a0, 0($t3)		#
	syscall				#		print_int10(lista[i])
	
	li	$v0, print_string	#
	la	$a0, str3		#
	syscall				#		print_string(";");
	addi	$t0, $t0, 1		#		i++;
	j	whil2			#	}
endw2:	jr	$ra			# } fim do programa