#include <stdio.h>
#include <assert.h>

void func(int a[], int* size);
void printArray(int a[], int size);
int isValid(int element, int a[], int size);

static int nComp;
static int nCopy;

int main(void)
{
    int array[][10] = {
        {2, 2, 2, 3, 3, 4, 5, 8, 8, 9},
        {7, 8, 2, 2, 3, 3, 3, 8, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 3, 5, 7, 11, 13, 17, 19, 23, 29},
        {2, 2, 5, 7, 11, 13, 17, 19, 23, 29},
        {2, 4, 5, 7, 11, 13, 17, 19, 23, 29},
    };

    int size;
    for (int i = 0; i < 7; i++)
    {
        size = 10;
        nComp = 0;
        nCopy = 0;
        func(array[i], &size);
        printArray(array[i], size);
        printf("Comps - %d \t Copys - %d\n\n", nComp, nCopy);
    }
    return 0;
}

void func(int a[], int* size)
{
    assert(*size > 1 && "The array must have 2 elements or more.");
    
    int cont = 1;  // Posição onde se escreve valores válidos
    for (int i = 1; i < *size; i++)
    {   
        nComp++;
        if(isValid(a[i], a, cont))
        {
                nComp++;
                // Não rescrever valores que já estão no sitio correto
                if(a[cont] != a[i])  
                {
                    nCopy++;  // Rescrever array com valor válido
                    a[cont++] = a[i];    
                } else
                    cont++;
        }
    }
    *size = cont;
}

int isValid(int element, int a[], int i)
{
    for (int j = 0; j < i; j++)
    {
        nComp++;  // Verificar se o elemento é multiplo ou igual a a[j]
        if(element % a[j] == 0) return 0;

        nComp++;  // Verificar se o elemento é divisor de a[j]
        if(a[j] % element == 0) return 0;
    }
    return 1;
}

void printArray(int a[], int size)
{
    printf("Array: ");
    for (int i = 0; i < size; i++)
    {
        printf("%d, ", a[i]);
    }
    printf("\n");
}