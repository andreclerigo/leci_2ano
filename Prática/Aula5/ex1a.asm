#define SIZE 5
#void main(void)
#{
 #static int lista[SIZE]; // declara um array de inteiros
 #// residente no segmento de dados
 #int i;
 #for(i=0; i < SIZE; i++)
 #{
 #print_string("\nIntroduza um numero: ");
 #lista[i] = read_int();
 #}
#} 

	.eqv 	SIZE, 5
	.eqv	print_str, 4
	.eqv	read_int, 5
	.data
str:	.asciiz	"\nIntroduza um numero: "
	.align	2				# align 2^2
lista:	.space	20				# static int lista[SIZE];
	.text
	.globl main
						# void main
main:	li	$t0, 0				#	int i = 0;
for:	bge	$t0, SIZE, endfor		#	for(i=0, i< SIZE; i++)
	la	$a0, str
	li	$v0, print_str
	syscall					# 		print_string(str);
	
	li	$v0, read_int			#
	syscall					#		tmp = read_int() -> $v0

	la	$t1, lista			#		int *t1 = &lista[0]
	sll	$t2, $t0, 2			#		t2 = i*4;
	addu	$t2, $t1, $t2			#		t2 = lista + 4*i = &lista[i]
	sw	$v0, 0($t2)			#		lista[i] = tmp
			
	addi	$t0, $t0, 1			# i++;
	j	for				# 
endfor:	jr	$ra
