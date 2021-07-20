#include <stdio.h>

int f1(int n);
int f2(int n);
int f3(int n);
int f4(int n);

int main(void)
{
    int n = 5;
    printf("%d\n", f1(n));
    printf("%d\n", f2(n));
    printf("%d\n", f3(n));
    printf("%d\n", f4(n));
}

int f1(int n) {
    int i,r=0;
    int cont=0;
    for(i = 1; i <= n; i++)
    {
        cont +=1;
        r += i;
    }
    return cont;
}

int f2(int n) {
    int i,j,r=0;
    for(i = 1; i <= n; i++)
    {
        for(j = 1; j <= n; j++)
        {
            r += 1;
        }
    }    
    return r;
}

int f3(int n) {
    int i,j,r=0;
    for(i = 1; i <= n; i++)
    {
        for(j = i; j <= n; j++)
        {
            r += 1;
        }
    }
    return r;
}

int f4(int n) {
    int i,j,r=0;
    int cont = 0;
    for(i = 1; i <= n; i++)
    {
        for(j = 1; j <= i; j++) {
            r += j;
            cont += 1;
        }
    }
    return r;
} 