#include<detpic32.h>

void send2displays(char value);
char toBCD(char value);
int voltageConversion(int voltage);
void delay(int ms);

volatile static int voltage;

int main(void)
{
	//Timer2 -> Display
	//Kprescaler = ceil(20Mhz/65536*120) = 4
	//PR2 = (20Mhz/4/120)-1 = 41665,...
	
	//Ponto1(0, 20) Ponto2(33; 65)
	//y = 1,36x + 20
	
	// Timer2
	T2CONbits.TCKPS = 2;
	PR2 = 41666;
	TMR2 = 0;
	T2CONbits.TON = 1;
	IPC2bits.T2IP = 2;
	IEC0bits.T2IE = 1;
	
	// Displays
	TRISDbits.TRISD6 = 0;
	TRISDbits.TRISD5 = 0;
	TRISB = TRISB & 0x80FF;
	LATB = LATB & 0x80FF;
	
	// ADC
    TRISBbits.TRISB4 = 1;       // RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      // RB4 configured as analog input (AN4)
    AD1CON1bits.SSRC = 7;       // Conversion trigger constant
    AD1CON1bits.CLRASAM = 1;    
    AD1CON3bits.SAMC = 16;      // Sample time is 16 TAD (TAD = 100ns)
    AD1CON2bits.SMPI = 1;       // Interrupt is generated after 2 samples
    AD1CHSbits.CH0SA = 4;       // analog channel input 4
    AD1CON1bits.ON = 1;         // Enable the A/d configuration sequence
	
	IFS0bits.T2IF = 0;
	//IFS0bits.T3IF = 0;
	
	EnableInterrupts();
	
	while(1)
	{
		delay(100);
		AD1CON1bits.ASAM = 1;
		while (IFS1bits.AD1IF == 0);
		int soma = 0;
		int* val = (int*) (&ADC1BUF0);
		int i;
		for (i = 0; i < 2; i++) 
			soma += voltageConversion(val[i*4]);
			
		voltage = soma / 2;
		IFS1bits.AD1IF = 0;
		IFS0bits.T3IF = 0;
	}
	
	return 0;
}

void _int_(8) isr_t2(void)
{
	send2displays(toBCD(voltage));
	IFS0bits.T2IF = 0;
}

void send2displays(char value)
{
	int display7codes[] = { 0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71 };
	static int displayFlag = 0;
	unsigned char dh = value >> 4;
	unsigned char dl = value & 0x0F;
	
	dh = display7codes[dh];
	dl = display7codes[dl];
	
	if (displayFlag == 0)
	{
		LATDbits.LATD6 = 1;
		LATDbits.LATD5 = 0;
		LATB = (LATB & 0x80FF) | dh << 8;
	} else {
		LATDbits.LATD6 = 0;
		LATDbits.LATD5 = 1;
		LATB = (LATB & 0x80FF) | dl << 8;
	}
	
	displayFlag = !displayFlag;
}

char toBCD(char value)
{
	return ((value/10) << 4) + (value % 10);
}

int voltageConversion(int voltage)
{
	int temp = ((voltage * 33 + 511) / 1024);
	int aux = 1.36*temp + 0.5;
	return aux + 20;
}

void delay(int ms)
{
	for(; ms > 0; ms--)
	{
		resetCoreTimer();
		while(readCoreTimer() < 20000);
	}
}
