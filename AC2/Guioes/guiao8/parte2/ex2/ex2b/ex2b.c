#include <detpic32.h>

void configureAll();
int voltageConversion(int value);
unsigned char toBcd(unsigned char value);
void configUart(unsigned int baud, char parity, unsigned int stopbits);
void putc(char byte2send);
void send2displays(char value);

volatile int value2display;
volatile int voltMin = 33;
volatile int voltMax = 0;

int main(void)
{
    configureAll();

    IFS0bits.T3IF = 0;          // Reset timer T3 interrupt flag
    IFS0bits.T1IF = 0;          // Reset timer T1 interrupt flag
    IFS1bits.AD1IF = 0;         // Reset A/D interrupt flag
    IEC0bits.T1IE = 1;

    EnableInterrupts();         // Global Interrupt Enable
    while(1);

    return 0;
}

void configureAll()
{
    // Timer3
    T3CONbits.TCKPS = 2;        // 1:4 prescaler Fout_presc = 5Mhz;
    PR3 = 49999;                // Fout = 20Mhz / 4(49999+1) = 100Hz
    TMR3 = 0;                   // Reset timer T3 count register
    T3CONbits.TON = 1;          // Enable timer T3
    // Setup PWM
    OC1CONbits.OCM = 6;         // PWM mode on OCx; fault pin disabled
    OC1CONbits.OCTSEL =1;       // Use timer T3 as the time base for PWM generation
    OC1RS = 0;                  // Ton constant
    OC1CONbits.ON = 1;          // Enable OC1 module

    // Timer1
    T1CONbits.TCKPS = 3;        // 1:256 prescaler Fout_presc = 78125;
    PR1 = 39062;                // Fout = 20Mhz / 256(19530 + 1) = 4,00005Hz
    TMR1 = 0;                   // Reset timer T1 count register
    T1CONbits.TON = 1;          // Enable timer T1 

    // Displays
    TRISB = TRISB & 0x80FF;     // RB14 to RB8 as output
    TRISD = TRISD & 0xFF9F;     // Displays high/low as output

    // ADC
    TRISBbits.TRISB4 = 1;       // RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      // RB4 configured as analog input (AN4)
    AD1CON1bits.SSRC = 7;       // Conversion trigger constant
    AD1CON1bits.CLRASAM = 1;    // Stop conversion when the 1st A/D converter intetupr is generated. At the same time, hardware clears ASAM bit
    AD1CON3bits.SAMC = 16;      // Sample time is 16 TAD (TAD = 100ns)
    AD1CON2bits.SMPI = 7;       // Interrupt is generated after 8 samples
    AD1CHSbits.CH0SA = 4;       // analog channel input 4
    AD1CON1bits.ON = 1;         // Enable the A/d configuration sequence

    // Enable interrupts ADC, T1, T3
    IPC6bits.AD1IP = 2;         // configure priority of A/D interrupts
    IEC1bits.AD1IE = 1;         // Enable A/D interrupts
    IPC1bits.T1IP = 1;          // Interrupt priority 1
    IEC0bits.T1IE = 1;          // Enable timer T1 interrupts
    IPC3bits.T3IP = 3;          // Interrupt priority 2
    IEC0bits.T3IE = 3;          // Enable timer T3 interrupts

    configUart(115200, 'N', 1);
}

void configUart(unsigned int baud, char parity, unsigned int stopbits)
{
    // Configure UART2
    if (baud >= 600 && baud <= 115200)
        U2BRG = ((PBCLK + 8 * baud) / (16 * baud)) - 1;    // Aproximate to closest baudrate
    else
        U2BRG = 10;                     // DEFAULT 115200 baudrate
    
    if (parity == 'N')
        U2MODEbits.PDSEL = 0b00;        // 00 = 8-bit data, no parity
    else if (parity == 'E')
        U2MODEbits.PDSEL = 0b01;        // 01 = 8-bit data, even parity
    else if (parity == 'O')
        U2MODEbits.PDSEL = 0b10;        // 10 = 8-bit data, odd parity
    else
        U2MODEbits.PDSEL = 0b00;        // DEFAULT NO PARITY 8 BITS

    if (stopbits == 1 || stopbits == 2)  
        U2MODEbits.STSEL = stopbits - 1;// Number of stopbits
    else
        U2MODEbits.STSEL = 0;           // DEFAULT 1 STOPBIT

    U2MODEbits.BRGH = 0;                // Divide by 16
    U2STAbits.URXEN = 1;                // Enable Receiver
    U2STAbits.UTXEN = 1;                // Enable Transmitter

    U2STAbits.URXISEL = 0b00;           // Select interrupt only for receiver
    IPC8bits.U2IP = 1;                  // UART2 Priority
    IEC1bits.U2RXIE = 1;                // U2RX Interrupt Enable
    IFS1bits.U2RXIF = 0;                // U2RX Interrupt Flag

    U2MODEbits.ON = 1;                  // Enable UART2
}

void putc(char byte2send)
{
    while (U2STAbits.UTXBF == 1);
    U2TXREG = byte2send;
}

void _int_(4) isr_T1(void)
{
    AD1CON1bits.ASAM = 1;           // Start conversion
    IFS0bits.T1IF = 0;
}

void _int_(12) isr_T3(void)
{
    static int count;
    unsigned char val;

    send2displays(toBcd(value2display));
    if (++count == 100) {
        count = 0;
        val = toBcd(value2display);
        putc((val >> 4) + '0');
        putc((val & 0x0F) + '0');
        putc('\n');
    }
    
    IFS0bits.T3IF = 0;
}

void _int_(27) isr_adc(void)
{
    int sum = 0, i = 0, voltage = 0;
    int *p = (int *)&ADC1BUF0;
    for (i = 0; i < 8; i++)
        sum += p[i * 4];

    voltage = sum / 8;
    value2display = voltageConversion(voltage);

    if (value2display > voltMax)
        voltMax = value2display;

    if (value2display < voltMin)
        voltMin = value2display;

    IFS1bits.AD1IF = 0;             // Reset AD1IF flag
}

void _int_(32) isr_uart2(void)
{
    unsigned char val;

    if (U2RXREG == 'L')
    {
        val = toBcd(voltMin);
        putc((val >> 4) + '0');
        putc((val & 0x0F) + '0');
        putc('\n');
        val = toBcd(voltMax);
        putc((val >> 4) + '0');
        putc((val & 0x0F) + '0');
        putc('\n');
    }
    IFS1bits.U2RXIF = 0;
}

void send2displays(char value)
{
    static const char display7Scodes[] = {
                                        0x3F, //0
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

    unsigned char dh = value >> 4;      // Get the index of the decimal part
    unsigned char dl = value & 0x0F;    // Get the index of the unitary part

    dh = display7Scodes[dh];
    dl = display7Scodes[dl];

    if (displayFlag == 0)
    {
        LATD = (LATD | 0x0040) & 0xFFDF;    // Dipslay High active and Display Low OFF
        LATB = (LATB & 0x80FF) | ((unsigned int)(dh)) << 8; // Clean the display and set the right value
    } else {
        LATD = (LATD | 0x0020) & 0xFFBF;    // Display High OFF and Display High active
        LATB = (LATB & 0x80FF) | ((unsigned int)(dl)) << 8; // Clean the display and set the right value
    }

    displayFlag = !displayFlag;
}

unsigned char toBcd(unsigned char value)
{
    return ((value / 10) << 4) + (value % 10);
}

int voltageConversion(int value)
{
    return (value * 33 + 511) / 1024;
}
