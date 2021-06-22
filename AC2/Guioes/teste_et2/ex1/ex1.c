#include <detpic32.h>

void setPWM(int dutycycle);
void configureTimer(void);

int main(void)
{
	int portVal;
	// Configure Timer 3
	configureTimer();
	// Configure Deepswitches
	TRISB = TRISB | 0x000F;		//RB[0..4] as input
	
	while(1)
	{
		portVal = PORTB & 0x000F;
		switch(portVal)
		{
			case 1: setPWM(25);
					break;
			case 2: setPWM(50);
					break;
			case 3: setPWM(75);
					break;
			case 4: setPWM(100);
					break;	
		}
	}
	
	return 0;
}

void configureTimer()
{
	//Kprescaler = ceil(20Mhz/(65536*100)) = 4
	T3CONbits.TCKPS = 2;
	//PR3 = (5Mhz/100)-1  = 49999
	PR3 = 49999;
	TMR3 = 0;
	T3CONbits.TON = 1;
	OC1CONbits.OCM = 6;
	OC1CONbits.OCTSEL = 1;
	OC1CONbits.ON = 1;
}

void setPWM(int dutycycle)
{
	if (dutycycle >= 0 && dutycycle <= 100)
		OC1RS = (dutycycle * (PR3 + 1))/100;
}
