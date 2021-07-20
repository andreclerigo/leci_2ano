#include <stdio.h>

int main(void)
{
    //printf and fgets (the correct/more standard way)
    char name[20];
    printf("What's your name?\n");
    fgets(name, 20, stdin);
    printf("Hello %s\n", name);
    
    //puts and gets
    char name2[20];
    puts("What's your name?");  //Does \n automatically and only prints the string
    gets(name2);                //Shouldn't be used (only exists for compatiblity)
    printf("Hello %s\n", name2);

    //puts and scanf
    char name3[50];
    puts("\nWhat's your name?");  //Does \n automatically and only prints the string
    scanf("%s", name3);           //Can't use SPACE only takes the 1st word
    printf("Hello %s", name3);

    return 0;
}