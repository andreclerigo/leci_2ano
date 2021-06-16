#ifndef DisableUart1RxInterrupt()
#define DisableUart1RxInterrupt() IEC0bits.U1RXIE = 0
#endif

#ifndef EnableUart1RxInterrupt()
#define EnableUart1RxInterrupt() IEC0bits.U1RXIE = 1
#endif

#ifndef Disablet1TxInterrupt()
#define DisableUart1TxInterrupt() IEC0bits.U1TXIE = 0
#endif

#ifndef EnableUart1TxInterrupt()
#define EnableUart1TxInterrupt() IEC0bits.U1TXIE = 1
#endif

void comDrv_flushRX(void);
void comDrv_flushTx(void);
