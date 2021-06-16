#define DisableUart2RxInterrupt() IEC1bits.U2RXIE = 0
#define EnableUart2RxInterrupt() IEC1bits.U2RXIE = 2
#define DisableUart2TxInterrupt() IEC1bits.U2TXIE = 0
#define EnableUart2TxInterrupt() IEC1bits.U2TXIE = 1

void comDrv_flushRx(void);
void comDrv_flushTx(void);
void comDrv_putc(char ch);
void comDrv_puts(char *s);
void comDrv_config(unsigned int baud, char party, unsigned int stopbits);
