#include <stdio.h>

int factoriao(int n, int size);
int getDigits(int n);

//Numbers lower then 10^6 have at most 6 digits
static int digits[6];
static int ndiv;
static int nmult;
//Array with the value of factorial troguh 0 to 9 (all single digits)
static int factorials[10] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

int main(void)
{
    for (int i = 1; i < 100000; i++)
    {
        ndiv = 0;
        nmult = 0;
        int size = getDigits(i);
        if (factoriao(i, size))
        {
            printf("%d\n", i);
            printf("Number of multiplications: %d\n", nmult);
            printf("Number of divisions: %d\n\n", ndiv);
        }
    }
    
}

int factoriao(int n, int size)
{
    int sum = 0;
    for (int i = 0; i < size; i++)
    {
        nmult += digits[i];
        sum += factorials[digits[i]];
    }

    if(sum == n) 
        return 1;
    else
        return 0;
}

int getDigits(int n)
{
    int quo = n;
    int rem;
    int size = 0;

    while(quo != 0)
    {
        rem = quo % 10;
        quo = quo / 10;
        ndiv++;
        digits[size] = rem;
        size++;
    }
    return size;
}
