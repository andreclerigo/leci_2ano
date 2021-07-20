#include <detpic32.h>

void delay(int ms);
void send2displays(unsigned char value);

int main(void)
{
	TRISB = TRISB & 0x80FF;
    TRISD = TRISD & 0xFF9F;
    int i;
	char c;

	while(1)
    {
		i = 0;
		c = getChar();

  		if (c >= '0' && c <= '3') {
		  	send2displays((c & 0x0f));
		}else {
			while( i++ < 100)
			{
				send2displays(0xFF);
				delay(10);
			}
			LATB = LATB & 0x80FF;
		}

		delay(10);
		
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
