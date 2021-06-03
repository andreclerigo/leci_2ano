#include <detpic32.h>

void putc(char byte2send);
void puts(char *str);
void configUart(unsigned int baud, char party, unsigned int stopbits);

int main(void)
{
    configUart(115200, 'N', 1);   
    int time;

    while (1)
    {
        resetCoreTimer();
        puts("123456789\n");          // 1578300 ns
        //puts("123456789A\n");         // 1666550 ns
        //puts("123456789AB\n");        // 1754650 ns
        while (U2STAbits.TRMT != 1);    // Wait while FIFO and Tx shift register are not empty
        time = 50 * readCoreTimer();
        printInt10(time);
        putChar('\n');
    }
    
    return 0;
}

void puts(char *str)
{
    while (*str != '\0')
    {
        putc(*str);
        str++;
    }
}

void putc(char byte2send)
{
    while (U2STAbits.UTXBF == 1);
    U2TXREG = byte2send;
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
    U2MODEbits.ON = 1;                  // Enable UART2
}