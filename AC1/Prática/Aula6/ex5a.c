#include<stdio.h>

int main(int argc, char *argv[]) {

    for (int i = 0; i < argc; i++) {
        int j = 0;
        while (argv[i][j] != '\0') {
            j++;
        }
    }
    return 0;
}