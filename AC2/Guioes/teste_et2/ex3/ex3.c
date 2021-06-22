#include <detpic32.h>

void configureUart(void);
void putc(char c);
void puts(char *str);

volatile static char val;

int main(void)
{	
	configureUart();
	IPC8bits.U2IP = 1;
	IFS1bits.U2RXIF = 0;
	IEC1bits.U2RXIE = 1;
	IFS1bits.U2TXIF = 0;
	IEC1bits.U2TXIE = 1;
	
	int DS4, DS3, DS2, DS1;
	TRISB = TRISB | 0x000F;		//RB[0..3] as inputs
	TRISEbits.TRISE4 = 0;		//RE4 as output;
	LATEbits.LATE4 = 1;
	
	EnableInterrupts();
	
	while(1)
	{
		DS4 = PORTB & 0x0008;
		DS3 = PORTB & 0x0004;
		DS2 = PORTB & 0x0002;
		DS1 = PORTB & 0x0001;
		
		if (val == 'T')
			LATEbits.LATE4 = !LATEbits.LATE4;
			
		if (val == 'P')
		{
			puts("DipSwitch=");
			putc(DS4);
			putc(DS3);
			putc(DS2);
			putc(DS1);
			putc('\n');
		}
	}
	return 0;
}

void putc(char c)
{
	while(U2STAbits.UTXBF == 1);
	U2TXREG = c;
}

void puts(char *str)
{
	while(*str != '\0')
	{
		putc(*str);
		str++;
	}
}

void getc(void)
{
	while(U2STAbits.URXDA == 0);
	val = U2RXREG;
}

void configureUart()
{
	U2BRG = ((PBCLK + 8 * 9600) / (16 * 9600)) - 1;
	U2MODEbits.BRGH = 0;
	U2MODEbits.STSEL = 1;
	U2MODEbits.PDSEL = 0b10;
	U2STAbits.UTXEN = 1;
	U2STAbits.URXEN = 1;
	U2MODEbits.ON = 1;
}

void _int_(32) isr_uart()
{
	if (IFS1bits.U2RXIF == 1)
		getc();
		
	IFS1bits.U2RXIF = 0;
}
