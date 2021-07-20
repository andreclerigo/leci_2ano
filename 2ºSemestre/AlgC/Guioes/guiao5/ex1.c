#include <stdio.h>
#include <assert.h>

int func(double a[], int size);
static int nOps;

int main(void)
{
    double array[][10] = {
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
        {1, 2, 4, 4, 5, 6, 7, 8, 9, 10},
        {1, 2, 4, 8, 5, 6, 7, 8, 9, 10},
        {1, 2, 4, 8, 16, 6, 7, 8, 9, 10},
        {1, 2, 4, 8, 16, 32, 7, 8, 9, 10},
        {1, 2, 4, 8, 16, 32, 64, 8, 9, 10},
        {1, 2, 4, 8, 16, 32, 64, 128, 9, 10},
        {1, 2, 4, 8, 16, 32, 64, 128, 256, 10},
        {1, 2, 4, 8, 16, 32, 64, 128, 256, 512},
    };

    for (int i = 0; i < 9; i++)
    {
        nOps = 0;
        int res = func(array[i], 10);
        printf("Array%d - Result: %d\tnOps: %d\n", i, res, nOps);
    }  
    
    return 0;  
}

int func(double a[], int size)
{
    assert(size > 2 && "The array must have 3 elements or more.");
    double r = a[1]/a[0];
    nOps++;

    for (int i = 2; i < size; i++)
    {
        nOps++;
        if (a[i] != r * a[i-1]) return 0;
    }
    return 1;
}