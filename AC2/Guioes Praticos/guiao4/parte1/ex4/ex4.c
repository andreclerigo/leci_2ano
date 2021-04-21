#include <detpic32.h>

void delay(int ms);

int main (void)
{
    unsigned char segment;
    int i;
    LATDbits.LATD6 = 1;     // Display h off
    LATDbits.LATD5 = 0;     // Display H on
    TRISB = TRISB & 0x80FF; // RB14 - RB8 as output
    TRISD = TRISD & 0xFF9F; // RD6 - RD5 as output

    while (1)
    {   
        // Toggle displays selection
        LATDbits.LATD6 = !LATDbits.LATD6;
        LATDbits.LATD5 = !LATDbits.LATD5;
        segment = 1;
        for (i = 0; i < 7; i++)
        {
            LATB = (LATB & 0x80FF) | ((unsigned int)(segment)) << 8;  // Clean the display and set the right display ON
            delay(500);     // wait 0.5s -> 2Hz
            segment = segment << 1;
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