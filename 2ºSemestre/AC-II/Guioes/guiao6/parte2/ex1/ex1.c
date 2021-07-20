#include <detpic32.h>

volatile int adc_value;

int main(void)
{
    TRISE = TRISE & 0xFFFE;     // RE0 as output
    
    TRISBbits.TRISB4 = 1;       // RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      // RB4 configured as analog input (AN4)
    AD1CON1bits.SSRC = 7;       // Conversion trigger constant
    AD1CON1bits.CLRASAM = 1;    // Stop conversion when the 1st A/D converter intetupr is generated.
                                // At the same time, hardware clears ASAM bit
    AD1CON3bits.SAMC = 16;      // Sample time is 16 TAD (TAD = 100ns)
    AD1CON2bits.SMPI = 0;       // Interrupt is generated after 1 sample
    AD1CHSbits.CH0SA = 4;       // analog channel input 4
    AD1CON1bits.ON = 1;         // Enable the A/d configuration sequence

    // Enable interrupts ADC
    IPC6bits.AD1IP = 2;         // configure priority of A/D interrupts
    IFS1bits.AD1IF = 0;         // clear A/D interrupt flag
    IEC1bits.AD1IE = 1;         // enable A/D interrupts
    
    EnableInterrupts();

    AD1CON1bits.ASAM = 1;       // Start conversion
    resetCoreTimer();
    while (1) { }
       
    return 0;
}

//Interrupt handler
void _int_(27) isr_adc(void)
{
    int time = readCoreTimer();

    LATE = LATE & 0xFFFE;       // LATE0 = 0;
    adc_value = ADC1BUF0;
    LATE = LATE | 0x0001;       // LATE0 = 1;

    time *= 50;                 // Convert to ns (PBClk -> 20Mhz -> 50ns)
    time -= 3600;               // Remove the time kown for conversion
    printInt10(time);
    putChar('\n');

    resetCoreTimer();
    AD1CON1bits.ASAM = 1;       // Start conversion
    IFS1bits.AD1IF = 0;
}