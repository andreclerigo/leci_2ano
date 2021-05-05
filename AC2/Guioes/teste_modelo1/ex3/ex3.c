#include <detpic32.h>

void delay(int ms);
void send2displays(unsigned char value);

unsigned char toBcd(unsigned char value) {
    return ((value/10) << 4) + (value % 10);
}

int main(void)
{
	TRISB = TRISB & 0x80FF;
    TRISD = TRISD & 0xFF9F;
    
    TRISBbits.TRISB4 = 1;       // RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      // RB4 configured as analog input (AN4)
    AD1CON1bits.SSRC = 7;       // Conversion trigger constant
    AD1CON1bits.CLRASAM = 1;    // Stop conversion when the 1st A/D converter intetupr is generated.
                                // At the same time, hardware clears ASAM bit
    AD1CON3bits.SAMC = 16;      // Sample time is 16 TAD (TAD = 100ns)
    AD1CON2bits.SMPI = 0;       // Interrupt is generated after 1 sample
    AD1CHSbits.CH0SA = 4;       // analog channel input 4
    AD1CON1bits.ON = 1;         // Enable the A/d configuration sequence

    int cnt = 19;
    int value, i;

	while(1)
    {
        AD1CON1bits.ASAM = 1;
        while( IFS1bits.AD1IF == 0);
        value = ADC1BUF0;
        int freq = 1 + (value/255);
        int period = (1.0/freq) * 1000;

	if (i++ % (period/20) == 0){
            cnt--;
        }

        send2displays(toBcd(cnt));
       
        if(cnt < 0)
            cnt = 19;
        
        delay(20);
        IFS1bits.AD1IF = 0;
    }
	return 0;
}

void send2displays(unsigned char value)
{
	const char display7codes[] = {0x3F, //0
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
	unsigned char dh = value >> 4;
	unsigned char dl = value & 0x0F;

	if (displayFlag == 0)
	{
		LATDbits.LATD6 = 1;
		LATDbits.LATD5 = 0;
		LATB = (LATB & 0x80FF) | display7codes[dh] << 8;
	} else {
		LATDbits.LATD6 = 0;
		LATDbits.LATD5 = 1;
		LATB = (LATB & 0x80FF) | display7codes[dl] << 8;
	}

	displayFlag = !displayFlag;
}

void delay(int ms)
{
	for(; ms > 0; ms--)
	{
		resetCoreTimer();
		readCoreTimer();
		while(readCoreTimer() < 20000);
	}
}
