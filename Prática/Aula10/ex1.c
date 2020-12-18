#include<stdio.h>

double xtoy(double x, int y);
int abs(int val);

int main(void) {
    double x;
    int y;
    double result;

    printf("Qual o valor de X? ");
    scanf("%lf", &x);
    printf("Qual o valor de Y? ");
    scanf("%d", &y);

    result = xtoy(x, y);
    printf("Resultado: %.4lf", result);

    return 0;
}

double xtoy(double x, int y) {
    int i;
    double result;

    for(i = 0, result = 1.0; i < abs(y); i++) {
        if(y > 0)
            result *= x;
        else
            result /= x;
    }
    return result;
}

int abs(int val) {
    if(val < 0)
        val = -val;
    return val;
}