#define BUF_SIZE 8

#include "detpic32.h"
#include "../../buffer.h"

int main(void)
{
    extern volatile circularBuffer rxb;
    extern volatile circularBuffer txb;
    printInt10(BUF_SIZE);
    putChar('\n');
    printInt10(INDEX_MASK);
    return 0;
}
