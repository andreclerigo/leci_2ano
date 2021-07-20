        .equ getChar, 2
        .equ putChar, 3
        .data
        .text
        .globl main

main:                               # int main(void){
do:                                 #    do {
        li      $v0, getChar        #        c = getChar();
        syscall                     #        
        move    $t0, $v0            #        $t0 = c;
     	beq     $t0, '\n', while    #        if(c!= '\n')
        li      $v0, putChar        #           putChar(c)   
        move	$a0, $t0			#
		syscall                     #
while:  bne     $t0, '\n', do       #    }while(c != '\n');
        li      $v0, 0              #    return 0;
        jr      $ra                 # }  fim do programa
