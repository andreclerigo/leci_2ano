#include <detpic32.h>

void setPWM(unsigned int dutyCycle);

int main(void)
{
    // Timer3
    T3CONbits.TCKPS = 2;        // 1:4 prescaler Fout_presc = 5Mhz;
    PR3 = 49999;                // Fout = 20Mhz / 4(49999+1) = 100Hz
    TMR3 = 0;                   // Reset timer T3 count register
    T3CONbits.TON = 1;          // Enable timer T3

    OC1CONbits.OCM = 6;         // PWM mode on OCx; fault pin disabled
    OC1CONbits.OCTSEL =1;       // Use timer T3 as the time base for PWM generation
    OC1RS = 0;                  // Ton constant
    OC1CONbits.ON = 1;          // Enable OC1 module

    IPC3bits.T3IP = 3;          // Interrupt priority 2
    IEC0bits.T3IE = 1;          // Enable timer T3 interrupts
    IFS0bits.T3IF = 0;          // Reset timer T3 interrupt flag
    
    TRISB = TRISB | 0x0003;     // RB[0..1] as input

    EnableInterrupts();

    int pwmValues[4] = {10, 65, 80, 0};

    // Input of RB[0..1] determinate the arrays index value
    while (1)
        setPWM(pwmValues[PORTB & 0x03]);

    return 0;
}

void _int_(12) isr_T3(void)
{
    IFS0bits.T3IF = 0;
}

void setPWM(unsigned int dutyCycle)
{
    if (dutyCycle >= 0 && dutyCycle <= 100)
        OC1RS = (dutyCycle * (PR3 + 1)) /100;
}