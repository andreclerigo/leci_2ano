#include <stdio.h>

unsigned int f1(unsigned int n);
unsigned int f2(unsigned int n);
unsigned int f3(unsigned int n);
unsigned int f4(unsigned int n);

static unsigned int niter = 0;

unsigned int f1(unsigned int n)
{
    unsigned int i, j, r = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            r += 1;
            niter++;
        }
    }
    return r;
}

unsigned int f2(unsigned int n)
{
    unsigned int i, j, r = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            r += 1;
            niter++;
        }
    }
    return r;
}

unsigned int f3(unsigned int n)
{
    unsigned int i, j, r = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = i; j <= n; j++)
        {
            r += j;
            niter++;
        }
    }
    return r;
}

unsigned int f4(unsigned int n)
{
    unsigned int i, j, r = 0;
    for (int i = 1; i <= n; i++)
    {
        for (j = i; j >=1; j /= 10)
        {
            r += i;
            niter++;
        }
    }
    return r;
}

int main(void)
{
    FILE *fptr;
    fptr = fopen("file.tsv", "w");

    unsigned int r;
    printf("   N\t  f1(n)\t   iter\t  f2(n)\t   iter\t  f3(n)\t   iter\t  f4(n)\t   iter\n");
    fprintf(fptr, "   N\t  f1(n)\t   iter\t  f2(n)\t   iter\t  f3(n)\t   iter\t  f4(n)\t   iter\n");
    for (unsigned int n = 1; n <= 15; n++)
    {
        niter = 0;
        r = f1(n);
        printf("%4u\t%7u\t%7u\t", n, r, niter);
        fprintf(fptr, "%4u\t%7u\t%7u\t", n, r, niter);

        niter = 0;
        r = f2(n);
        printf("%7u\t%7u\t", r, niter);
        fprintf(fptr, "%7u\t%7u\t", r, niter);

        niter = 0;
        r = f3(n);
        printf("%7u\t%7u\t", r, niter);
        fprintf(fptr, "%7u\t%7u\t", r, niter);

        niter = 0;
        r = f4(n);
        printf("%7u\t%7u\n", r, niter);
        fprintf(fptr, "%7u\t%7u\n", r, niter);
    }    
    return 0;
}