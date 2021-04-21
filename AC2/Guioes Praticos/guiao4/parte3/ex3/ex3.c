#include <detpic32.h>

void send2displays(unsigned char value);
void warningReset(int ms, unsigned char value);
unsigned char toBcd(unsigned char value);
void delay(int ms);

int main(void)
{
    TRISB = TRISB & 0x80FF;         // RB14 to RB8 as output
    TRISD = TRISD & 0xFF9F;         // Displays high/low as output
    
    int counter = 0;
    int i = 0;
    while(1)
    {
        i++;
        send2displays(toBcd(counter));
        delay(10);                  // delay 10 ms -> update display at 100hz
        if(i % 20 == 0)            // update counter at -> 1hz
            if (++counter == 60)
            {
                counter = 0;
                warningReset(5000, counter);
            }              
    }
    return 0;
}

void warningReset(int ms, unsigned char value)
{   
    int cnt = 0;
    int i;
    while (cnt < 5)
    {
        i = 1;
        while(i % 50 != 0)
        {
            send2displays(toBcd(value));
            delay(10); 
            i++;
        }
        LATB = (LATB & 0x80FF);
        delay(500);                 // delay 500ms
        cnt++;
    }
}

void send2displays(unsigned char value)
{
    static const char display7Scodes[] = {
                                        0x3F, //0
                                        0x06, //1
                                        0x5B, //2
                                        0x4F, //3
                                        0x66, //4
                                        0x6D, //5
                                        0x7D, //6
                                        0x07, //7
                                        0x7F, //8
                                        0x6F, //9
                                        0x77, //A
                                        0x7C, //b
                                        0x39, //C
                                        0x5E, //d
                                        0x79, //E
                                        0x71  //F
                                        };
    static char displayFlag = 0;

    unsigned char dh = value >> 4;
    unsigned char dl = value & 0x0F;


    dh = display7Scodes[dh];
    dl = display7Scodes[dl];
    
    if (displayFlag == 0)
    {
        LATD = (LATD | 0x0040) & 0xFFDF;
        LATB = (LATB & 0x80FF) | ((unsigned int)(dh)) << 8;
    } else {
        LATD = (LATD | 0x0020) & 0xFFBF;
        LATB = (LATB & 0x80FF) | ((unsigned int)(dl)) << 8;
    }
    displayFlag = !displayFlag;
}

unsigned char toBcd(unsigned char value) 
{
    return ((value / 10) << 4) + (value % 10);
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