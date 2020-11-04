# Mapa de Registos
# &lista[SIZE] - $t0
# *p - $t1
# houve_troca - $t4
# i - $t5
# lista - $t6 - p
# lista+i - $t7

	.data
	.eqv	FALSE, 0
	.eqv	TRUE, 1
	.eqv	SIZE, 10
	.eqv	read_int, 5
	.eqv	print_string, 4
	.eqv	print_int10, 1
str1:	.asciiz "\nIntroduza um numero: "
str2:	.asciiz "Conteudo do array: "
str3	.asciiz "; "
	.align	2				# align 2^2
lista:	.space	40				# static int lista[SIZE];
	.text
	.globl main

main:					# void main(void) {
	la	$t6, lista 		# 	$t6 = lista;
	li	$t0, SIZE		#	$t0 = SIZE       
	sll	$t0, $t0, 2		#	$t0 = SIZE*4
	addu	$t0, $t6, $t0		#	$t0 = &lista[SIZE*4]
	li	$t5, 0			#	i = 0
for:	bgeu	$t6, $t0, endfor	#	for (p = lista; p < lista[SIZE*4]; p++) {
	li	$v0, read_int
	syscall	
	sw	$v0, 0($t6)
	