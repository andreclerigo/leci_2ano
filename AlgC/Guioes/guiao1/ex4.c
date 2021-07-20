#include <stdio.h>
#include <math.h>
#define PI 3.14159265359

int main(void)
{
    int min;
    int max;
    int increment;
    FILE *fptr;

    fptr = fopen("file.txt","w");

    printf("Lowest value: ");
    scanf("%d", &min);
    printf("Biggest value: ");
    scanf("%d", &max);
    printf("Increment: ");
    scanf("%d", &increment);
    
    printf("ang\tsin(ang)\tcos(ang)\n");
    printf("--------------------------------\n");
    fprintf(fptr, "ang\tsin(ang)\tcos(ang)\n");
    fprintf(fptr, "--------------------------------\n");

    for (int i = min; i <= max; i+=increment)
    {
        //User inputs degrees but functions take radians
        printf("%d\t%lf\t%lf\n", i, sin(i * (PI/180)), cos(i * (PI/180)));
        fprintf(fptr,"%d\t%lf\t%lf\n", i, sin(i * (PI/180)), cos(i * (PI/180)));
    }
    
    fclose(fptr);
    return 0;
}
