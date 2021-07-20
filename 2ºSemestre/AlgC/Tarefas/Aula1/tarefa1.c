#include <stdio.h>

void algoritmo1(int *a);
void algoritmo2(int *a);

int a[] = {1, 3, 4, 2};
//int a[] = {4, 2, 1, 3};
int *aPt = a;
int comp = 0;
int atr = 0;
int maior;

int main()
{
    printf("Exemplo 1:\n");
    algoritmo1(aPt);
    printf("Comparacoes: %d\n", comp);
    printf("Atribuicoes: %d\n", atr);
    printf("Maior: %d\n", maior);
    //A ordem dos dados não é importante

    printf("\nExemplo 2:\n");
    comp = 0;
    atr = 0;
    algoritmo2(aPt);
    printf("Comparacoes: %d\n", comp);
    printf("Atribuicoes: %d\n", atr);
    printf("Maior: %d\n\n", maior);
    //A ordem dos dados é importante
    return 0;
}

void algoritmo1(int *a)
{
    comp++;
    if (a[0] > a[1])
    {   
        comp++;
        if (a[0] > a[2])
        {
            comp++;
            if (a[0] > a[3])
            {
                atr++;
                maior = a[0];
            } else {
                atr++;
                maior = a[3];
            }
        } else {
            comp++;
            if (a[2] > a[3])
            {
                atr++;
                maior = a[2];
            } else {
                atr++;
                maior = a[3];
            }
        }
    } else {
        comp++;
        if (a[1] > a[2])
        {
            comp++;
            if (a[1] > a[3])
            {
                atr++;
                maior = a[1];
            } else {
                atr++;
                maior = a[3];
            }
        } else {
            comp++;
            if (a[2] > a[3])
            {
                atr++;
                maior = a[2];
            } else {
                atr++;
                maior = a[3];
            }
        }
    }
}

void algoritmo2(int *a)
{
    maior = a[0];

    comp++;
    if (a[1] > maior)
    {
        atr++;
        maior = a[1];
    }
    comp++;
    if (a[2] > maior)
    {
        atr++;
        maior = a[2];
    }
    comp++;
    if (a[3] > maior)
    {
        atr++;
        maior = a[3];
    }
}