	.data
str1:	.space 100
str2:	.space 50
	.text
	.globl main

# Mapa de registos

main:						# int main(void) {
	jr	$ra				# } fim do programa