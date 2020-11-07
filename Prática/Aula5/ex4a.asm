# Mapa de Registos
# *p	      - $t0
# *(p+1)      - $t1
# aux	      - $t2
# i	      - $t3
# houve_troca - $t4
# p	      - $t5
# pUltimo     - $t6

	.data
str1:	.asciiz "\nIntroduza um numero: "
str2:	.asciiz "Conteudo do array: "
str3:	.asciiz "; "
	.align	2				# align 2^2
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
	li	$t3,0		#	i = 0
while:	bge	$t3, SIZE, endw	#	while(i < SIZE) {
	la	$a0, str1	#		$a0 = str1
	li	$v0, print_string#		$v0 = 4
	syscall			#		print_string(str1)
	li	$v0, read_int	#		
	syscall			#		$v0 = read_int();		
	sll	$t2, $t3, 2	#		int aux = i * 4;		
	la	$t0, lista	#		int *p = $(lista[0])		
	addu	$t0, $t0, $t2	#		p+= tmp1;
	sw	$v0, 0($t0)	#		lista[i] = read_int()
	addi	$t3, $t3, 1	#		i++;
	j	while		#	}
endw:				#
	la	$t5, lista	# 	$t5 = %lista[0]
	li	$t6, SIZE	# 
	subu	$t6, $t6, 1	# 	$t6 = SIZE-1
	sll	$t6, $t6, 2	# 	$t6 = (SIZE -1) * 4
	addu	$t6, $t6, $t5	# 	$t6= lista + (SIZE - 1)*4
do:				# 	do {
	la	$t5, lista
	li	$t4, FALSE	#		houve_troca = FALSE;
while2:	bge	$t5, $t6, endw2	#		while(p < pUltimo) {
	lw	$t0, 0($t5)	#			$t0 = *p
	lw	$t1, 4($t5)	#			$t1 = *(p+1)
if:	ble	$t0, $t1, endif	#			if(*p > *(p+1)) {
	#move	$t2, $t0	#				aux = *p;
	sw	$t1, 0($t5)	#				*p = *(p+1);
	sw	$t0, 4($t5)	#				*(p+1) = aux;
	li	$t4, TRUE	#				houve_troca = TRUE
endif:				#			}
	addiu	$t5, $t5, 4	# 			p++;
	j	while2
endw2:				#		}
	beq	$t4, TRUE, do	#	} while(houve_troca == TRUE);
endd:	
	li	$t3, 0		#
while3:	bge	$t3, SIZE, endw3#	while(i<SIZE) {
	la	$t0, lista	#		int *p = &(lista[0])
	sll	$t2, $t3, 2	#		int aux = i * 4
	addu	$t2, $t0, $t2	#		aux = &(lista[i])
	
	li	$v0, print_int10#
	lw	$a0, 0($t2)	#
	syscall			#		print_int10(lista[i])
	
	li	$v0, print_string#
	la	$a0, str3	#
	syscall			#		print_string(";");
	addi	$t3, $t3, 1	#		i++;
	j	while3		#	}
endw3:	jr	$ra		# } fim do programa
