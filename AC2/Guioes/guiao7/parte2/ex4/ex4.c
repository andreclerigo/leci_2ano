#include <detpic32.h>

volatile int voltage;

void main(void)
{
    int dutyCycle;
    configureAll();
    EnableInterrupts(); // Global Interrupt Enable
    while(1)
    {
        // Read RB1, RB0 to the variable "portVal"
        switch(portVal)
        {
            case 0: // Measure input voltage
                // Enable T1 interrupts
                setPWM(0); // LED OFF
                break;
            case 1: // Freeze
                // Disable T1 interrupts
                setPWM(100); // LED ON (maximum bright)
                break;
            default: // LED brigthness control
                // Enable T1 interrupts
                dutyCycle = voltage * 3;
                setPWM(dutyCycle);
                break;
        }
    }
}