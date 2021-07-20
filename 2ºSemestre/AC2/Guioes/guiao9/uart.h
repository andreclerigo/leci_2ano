#define DisableUart2RxInterrupt() IEC1bits.U2RXIE = 0
#define EnableUart2RxInterrupt() IEC1bits.U2RXIE = 1
#define DisableUart2TxInterrupt() IEC1bits.U2TXIE = 0
#define EnableUart2TxInterrupt() IEC1bits.U2TXIE = 1
#define TRUE 1
#define FALSE 0

void comDrv_flushRx(void);
void comDrv_flushTx(void);
void comDrv_putc(char ch);
void comDrv_puts(char *s);
void comDrv_config(unsigned int baud, char party, unsigned int stopbits);
char comDrv_getc(char *pchar);
