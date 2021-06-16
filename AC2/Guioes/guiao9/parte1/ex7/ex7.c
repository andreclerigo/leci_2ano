#include "detpic32.h"

#define BUF_SIZE 8
#include "../../uart.h"
#include "../../buffer.h"

extern volatile circularBuffer txb;
extern volatile circularBuffer rxb;

int main(void)
{
    comDrv_config(115200, 'N', 1);  // default pterm parameters
                                    // with TX and RX interrupts disabled
    comDrv_flushRx();
    comDrv_flushTx();
    EnableInterrupts();

    while (1) {
        comDrv_puts("Teste do bloco de transmissao do device driver!...");
        comDrv_putc('\n');
    }
    return 0;
}

void comDrv_config(unsigned int baud, char parity, unsigned int stopbits)
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
    DisableUart2RxInterrupt();
    DisableUart2TxInterrupt();
    IPC8bits.U2IP = 2;                  // Configure Interrupt Priority
}

void comDrv_putc(char ch)
{
    while (txb.count == BUF_SIZE);          // Wait while buffes is full
    txb.data[txb.tail] = ch;                // Copy character to TX buffer at 
                                            // last position avaible (tail)
    txb.tail = (txb.tail + 1) & INDEX_MASK; // Increment tail index
    DisableUart2TxInterrupt();              // Begin of critical section
    txb.count++;                            // Increment count variable
    EnableUart2TxInterrupt();               // End of critical section
}

void comDrv_puts(char *s)
{
    while (*s != '\0')
    {
        comDrv_putc(*s);
        s++;
    }
}

void comDrv_flushRx()
{
    rxb.count = 0;
    rxb.head = 0;
    rxb.tail = 0;
    DisableUart2RxInterrupt();
}

void comDrv_flushTx()
{
    txb.count = 0;
    txb.head = 0;
    txb.tail = 0;
    DisableUart2TxInterrupt();
}

void _int_(32) isr_uart2tx()
{
    if (IFS1bits.U2TXIF == 1)
    {
        if(txb.count > 0)
        {
            U2TXREG = txb.data[txb.head];
            txb.head = (txb.head + 1) & INDEX_MASK;
            txb.count--;
        }
        if (txb.count == 0) DisableUart2TxInterrupt();
        IFS1bits.U2TXIF = 0;
    }
}
