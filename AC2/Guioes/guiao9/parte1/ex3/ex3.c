#define BUF_SIZE 8

#include "../../uart.h"
#include "../../buffer.h"
#include "detpic32.h"

extern volatile circularBuffer rx;
extern volatile circularBuffer tx;

void comDrv_flushRx(void)
{
    rx.head = 0;
    rx.tail = 0;
    rx.count = 0;
    DisableUart1RxInterrupt();
}

void comDrv_flushTx(void)
{
    tx.head = 0;
    tx.tail = 0;
    tx.count = 0;
    DisableUart1TxInterrupt();
}