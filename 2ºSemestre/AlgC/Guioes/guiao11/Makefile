# To compile all programs, run:
#   make
#
# AlgC ua.pt 2021

# Options for the C compiler.
CFLAGS += -g -Wall

TARGETS = BSTreeTest Tests

all: $(TARGETS)

clean:
	rm -f *.o
	rm -f $(TARGETS)

# Object file dependencies (obtained with `gcc -MM *.c`):

BSTree.o: BSTree.c BSTree.h PointersQueue.h
BSTreeTest.o: BSTreeTest.c BSTree.h PointersQueue.h
Date.o: Date.c Date.h
Person.o: Person.c Person.h Date.h
PersonSet.o: PersonSet.c PersonSet.h Person.h Date.h BSTree.h PointersQueue.h
PointersQueue.o: PointersQueue.c PointersQueue.h
Tests.o: Tests.c Person.h Date.h PersonSet.h

# Executable file dependencies:

BSTreeTest: BSTreeTest.o BSTree.o PointersQueue.o

Tests: Tests.o PersonSet.o BSTree.o PointersQueue.o Person.o Date.o

# make tst    # to run program twice and log outputs

tst: tst-12.txt tst-14.txt

tst-%.txt: Tests
	valgrind --log-fd=1 ./Tests $* > $@

