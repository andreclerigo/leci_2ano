#include <assert.h>
#include <stdio.h>

int func(int array[], int size);

static int nComp;
int array[][10] = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 1, 3, 5, 6, 7, 8, 9, 10},
            {1, 2, 1, 3, 2, 6, 7, 8, 9, 10},
            {0, 2, 2, 0, 3, 3, 0, 4, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            };
int sizes[] = {5, 10, 20, 30, 40};

int teste[] = {1, 2};


int main(void)
{   
    int res;

    // Testing the results for all of my arrays
    /*// Testing arrays with 2 elements or less
    nComp = 0;
    res = func(teste, sizeof(teste)/sizeof(teste[0]));
    printf("Test Array\nResult: %d\nnNum of operations: %d\n\n", res, nComp); */
    for (int k = 0; k < 5; k++)
    {
        nComp = 0;
        res = func(array[k], 10);
        printf("Array%d\nResult: %d\nNum of operations: %d\n\n", k, res, nComp);
    }

    for (int k = 0; k < 5; k++)
    {
        nComp = 0;
        int size = sizes[k];
        res = func(array[0], size);
        printf("Array%d\nResult: %d\nNum of operations: %d\n\n", size, res, nComp);
    }
    
    return 0;
}

int func(int array[], int size) 
{
    assert(size > 2 && "The array must have 3 elements or more.");
    int res = 0;    // Number of elements that verify the condition
    
    // i < j < k
    /* for (int i = 0; i < size - 2; i++)
    {    
        for (int j = i + 1; j < size - 1; j++)
        {
            for (int k = j + 1; k < size; k++)
            {
                nComp++;
                if(array[k] == (array[i] + array[j]))   
                {   
                    res++;  
                }
            }
        }
    } */

    // Feito para mais facilmente obter a formula fechada em somatório
    for (int k = 2; k < size ; k++)
    {    
        for (int j = 1; j < k; j++)
        {
            for (int i = 0; i < j; i++)
            {
                nComp++;
                if(array[k] == (array[i] + array[j]))   
                {   
                    res++;  
                }
            }
        }
    }

    return res;
}