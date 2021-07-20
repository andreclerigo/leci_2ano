#include <stdio.h>

int getDigits(int n);
int nrArmstrong(int n, int size);

//Only for numbers with 3 digits
static int digits[3];
static int ndiv;
static int nmult;

//Array with the values of numbers 0 to 9 to the power of 3
static int powers[10] = {0, 1, 8, 27, 64, 125, 216, 343, 512, 729};

int main(void)
{
    for (int i = 100; i < 10000; i++)
    {
        ndiv = 0;
        nmult = 0;
        int size = getDigits(i);
        if (nrArmstrong(i, size))
        {
            printf("%d\n", i);
            printf("Number of multiplications: %d\n", nmult);
            printf("Number of divisions: %d\n\n", ndiv);
        }
    }
    
}

int nrArmstrong(int n, int size)
{
    int sum = 0;
    for (int i = 0; i < size; i++)
    {
        nmult += 3;
        sum += powers[digits[i]];
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
