#include <detpic32.h>

/**
 * OC1RS = Ton / Tout_presc 
 * Tout_presc(100Hz) = 0,2 us 
 * OC1RS = Ton / 2*10^-7
 **/

void setPWM(unsigned int dutyCycle)
{
    if (dutyCycle >= 0 && dutyCycle <= 100)
        OC1RS = (int) ((dutyCycle / 100.0) * 0.01 * 5000000);
}