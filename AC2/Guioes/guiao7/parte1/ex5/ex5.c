#include <detpic32.h>

void configureAll();
void send2displays(char value);
unsigned char toBcd(unsigned char value);
int voltageConversion(int value);

volatile int voltage = 0;       // Global variable

int main(void)
{
    configureAll();             // Function to configure all (digital I/O, analog                           
                                // input, A/D module, timers T1 and T3, interrupts)
    
    IFS0bits.T3IF = 0;          // Reset timer T3 interrupt flag
    IFS0bits.T1IF = 0;          // Reset timer T1 interrupt flag
    IFS1bits.AD1IF = 0;         // Reset A/D interrupt flag

    EnableInterrupts();
    while (1);    

    return 0;
}

void configureAll()
{
    // Timer3
    T3CONbits.TCKPS = 2;        // 1:4 prescaler Fout_presc = 5Mhz;
    PR3 = 49999;                // Fout = 20Mhz / 4(49999+1) = 100Hz
    TMR3 = 0;                   // Reset timer T3 count register
    T3CONbits.TON = 1;          // Enable timer T3
    // Timer1
    T1CONbits.TCKPS = 3;        // 1:256 prescaler Fout_presc = 78125;
    PR1 = 39062;                // Fout = 20Mhz / 256(19530 + 1) = 4,00005Hz
    TMR1 = 0;                   // Reset timer T1 count register
    T1CONbits.TON = 1;          // Enable timer T1 
    
    // Displays
    TRISB = TRISB & 0x80FF;     // RB14 to RB8 as output
    TRISD = TRISD & 0xFF9F;     // Displays high/low as output

    // ADC
    TRISBbits.TRISB4 = 1;       // RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      // RB4 configured as analog input (AN4)
    AD1CON1bits.SSRC = 7;       // Conversion trigger constant
    AD1CON1bits.CLRASAM = 1;    // Stop conversion when the 1st A/D converter intetupr is generated. At the same time, hardware clears ASAM bit
    AD1CON3bits.SAMC = 16;      // Sample time is 16 TAD (TAD = 100ns)
    AD1CON2bits.SMPI = 7;       // Interrupt is generated after 8 samples
    AD1CHSbits.CH0SA = 4;       // analog channel input 4
    AD1CON1bits.ON = 1;         // Enable the A/d configuration sequence

    // Enable interrupts ADC, T1, T3
    IPC6bits.AD1IP = 2;         // configure priority of A/D interrupts
    IEC1bits.AD1IE = 1;         // Enable A/D interrupts
    IPC1bits.T1IP = 1;          // Interrupt priority 1
    IEC0bits.T1IE = 1;          // Enable timer T1 interrupts
    IPC3bits.T3IP = 3;          // Interrupt priority 2
    IEC0bits.T3IE = 1;          // Enable timer T3 interrupts
}

void _int_(4) isr_T1(void)
{
    AD1CON1bits.ASAM = 1;           // Start conversion
    IFS0bits.T1IF = 0;
}

void _int_(12) isr_T3(void)
{
    send2displays(toBcd(voltage));  // Send "voltage" global variable to displays
    IFS0bits.T3IF = 0;
}

void _int_(27) isr_adc(void)
{
    int sum = 0, i = 0;
    int *p = (int *)&ADC1BUF0;
    for (i = 0; i < 8; i++)
        sum += p[i * 4];

    voltage = sum / 8;
    voltage = voltageConversion(voltage);
    IFS1bits.AD1IF = 0;             // Reset AD1IF flag
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

unsigned char toBcd(unsigned char value)
{
    return ((value / 10) << 4) + (value % 10);
}

int voltageConversion(int value)
{
    return (value * 33 + 511) / 1024;
}