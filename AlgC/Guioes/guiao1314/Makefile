# To compile all programs, run:
#   make
#
# João Manuel Rodrigues, June 2020

#CC = gcc
#CXX = $(CC)

# Options for the C compiler. (-x c forces C language even for .ccp files)
CFLAGS += -x c
CFLAGS += -g -Wall
CPPFLAGS = $(CFLAGS)

TARGETS = example1 example2 example3

all: $(TARGETS)

example1: example1.o Graph.o SortedList.o

example2: example2.o Graph.o GraphBFSWithQueue.o IntegersStack.o \
 IntegersQueue.o GraphDFSRec.o GraphDFSWithStack.o SortedList.o

example3: example3.o Graph.o GraphTopologicalSorting.o \
 IntegersQueue.o SortedList.o

# Dependencies of source files (obtained with gcc -MM)

example1.o: example1.c Graph.h

example2.o: example2.c Graph.h GraphBFSWithQueue.h IntegersStack.h \
 GraphDFSRec.h GraphDFSWithStack.h

example3.o: example3.c Graph.h GraphTopologicalSorting.h IntegersQueue.h

Graph.o: Graph.c Graph.h SortedList.h

GraphBFSWithQueue.o: GraphBFSWithQueue.c GraphBFSWithQueue.h Graph.h \
 IntegersStack.h IntegersQueue.h

GraphDFSRec.o: GraphDFSRec.c GraphDFSRec.h Graph.h IntegersStack.h

GraphDFSWithStack.o: GraphDFSWithStack.c GraphDFSWithStack.h Graph.h \
 IntegersStack.h

GraphTopologicalSorting.o: GraphTopologicalSorting.c GraphTopologicalSorting.h \
 Graph.h IntegersQueue.h

IntegersQueue.o: IntegersQueue.c IntegersQueue.h

IntegersStack.o: IntegersStack.c IntegersStack.h

SortedList.o: SortedList.c SortedList.h

clean:
	rm -f *.o
	rm -f $(TARGETS)


