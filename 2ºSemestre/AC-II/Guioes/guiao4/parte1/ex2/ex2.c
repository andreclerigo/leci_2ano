#include <detpic32.h>

void delay(int ms);

int main (void)
{
	LATE = LATE & 0xFFF0;		// Force 0 as the outpu
    TRISE = TRISE & 0xFFF0;     // Configure port as outpus
    int cnt = 0;

    while (1)
    {
        LATE = (LATE & 0xFFF0) | cnt;
        delay(250);             // delay 250ms -> 4hz
        cnt++;

        if(cnt > 15)            // only count to 15
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
