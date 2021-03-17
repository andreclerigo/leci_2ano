        .equ getChar, 2
        .equ putChar, 3
        .data
        .text
        .globl main

main:                               # int main(void){
do:                                 #    do {
        li      $v0, getChar        #        c = getChar();
        syscall                     #        
        move    $a0, $v0            #         $a0 = c;
if:     beq     $v0, '\n', while    #        if(c!= '\n')
        addiu   $a0, $a0, 1         #           c = c+1;
        li      $v0, putChar        #           putChar(c+1);
        syscall                     #
while:  bne     $a0, '\n', do       #    }while(c != '\n');
        li      $v0, 0              #    return 0;
        jr      $ra                 # }  fim do programa
