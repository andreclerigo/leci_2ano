#include <stdio.h>

int searchMax(int a[], int n);
int searchLastMax(int a[], int n);
int searchMin(int a[], int n);
int searchLastMin(int a[], int n);

int main(void)
{
    int a[] = {4, 3, 3, 5, 5, 12, 18, 18, 10};

    printf("1 algoritmo: %d\n", searchMax(a, sizeof(a)/sizeof(a[0])));
    printf("2 algoritmo: %d\n", searchLastMax(a, sizeof(a)/sizeof(a[0])));
    printf("3 algoritmo: %d\n", searchMin(a, sizeof(a)/sizeof(a[0])));
    printf("4 algoritmo: %d\n", searchLastMin(a, sizeof(a)/sizeof(a[0])));
}

int searchMax(int a[], int n) 
{
    int atr = 0;
    int indexMax = 0;
    for(int i = 1; i < n; i++) 
    {
        if(a[i] > a[indexMax]) 
        {
            indexMax = i;
            atr++;
        }
    }
    printf("Atribuicoes: %d\t", atr);
    return indexMax;
}

int searchLastMax(int a[], int n) 
{
    int atr = 0;
    int indexMax = 0;
    for(int i = 1; i < n; i++) 
    {
        if(a[i] >= a[indexMax]) 
        {
            indexMax = i;
            atr++;
        }
    }
    printf("Atribuicoes: %d\t", atr);
    return indexMax;
}

int searchMin(int a[], int n) 
{
    int atr = 0;
    int indexMin = 0;
    for(int i = 1; i < n; i++) 
    {
        if(a[i] < a[indexMin]) 
        {
            indexMin = i;
            atr++;
        }
    }
    printf("Atribuicoes: %d\t", atr);
    return indexMin;
}

int searchLastMin(int a[], int n) 
{
    int atr = 0;
    int indexMin = 0;
    for(int i = 1; i < n; i++) 
    {
        if(a[i] <= a[indexMin]) 
        {
            indexMin = i;
            atr++;
        }
    }
    printf("Atribuicoes: %d\t", atr);
    return indexMin;
}

//Mantem-se o número de atribuições para o melhor e pior caso quando todos os elementos são diferentes
//O que muda (às vezes) é o número de atribuições quando há elementos iguais (normalmente quando estão no inicio e sao condiredados o maior valor até ao momento)