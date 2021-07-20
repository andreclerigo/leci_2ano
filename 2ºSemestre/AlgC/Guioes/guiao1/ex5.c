#include <stdio.h>

int main(void)
{
    printf("sizeof(void *) \t %d\n", sizeof(void *));
    printf("sizeof(void) \t %d\n", sizeof(void));
    printf("sizeof(char) \t %d\n", sizeof(char));
    printf("sizeof(short) \t %d\n", sizeof(short));
    printf("sizeof(int) \t %d\n", sizeof(int));
    printf("sizeof(long) \t %d\n", sizeof(long));
    printf("sizeof(long long) \t %d\n", sizeof(long long));
    printf("sizeof(float) \t %d\n", sizeof(float));
    printf("sizeof(double) \t %d\n", sizeof(double));

    //O void* é diferente, porque o ponteiro tem 64bits que sao 8 bytes
}