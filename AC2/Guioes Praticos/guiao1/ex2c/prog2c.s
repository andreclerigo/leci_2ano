        .equ inKey, 1
        .equ putChar, 3
        .data
        .text
        .globl main

main:                               # int main(void){
do:                                 #    do {
while2: li      $v0, inKey          #
        syscall                     #       
        bne     $v0, 0, endw2       #        while( (c == inKey()) == 0);
        j       while2              #        
endw2:                              #
if:     beq     $v0, '\n', while    #        if(c!= '\n')
        move    $a0, $v0            #           putChar(c)
        li      $v0, putChar        #         
        syscall                     #
while:  bne     $a0, '\n', do       #    }while(c != '\n');
        li      $v0, 0              #    return 0;
        jr      $ra                 #    fim do programa
