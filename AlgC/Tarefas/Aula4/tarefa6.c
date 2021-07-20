#include <stdio.h>
#include <stdlib.h>

void bubbleSort(int a[], int n);
void selectionSort(int a[], int n);
void insertionSort( int a[], int n );
void insertElement(int sorted[], int n, int elem);
void swap(int *a, int *b);

static int nComp;

int main(void)
{
    int randArray[100];
    /* int randArray2[1000];
    int randArray3[10000]; */

    for(int i = 0; i < 100; i++)
        randArray[i] = rand() % 100;
    /* for(int i = 0; i < 1000; i++)
        randArray2[i] = rand() % 100;
    for(int i = 0; i < 10000; i++)
        randArray3[i] = rand() % 100; */

    printf("Desordenado:\n");
    for(int i = 0; i < 100; i++)
    {
        printf("%d, ", randArray[i]);
    }

    
    /* for(int i = 0; i < 1000; i++)
    {
        printf("%d, ", randArray2[i]);
    } */

    nComp = 0;
    selectionSort(randArray, 100);
    printf("\n\nOrdenado:\n");
    for(int i = 0; i < 100; i++)
    {
        printf("%d, ", randArray[i]);
    }
    printf("\nComps: %d", nComp);

    return 0;
}

void bubbleSort(int a[], int n) {
    int k = n; int stop = 0;
    while(stop == 0) {
        stop = 1; k--;
        for(int i = 0; i < k; i++)
        {
            nComp++;
            if(a[i] >= a[i + 1]) {
                swap(&a[i], &a[i + 1]);
                stop = 0;
            }
        }
    }
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
        }
    }
}

void insertionSort(int a[], int n) 
{
    for(int i = 1; i < n; i++) 
    {
        nComp++;
        if(a[i] < a[i - 1])
            insertElement(a, i, a[i]);
    }    
}

void insertElement(int sorted[], int n, int elem) 
{
    // sorted está ordenado 
    // Há espaço para acrescentar mais um elemento
    int i;
    for(i = n - 1; (i >= 0) && (elem < sorted[i]); i--)
        sorted[i + 1] = sorted[i];
    sorted[i + 1] = elem;
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
