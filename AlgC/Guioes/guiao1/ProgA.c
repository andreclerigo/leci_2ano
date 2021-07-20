#include <stdio.h>

void printArray(const char *s, int a[], int sizeA);
void cumSum(int a[], int b[], int size);

int main(void)
{
    int a[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    printArray("a", a, sizeof(a)/sizeof(a[0]));
    
    int b[12];
    cumSum(a, b, sizeof(a)/sizeof(a[0]));
    printArray("b", b, 12);
}

void printArray(const char *s, int a[], int sizeA)
{
    printf("%s :\n", s);
    for (int i = 0; i < sizeA; i++)
    {
        printf("%d ", a[i]);
    }
    puts("");
}

void cumSum(int a[], int b[], int size)
{   
    int c = 0;
    for (int i = 0; i < size; i++)
    {
        c += a[i];
        b[i] = c;
    }
    
}