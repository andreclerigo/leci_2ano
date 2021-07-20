//
// Joaquim Madeira, AlgC, April 2021
//
// Header file for the generic sorting module
//

#ifndef _SORTING_
#define _SORTING_

#include <stddef.h>

// The type for the comparator less function: *p1 < *p2
typedef int (*lessFunc)(void* p1, void* p2);

// The type for the swap function
typedef void (*swapFunc)(void* p1, void* p2);

// The type for the print function
typedef void (*printFunc)(void* p);

// Sorting algorithms

// Bubble Sort
//  a : pointer to the array
//  numElems : number of elements to sort
//  elemSize : number of bytes for each array element
//  less : pointer to the element comparator function
//  swap : pointer to the element swap function
void bubbleSort(void* a, size_t numElems, size_t elemSize, lessFunc less,
                swapFunc swap);

// Auxiliary functions

// isSorted
//  a : pointer to the array
//  numElems : number of elements
//  elemSize : number of bytes for each array element
//  less : pointer to the element comparator function
int isSorted(void* a, size_t numElems, size_t elemSize, lessFunc less);

// printArray
//  a : pointer to the array
//  numElems : number of elements
//  elemSize : number of bytes for each array element
//  print : pointer to the element print function
void printArray(void* a, size_t numElems, size_t elemSize, printFunc print);

#endif  // _SORTING_