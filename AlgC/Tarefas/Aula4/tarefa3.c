#include <stdio.h>

void selectionSort(int a[], int n);
void swap(int *a, int *b);

static int arr[] = {1, 8, 4, 5, 7, 6, 0};
static int arr1[] = {1, 2, 3, 4, 5, 6, 7};
static int arr2[] = {7, 6, 5, 4, 3, 2, 1};
static int arr3[] = {1, 7, 6, 4, 5, 3, 2, 8};
static int nSwap;
static int nComp;

int main(void)
{
    printf("Normal array\n");
    int size = sizeof(arr)/sizeof(*arr);
    selectionSort(arr, size);
    for (int i = 0; i < size; i++)
    {
        printf("%d, ", arr[i]);
    }
    printf("\nComparisons: %d\n", nComp);
    printf("Shifts: %d\n", nSwap);

    printf("\nBest shift array\n");
    nComp = 0;
    nSwap = 0;
    selectionSort(arr1, size);
    for (int i = 0; i < size; i++)
    {
        printf("%d, ", arr1[i]);
    }
    printf("\nComparisons: %d\n", nComp);
    printf("Shifts: %d\n", nSwap);

    printf("\nWorst shift array\n");
    nComp = 0;
    nSwap = 0;
    selectionSort(arr2, size);
    for (int i = 0; i < size; i++)
    {
        printf("%d, ", arr2[i]);
    }
    printf("\nComparisons: %d\n", nComp);
    printf("Shifts: %d\n", nSwap);

    printf("\nAverage shift array\n");
    nComp = 0;
    nSwap = 0;
    selectionSort(arr3, 8);
    for (int i = 0; i < 8; i++)
    {
        printf("%d, ", arr3[i]);
    }
    printf("\nComparisons: %d\n", nComp);
    printf("Shifts: %d\n", nSwap);

    printf("\nO numero de comparacoes e constante e so depende do tamanho do array\n");
    printf("O melhor caso para deslocamentos e quando o array esta ordenado e o pior caso acontece quando o array é invertido\n");
    printf("Podemos ver que o caso extremo de shifts (int)size_of_array/2");

    return 0;
}
    
void selectionSort(int a[], int n) 
{
    for( int k = n-1; k > 0; k--) 
    {
        int indMax= 0;
        for(int i = 1; i <= k; i++) 
        {
            nComp++;
            if(a[i] >= a[indMax])
            {
                indMax= i;
            }
        }
        if(indMax!= k) 
        {
            swap(&a[indMax], &a[k]);
            nSwap++;
        }
    }
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
