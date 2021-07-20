#include <detpic32.h>

int main (void)
{
    TRISB = TRISB & 0x80FF;  //Bit 15 - 8
    TRISD = TRISD & 0xFF9F;
    LATDbits.LATD5 = 1; //Display L on
    LATDbits.LATD6 = 0; //Display H off
    LATB = LATB & 0x80FF;

    while (1)
    {
        char in = getChar();
        // char is between (A and G) or (a and g)

        /**
        switch (in)
        {
            case 0x41:
            case 0x61:
                LATB = (LATB & 0x80FF) | 0x0100;
                break;
            
            case 0x42:
            case 0x62:
                LATB = (LATB & 0x80FF) | 0x0200;
                break;
            
            case 0x43:
            case 0x63:
                LATB = (LATB & 0x80FF) | 0x0400;
                break;

            case 0x44:
            case 0x64:
                LATB = (LATB & 0x80FF) | 0x0800;
                break;

            case 0x45:
            case 0x65:
                LATB = (LATB & 0x80FF) | 0x1000;
                break;

            case 0x46:
            case 0x66:
                LATB = (LATB & 0x80FF) | 0x2000;
                break;
            
            case 0x47:
            case 0x67:
                LATB = (LATB & 0x80FF) | 0x4000;
                break;
            
            default:
                LATB = LATB & 0x80FF;
                break;
        }
        **/

       if (in >= 'a' && in <= 'g') in -= 0x20;  // Convert to uppercase
       if (in >= 'A' && in <= 'G')
       {
           in -= 'A';                           // Get the index of the leter A->0, G->6
           int val = (0x100 << in);
           LATB = (LATB & 0x00FF) | val;

       } else {
           LATB = (LATB & 0x00FF);              // Clear display
       }
    }
    
    return 0;
}