#include <assert.h>
#include <stdio.h>

int func(int array[], int size);

static int nComp;
int array1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int array2[] = {1, 2, 1, 3, 5, 6, 7, 8, 9, 10};
int array3[] = {1, 2, 1, 3, 2, 6, 7, 8, 9, 10};
int array4[] = {0, 2, 2, 0, 3, 3, 0, 4, 4, 0};
int array5[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
int teste[] = {1, 2};
int teste2[] = {1, 2, 3, 1};
int teste3[] = {1, 2, 3, 1, 2, 1};
int teste4[] = {1, 2, 0};

int main(void)
{   
    int res;

    // Testing the results for all of my arrays

    /*// Testing arrays with 2 elements or less
    nComp = 0;
    res = func(teste, sizeof(teste)/sizeof(teste[0]));
    printf("Test Array\nResult: %d\nNum of operations: %d\n\n", res, nComp); */

    nComp = 0;
    res = func(array1, sizeof(array1)/sizeof(array1[0]));
    printf("Array1\nResult: %d\nnNum of operations: %d\n\n", res, nComp);

    nComp = 0;
    res =  func(array2, sizeof(array2)/sizeof(array2[0]));
    printf("Array2\nResult: %d\nnNum of operations: %d\n\n", res, nComp);

    nComp = 0;
    res = func(array3, sizeof(array3)/sizeof(array3[0]));
    printf("Array3\nResult: %d\nNum of operations: %d\n\n", res, nComp);

    nComp = 0;
    res = func(array4, sizeof(array4)/sizeof(array4[0]));
    printf("Array4\nResult: %d\nNum of operations: %d\n\n", res, nComp);

    nComp = 0;
    res = func(array5, sizeof(array5)/sizeof(array5[0]));
    printf("Array5\nResult: %d\nNum of operations: %d\n\n", res, nComp);

    nComp = 0;
    res = func(teste2, sizeof(teste2)/sizeof(teste2[0]));
    printf("Test2\nResult: %d\nNum of operations: %d\n\n", res, nComp);

    nComp = 0;
    res = func(teste3, sizeof(teste3)/sizeof(teste3[0]));
    printf("Test3\nResult: %d\nNum of operations: %d\n\n", res, nComp);

    nComp = 0;
    res = func(teste4, sizeof(teste4)/sizeof(teste4[0]));
    printf("Test4\nResult: %d\nNum of operations: %d\n\n", res, nComp);
    
    return 0;
}

int func(int array[], int size) 
{
    assert(size > 2 && "The array must have 3 elements or more.");
    int res = 0;    // Number of elements that verify the condition

    // 0 < i < (n –1)
    for (int i = 1; i < size - 1; i++)
    {
        nComp++;  // Compares every element that has a neighbor
        // Elem = sum of neighbors
        if(array[i] == (array[i - 1] + array[i + 1]))   
        {   
            res++;  
        }
    }
    return res;
}