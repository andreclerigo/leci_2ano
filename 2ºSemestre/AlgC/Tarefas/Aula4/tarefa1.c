#include <stdio.h>

void bubbleSort(int a[], int n);
void swap(int *a, int *b);

static int array[] = {1, 2, 4, 5, 8, 3, 7};
static int array1[] = {1, 2, 3, 4, 5, 6, 7};
static int array2[] = {7, 6, 5, 4, 3, 2, 1};
static int nComp;
static int nSwap;

int main(void)
{
    printf("Normal array\n");
    int size = sizeof(array)/sizeof(*array);
    bubbleSort(array, size);
    for (int i = 0; i < size; i++)
    {
        printf("%d, ", array[i]);
    }
    printf("\nComparisons: %d\n", nComp);
    printf("Swaps: %d\n", nSwap);
    
    nComp = 0;
    nSwap = 0;
    printf("\nBest array swap\n");
    bubbleSort(array1, size);
    for (int i = 0; i < size; i++)
    {
        printf("%d, ", array1[i]);
    }
    printf("\nComparisons: %d\n", nComp);
    printf("Swaps: %d\n", nSwap);

    nComp = 0;
    nSwap = 0;
    printf("\nWorst array swap\n");
    bubbleSort(array2, size);
    for (int i = 0; i < size; i++)
    {
        printf("%d, ", array2[i]);
    }
    printf("\nComparisons: %d\n", nComp);
    printf("Swaps: %d\n", nSwap);

    printf("O melhor numero de comparacoes coincide com o melhor numero de trocas (array ordenado) vistos que este apenas precisa de comparar n-1 elementos e realizar 0 trocas\n");
    printf("O piot numero de comparacoes coincide com o pior numero de trocas (array invertido), vistos que vai ter que trocar todos os elementos e voltar a comparar para saber se já está ordenado\n");
    
    return 0;
}


void bubbleSort( int a[], int n ) {
    int k = n; int stop = 0;
    while(stop == 0) {
        stop = 1; k--;
        for(int i = 0; i < k; i++)
        {
            nComp++;
            if(a[i] >= a[i + 1]) {
                swap(&a[i], &a[i + 1]);
                nSwap++;
                stop = 0;
            }
        }
    }
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
