#!/bin/sh
if [ $# -lt 2 ]; then
	antlr4-test Geometrics program -gui < $1
fi

if [ $# -lt 3 ]; then
	antlr4-test Geometrics$1 program -gui < $2
fi
