#include <stdio.h>

int func(int n);
int somation(int n);

static int nMult;

int main(void)
{   
    int res;
    for (int i = 0; i < 26; i++)
    {   
        nMult = 0;
        printf("%d - ", i);
        res = func(i);
        printf("%d, %d\n", res, nMult);
    }
    
    return 0;
}

int func(int n)
{   
    if (n < 3)
        return 1;
    else
        return func(n - 1) + func(n - 2) + somation(n);
}

int somation(int n)
{
    int sum = 0;
    for (int k = 0; k <= (n - 3); k++)
    {
        nMult ++;
        sum += func(k) * func(n - 3 -k);
    }
    
    return sum;
}
