#include <detpic32.h>

void setPWM(int dutycycle);
void configureTimer(void);

int main(void)
{
	char portVal;
	// Configure Timer 3
	configureTimer();
	// Configure Deepswitches
	TRISB = TRISB | 0x0009;		//RB0 and 3 as input
	
	while(1)
	{
		resetCoreTimer();
		// 250us = 250*10^3 ns
		// ciclos = 250000÷50 = 5000 ciclos
		while (readCoreTimer() < 5000);
		
		portVal = PORTB & 0x0009;
		switch(portVal)
		{
			case 0x1: setPWM(25);
					break;
			case 0x8: setPWM(75);
					break;
		}
	}
	
	return 0;
}

void configureTimer()
{
	//Kprescaler = ceil(20Mhz/(65536*280)) = 2
	T3CONbits.TCKPS = 1;
	//PR3 = (10Mhz/280)-1  = 35713,...
	PR3 = 35714;
	TMR3 = 0;
	T3CONbits.TON = 1;
	OC2CONbits.OCM = 6;
	OC2CONbits.OCTSEL = 1;
	OC2CONbits.ON = 1;
}

void setPWM(int dutycycle)
{
	if (dutycycle >= 0 && dutycycle <= 100)
		OC2RS = (dutycycle * (PR3 + 1))/100;
}
