//
// Joaquim Madeira, AlgC, April 2021
//
// The generic sorting module
//

#include "Sorting.h"

#include <assert.h>
#include <stdio.h>

// Sorting algorithms

void bubbleSort(void *a, size_t numElems, size_t elemSize, lessFunc less,
                swapFunc swap) {
  assert(a != NULL && numElems > 0 && elemSize > 0 && less != NULL &&
         swap != NULL);

  void *previous;
  void *next;

  size_t k = numElems;
  int stop = 0;

  while (stop == 0) {
    stop = 1;
    k--;
    // Pointer arithmetic is not allowed on void pointers
    // The first element
    previous = a;
    // The second element
    next = (char *)a + elemSize;
    for (size_t i = 0; i < k; i++) {
      if (less(next, previous)) {
        swap(previous, next);
        stop = 0;
      }
      previous = next;
      next = (char *)next + elemSize;
    }
  }
}

// Auxiliary functions

int isSorted(void *a, size_t numElems, size_t elemSize, lessFunc less) {
  assert(a != NULL && numElems > 0 && elemSize > 0 && less != NULL);

  // Pointer arithmetic is not allowed on void pointers
  // The first element
  void *previous = a;
  // The second element
  void *next = (char *)a + elemSize;

  for (size_t i = 1; i < numElems; i++) {
    if (less(next, previous)) {
      return 0;
    }
    previous = next;
    next = (char *)next + elemSize;
  }
  return 1;
}

void printArray(void *a, size_t numElems, size_t elemSize, printFunc print) {
  assert(a != NULL && numElems > 0 && elemSize > 0 && print != NULL);
  printf("[ ");
  // The first element
  void *p = a;
  print(p);
  // The remaining elements
  for (size_t i = 1; i < numElems; i++) {
    printf(", ");
    p = (char *)p + elemSize;
    print(p);
  }
  printf(" ]\n");
}