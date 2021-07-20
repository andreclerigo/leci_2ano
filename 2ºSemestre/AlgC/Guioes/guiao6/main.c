#include <stdio.h>

unsigned int t1(unsigned int n);
unsigned int t2(unsigned int n);
unsigned int t3(unsigned int n);

static int calls;

int main(void)
{
    unsigned int res;

    for (int i = 0; i < 65; i++)
    {
        calls = 0;
        res = t1(i);
        printf("Result1: %d\tCalls: %d\t", res, calls);

        calls = 0;
        res = t2(i);
        printf("Result2: %d\tCalls: %d\t", res, calls);

        calls = 0;
        res = t3(i);
        printf("Result3: %d\tCalls: %d\n", res, calls);
    }
    return 0;
}

unsigned int t1(unsigned int n)
{
    calls++;
    if (n == 0) 
        return 0;
    else
        return t1(n / 4) + n;
}

unsigned int t2(unsigned int n)
{
    calls++;
    if (n <= 3) 
        return n;
    else
        return t2(n / 4) + t2((n + 3) / 4) + n;
}

unsigned int t3(unsigned int n)
{
    calls++;
    if (n <= 3) 
        return n;
    else if (n % 4 == 0)
        return 2 * t3(n / 4) + n;
    else
        return t3(n / 4) + t3((n + 3) / 4) + n;
}