#ifndef BUF_SIZE
#define BUF_SIZE 32
#endif

#ifndef INDEX_MASK
#define INDEX_MASK (BUF_SIZE - 1)
#endif

typedef struct 
{
    unsigned char data[BUF_SIZE];
    unsigned int head;
    unsigned int tail;
    unsigned int count;
} circularBuffer;

volatile circularBuffer txb;
volatile circularBuffer rxb;
