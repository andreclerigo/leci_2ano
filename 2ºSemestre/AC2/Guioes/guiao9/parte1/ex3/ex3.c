#define BUF_SIZE 8

#include "../../uart.h"
#include "../../buffer.h"
#include "detpic32.h"

extern volatile circularBuffer rxb;
extern volatile circularBuffer txb;

void comDrv_flushRx(void)
{
    rxb.head = 0;
    rxb.tail = 0;
    rxb.count = 0;
    DisableUart2RxInterrupt();
}

void comDrv_flushTx(void)
{
    txb.head = 0;
    txb.tail = 0;
    txb.count = 0;
    DisableUart2TxInterrupt();
}