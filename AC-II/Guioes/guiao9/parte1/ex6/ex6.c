#define BUF_SIZE 8

#include "../../uart.h"
#include "../../buffer.h"
#include "detpic32.h"

extern volatile circularBuffer txb;

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
        if (txb.count == 0) DisableUart2RxInterrupt();
        IFS1bits.U2TXIF = 0;
    }
}