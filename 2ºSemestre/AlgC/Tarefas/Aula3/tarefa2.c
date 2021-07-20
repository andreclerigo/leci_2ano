#include <stdio.h>

int binSearch(int a[], int n, int x, int iter[], int pos);
int cumSum(int array[], int size);

int main(void)
{
    int a[3] = {1, 2, 3};
    int b[7] = {1, 2, 3, 4, 5, 6, 7};
    int sizeA = sizeof(a)/sizeof(a[0]);
    int sizeB = sizeof(b)/sizeof(b[0]);

    int iterA[sizeof(a)/sizeof(a[0])];
    int iterB[sizeof(b)/sizeof(b[0])];
    

    printf("Array with 3 elements:\n");
    for (int i = 0; i < 3; i++)
    {
        printf("Pos de %d: %d\n", i+1, binSearch(a, sizeA, i+1, iterA, i));
    }
    printf("Average iteration: %f\n", (cumSum(iterA, sizeA) / (float)sizeA));
    printf("\nArray with 7 elements:\n");

    for (int i = 0; i < 7; i++)
    {
        printf("Pos de %d: %d\n", i+1, binSearch(b, sizeB, i+1, iterB, i));
    }
    printf("Average iteration: %f\n", (cumSum(iterB, sizeB) / (float)sizeB));
    
    return 0;
}

int cumSum(int array[], int size) 
{
    int sum = 0;
    for (int i = 0; i < size; i++)
    {
        sum += array[i];
    }
    return sum;
}

int binSearch(int a[], int n, int x, int iter[], int pos) 
{
    int left = 0; 
    int right = n - 1;
    int iterations = 0;

    while(left <= right) 
    {
        int middle = (left + right) / 2;
        if(a[middle] == x)
        {
            iter[pos] = iterations;
            printf("Iterations: %d \t", iterations);
            return middle;
        }
        
        if(a[middle] > x) 
            right = middle - 1;
        else 
            left = middle + 1;
        iterations++;
    }
    iter[pos] = iterations;
    printf("Iterations: %d \t", iterations);
    return -1;
} 