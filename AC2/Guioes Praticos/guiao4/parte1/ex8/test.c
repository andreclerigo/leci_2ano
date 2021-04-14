#include <stdio.h>

int main (void)
{
    static const char array[] = {0x42, 0x41, 0x61};

    int index = (0x0001 & 0xFFFF);

    char c = array[index];

    printf("%c", c);
    return 0;
}