#include "detpic32.h"

#define BUF_SIZE 8
#include "../../uart.h"
#include "../../buffer.h"

extern volatile circularBuffer txb;
extern volatile circularBuffer rxb;

char comDrv_getc(char *pchar)
{
    if (rxb.count == 0) return FALSE; 
    
    DisableUart2RxInterrupt();      // Begin of critical section
    pchar = rxb.data[rxb.head];
    rxb.count--;
    rxb.head = (rxb.head + 1) & INDEX_MASK;             // Increment head variable (mod BUF_SIZE)
    EnableUart2RxInterrupt();                           // End of critical section
    return TRUE;
}