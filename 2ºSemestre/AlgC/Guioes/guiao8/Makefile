# To compile all programs, run:
#   make
#
# Note that source files have .cpp extensions,
# for compatibility with codecheck, but they are actually pure C.
# 
# JMR 2021

#CC = gcc
#CXX = $(CC)

# Options for the C compiler. (-x c forces C language even for .cpp files)
CFLAGS += -x c -g -Wall
CPPFLAGS = $(CFLAGS)

TARGETS = Tests

all: $(TARGETS)

Date.o: Date.cpp Date.h

Person.o: Person.cpp Person.h Date.h

Tests.o: Tests.cpp Date.h Person.h

Tests: Tests.o Date.o Person.o

clean:
	rm -f *.o
	rm -f $(TARGETS)


