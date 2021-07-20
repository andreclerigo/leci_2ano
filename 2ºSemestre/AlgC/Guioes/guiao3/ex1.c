#include <stdio.h>
#include <math.h>
#include "elapsed_time.h"
#define c1 0.24253562503633297352
#define c2 1.27019663313689157536

long long fibonacciRecursive(int n);
long long fibonacciIterative(int n);
long long fibonacciRecurrence(int n);
static long long nops;

int main(void)
{
    printf("Implementacao recursiva\n");
    for (int i = 0; i < 36; i++)
    {
        nops = 0;
        (void)elapsed_time();
        printf("%d -> fibonacci : %lld", i, fibonacciRecursive(i));
        printf("\tTime: %f\tNum ops: %d\n", elapsed_time(), nops);
    }
    
    printf("Implementacao iterativa\n");
    for (int i = 0; i < 36; i++)
    {
        nops = 0;
        (void)elapsed_time();
        printf("%d -> fibonacci : %lld", i, fibonacciIterative(i));
        printf("\tTime: %f\tNum ops: %d\n", elapsed_time(), nops);
    }

    printf("Implementacao de recorrencia\n");
    for (int i = 0; i < 36; i++)
    {
        nops = 0;
        (void)elapsed_time();
        printf("%d -> fibonacci : %lld", i, fibonacciRecurrence(i));
        printf("\tTime: %f\tNum ops: %d\n", elapsed_time(), nops);
    }

    return 0;
}

long long fibonacciRecursive(int n) 
{
    if(n <= 1) return (long long)n;
    
    nops += 2;
    return 3 * fibonacciRecursive(n - 1) + 2 * fibonacciRecursive(n - 2);
}

long long fibonacciIterative(int n) 
{
    if (n <= 1) return (long long)n;
    long long x = 0;
    long long y = 1;
    long long result = 0;
    for (int i = 2; i <= n; i++)
    {
        nops += 2;
        result = 3 * y + 2 * x;
        x = y;
        y = result; 
    }
    return result;
}

long long fibonacciRecurrence(int n) 
{
    nops += 2;
    return round(c1 * exp(c2 * n));
}
