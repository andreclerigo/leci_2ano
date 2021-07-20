//
// Joaquim Madeira, AlgC, April 2021
//
// Testing the generic sorting module
//
// Arrays store integer values
//

#include <assert.h>
#include <stdio.h>

#include "Sorting.h"

int lessForInts(void* p1, void* p2) {
  assert(p1 != NULL && p2 != NULL);
  int a = *(int*)p1;
  int b = *(int*)p2;
  return a < b;
}

void printForInts(void* p) {
  assert(p != NULL);
  printf("%d", *(int*)p);  // Casting to the appropriate pointer type
}

void swapForInts(void* p1, void* p2) {
  assert(p1 != NULL && p2 != NULL);
  int temp = *(int*)p1;
  *(int*)p1 = *(int*)p2;
  *(int*)p2 = temp;
}

int main(void) {
  int a[15] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

  int b[15] = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

  int c[15] = {10, 9, 13, 1, 3, 2, 8, 7, 5, 6, 4, 11, 15, 12, 14};

  printArray(a, 15, sizeof(int), printForInts);
  bubbleSort(a, 15, sizeof(int), lessForInts, swapForInts);
  printArray(a, 15, sizeof(int), printForInts);
  assert(isSorted(a, 15, sizeof(int), lessForInts));

  printArray(b, 15, sizeof(int), printForInts);
  bubbleSort(b, 15, sizeof(int), lessForInts, swapForInts);
  printArray(b, 15, sizeof(int), printForInts);
  assert(isSorted(b, 15, sizeof(int), lessForInts));

  printArray(c, 15, sizeof(int), printForInts);
  bubbleSort(c, 15, sizeof(int), lessForInts, swapForInts);
  printArray(c, 15, sizeof(int), printForInts);
  assert(isSorted(c, 15, sizeof(int), lessForInts));

  return 0;
}