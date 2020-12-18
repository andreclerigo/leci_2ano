#include<stdio.h>

double sqrt(double val);

int main(void) {
    double val, result;

    printf("Valor de X: ");
    scanf("%lf", &val);
    result = sqrt(val);
    printf("Resultado: %lf", result);

    return 0;
}

double sqrt(double val) {
    double aux, xn = 1.0;
    int i = 0;

    if(val > 0.0) {
        do {
            aux = xn;
            xn = 0.5 * (xn + val/xn);
        } while((aux != xn) && (++i < 25));
    } else {
        xn = 0.0;
    }
    return xn;
}