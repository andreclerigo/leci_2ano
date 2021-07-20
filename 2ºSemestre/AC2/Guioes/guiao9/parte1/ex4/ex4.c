#define BUF_SIZE 8

#include "../../uart.h"
#include "../../buffer.h"
#include "detpic32.h"

extern volatile circularBuffer rxb;
extern volatile circularBuffer txb;

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