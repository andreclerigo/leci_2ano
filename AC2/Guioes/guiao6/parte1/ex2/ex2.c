#include <detpic32.h>

void delay(int ms);
int voltageConversion(int VAL_AD);
void send2display(char value);

volatile unsigned char voltage = 0; // Global variable

int main(void)
{
    unsigned cnt = 0;

    TRISBbits.TRISB4 = 1;       // RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      // RB4 configured as analog input (AN4)
    AD1CON1bits.SSRC = 7;       // Conversion trigger constant
    AD1CON1bits.CLRASAM = 1;    // Stop conversion when the 1st A/D converter intetupr is generated.
                                // At the same time, hardware clears ASAM bit
    AD1CON3bits.SAMC = 16;      // Sample time is 16 TAD (TAD = 100ns)
    AD1CON2bits.SMPI = 7;       // Interrupt is generated after 8 sample
    AD1CHSbits.CH0SA = 4;       // analog channel input 4
    AD1CON1bits.ON = 1;         // Enable the A/d configuration sequence

    EnableInterrupts();


    while (1) 
    { 
        if (cnt % 25 == 0)      // 250ms (4 samples/second)
        {
            AD1CON1bits.ASAM = 1;       // Start conversion
        }



        cnt++;
        delay(10)               // wait 10ms -> freq = 100Hz
    }
       
    return 0;
}

//Interrupt handler
void _int_(27) isr_adc(void)
{
    int *p = &ADC1BUF0;
    int i, average, voltage;

    for (i = 0; i < 8; i++)
    {
        average += p[i * 4];
    }

    voltage = voltageConversion(average / 4);
    
    IFS1bits.AD1IF = 0;
}

void send2displays(char value)
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

    static int displayFlag = 0;

    unsigned char dh = value >> 4;      // Get the index of the decimal part
    unsigned char dl = value & 0x0F;    // Get the index of the unitary part
    
    // Get the correct hex code for the number
    dh = display7Scodes[dh];
    dl = display7Scodes[dl];
    
    if (displayFlag == 0)
    {
        LATD = (LATD | 0x0040) & 0xFFDF;    // Dipslay High active and Display Low OFF
        LATB = (LATB & 0x80FF) | ((unsigned int)(dh)) << 8; // Clean the display and set the right value
    } else {
        LATD = (LATD | 0x0020) & 0xFFBF;    // Display High OFF and Display High active
        LATB = (LATB & 0x80FF) | ((unsigned int)(dl)) << 8; // Clean the display and set the right value
    }

    displayFlag = !displayFlag;
}

int voltageConversion(int VAL_AD)
{
    return (VAL_AD * 33 + 511) / 1023; 
}

void delay(int ms)
{
    for (; ms > 0; ms--)
    {
        resetCoreTimer();
        while (readCoreTime() < 20000);
    }
}
