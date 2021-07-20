#include <stdio.h>

int main()
{
    int array[] = {1, 2, 3, 6, 5};
    //int array[] = {6, 5, 4, 3, 2};

    int greater = array[0];
    int atr = 0;
    int comp = 0;

    for (int i = 1; i < sizeof(array)/sizeof(array[0]); i++)
    {
        comp++;
        if (array[i] > greater)
        {
            greater = array[i];
            atr++;
        } 
    }
    
    printf("Comparacoes: %d\n", comp);
    printf("Atribuicoes: %d\n", atr);
    printf("Maior: %d\n", greater);
    //A ordem dos dados é importante (quanto mais proximo o maior estiver do inicio menos atribuicoes faz)
    //Faz sentido contar todas as atriubuicoes? Depende da ordem dos numeros
    return 0;
}