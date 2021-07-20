#include <detpic32.h>

void delay(int ms);

int main(void) 
{
    LATCbits.LATC14 = 0;        // Output value as 0
    TRISCbits.TRISC14 = 0;      // Configure port as output

    while (1)
    {   
        delay(500);             // freq = 2Hz
        LATCbits.LATC14 = !LATCbits.LATC14;
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