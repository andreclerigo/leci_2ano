#include <stdio.h>
#include <math.h>

int main(void)
{
    double num;

    printf("How many lines: ");
    scanf("%lf", &num);
    
    for (size_t i = 1; i <= num; i++)
    {
        printf("%lf \t %lf\n", sqrt(i), pow(i, 2));
    }
    
    return 0;
}