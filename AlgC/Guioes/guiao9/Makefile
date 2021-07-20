# To compile all programs, run:
#   make
#
# JMR 2021

# Options for the C compiler.
CFLAGS += -g -Wall

TARGETS = Tests

all: $(TARGETS)

Date.o: Date.c Date.h

Person.o: Person.c Person.h Date.h

Tests.o: Tests.c Person.h Date.h PersonSet.h

Tests: Tests.o Person.o Date.o PersonSet.o

# make tst    # to run program twice and log outputs
tst: tst-12.txt tst-14.txt

tst-%.txt: Tests
	valgrind --log-fd=1 ./Tests $* > $@

clean:
	rm -f *.o
	rm -f $(TARGETS)
	rm -f tst-*.txt


