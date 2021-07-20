#include <stdio.h>

int main(void)
{
    int a[3][2] = {
                    {1, 2},
                    {2, 1},
                    {3, 2}
                };
    
    int b[2][4] = {
                    {2, 2, 2, 3},
                    {2, 3, 3, 3}
                };

    int c[3][4];

    for(int i = 0; i < 3; i++) 
    {
        for(int j =0 ; j < 4; j++) 
        {
            c[i][j] = 0;
            for(int k = 0; k < 2; k++) 
            {
                c[i][j] += a[i][k] * b[k][j];
            }
        }
    }

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            printf("%d,", c[i][j]);
        }
        puts("");
    }
    
}