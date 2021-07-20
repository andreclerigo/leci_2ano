# To compile all programs, run:
#   make
#
# AlgC ua.pt 2021

# Options for the C compiler.
CFLAGS += -g -Wall

TARGETS = SortedListTest1 SortedListTest2 Tests

all: $(TARGETS)

clean:
	rm -f *.o
	rm -f $(TARGETS)

# Object file dependencies (obtained with `gcc -MM *.c`):

Date.o: Date.c Date.h
Person.o: Person.c Person.h Date.h
PersonSet.o: PersonSet.c PersonSet.h Person.h Date.h SortedList.h
SortedList.o: SortedList.c SortedList.h
SortedListTest1.o: SortedListTest1.c SortedList.h
SortedListTest2.o: SortedListTest2.c Date.h SortedList.h
Tests.o: Tests.c Person.h Date.h PersonSet.h

# Executable file dependencies:

SortedListTest1: SortedListTest1.o SortedList.o

SortedListTest2: SortedListTest2.o SortedList.o Date.o

Tests: Tests.o PersonSet.o SortedList.o Person.o Date.o

# make tst    # to run program twice and log outputs

tst: tst-12.txt tst-14.txt

tst-%.txt: Tests
	valgrind --log-fd=1 ./Tests $* > $@

