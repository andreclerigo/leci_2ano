#include <detpic32.h>

void delay(int ms);

int main (void)
{
    TRISE = TRISE & 0xFFF0;
    int cnt = 0;

    while (1)
    {
        LATE = (LATE & 0xFFF0) | cnt;
        delay(250);     // 250ms to get 4hz
        cnt++;

        if(cnt > 15)
        {
            cnt = 0;
        }
    }
    
    return 0;
}

void delay(int ms)
{
    for (;ms > 0; ms--)
    {
        resetCoreTimer();
        readCoreTimer();
        while(readCoreTimer() < 20000);
    }
}