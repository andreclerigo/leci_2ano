#include <stdio.h>

int func(int n);
int somation(int a[], int n);

static int nMult;

int main(void)
{   
    int res;
    for (int i = 0; i < 51; i++)
    {   
        nMult = 0;
        printf("%d - ", i);
        res = func(i);
        printf("%d\t%d\n", res, nMult);
    }
    
    return 0;
}

int func(int n)
{   
    int array[n + 1];
    for (int i = 0; i <= n; i++)
    {
        if (i < 3)
            array[i] = 1;
        else 
            array[i] = array[i - 1] + array[i - 2] + somation(array, i);
    }
    return array[n];
}

int somation(int a[], int n)
{
    int sum = 0;
    for (int k = 0; k <= (n - 3); k++)
    {
        nMult ++;
        sum += a[k] * a[n - 3 -k];
    }
    
    return sum;
}
