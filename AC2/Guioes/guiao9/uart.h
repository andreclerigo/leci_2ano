#ifndef DisableUart2RxInterrupt()
#define DisableUart2RxInterrupt() IEC1bits.U2RXIE = 0
#endif

#ifndef EnableUart2RxInterrupt()
#define EnableUart2RxInterrupt() IEC1bits.U2RXIE = 2
#endif

#ifndef Disablet2TxInterrupt()
#define DisableUart2TxInterrupt() IEC1bits.U2TXIE = 0
#endif

#ifndef EnableUart2TxInterrupt()
#define EnableUart2TxInterrupt() IEC1bits.U2TXIE = 1
#endif

void comDrv_flushRX(void);
void comDrv_flushTx(void);
void comDrv_putc(char ch);
void comDrv_puts(char *s);
