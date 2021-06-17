#include "detpic32.h"

#define BUF_SIZE 8
#include "../../uart.h"
#include "../../buffer.h"

extern volatile circularBuffer txb;
extern volatile circularBuffer rxb;

void _int_(32) isr_uart2rx()
{
    if (IFS1bits.U2RXIF == 1)
    {
        rxb.data[rxb.tail] = U2RXREG;   // Read character from UART and
                                        // write it to the tail position
                                        // of the reception buffer

        rxb.tail = (rxb.tail + 1) & INDEX_MASK;     // Increment tail variable (mod BUF_SIZE)
        
        if (rxb.count < BUF_SIZE)
            rxb.count++;
        else
            rxb.head = rxb.head + 1;
        IFS1bits.U2RXIF = 0;
    }
}