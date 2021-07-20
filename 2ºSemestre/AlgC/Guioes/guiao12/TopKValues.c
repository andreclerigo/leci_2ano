//
// Joaquim Madeira, AlgC, June 2021
// João Manuel Rodrigues, AlgC, June 2021
//
// TESTING the TAD MinHeap implementation
//

// This program lists the largest K values from a file of random integers.

//// PROCURE ... E COMPLETE ////

// Try the arguments below.

//ARGS 10 ordenados02500.txt
//ARGS 10 ordInversa02500.txt
//ARGS 10 aleatorios02500.txt
//ARGS 100 aleatorios40000.txt

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "MinHeap.h"

// THE ALGORITHM:
//
// Read the first K values into a MIN-heap.
//
// Then: Only insert to Min-Heap if the element is bigger then the Minimum value from the Heap
//
// 1. Get the next value from the file -> current.
// 2. If current is smaller or equal than the MIN element from the heap,
//    then discard it.
// 3. Otherwise, remove the MIN from the heap and insert the current value.
//
// The MIN-heap stores the K largest values read from file.
//
// List the K largest values by successively removing the MIN from the heap.
//

// STORING POINTERS TO INTEGERS

// The comparator for integer items

int comparator(const void* p1, const void* p2) {
  int d = *(int*)p1 - *(int*)p2;
  return (d > 0) - (d < 0);
}

// The printer for integer items

void printer(void* p) { printf("%d ", *(int*)p); }

// MAIN

int main(int argc, char* argv[]) {
  if (argc < 3) {
    fprintf(stderr, "Usage: %s K FILE\n", argv[0]);
    exit(1);
  }

  // k -> number of largest values we are looking for
  int k = atoi(argv[1]);

  FILE* f = fopen(argv[2], "r");
  if (f == NULL) {
    perror(argv[2]);
    exit(2);
  }
  
  // Create heap
  MinHeap* h = MinHeapCreate(k, comparator, printer);
  if (h == NULL) abort();

  // Read the first K values into a MIN-heap
  //    Allocate memory space for an integer
  //    Read it from file
  //    Insert it in the heap

  for(int i = 0; i < k; i++) 
  { 
    int *item = (int*)malloc(sizeof(int));
    fscanf(f, "%d", item);
    MinHeapInsert(h, item);
  }

  // Read and process each one of the remaining values
  while (!feof(f)) {
    int *item = (int*)malloc(sizeof(int));
    fscanf(f, "%d", item);

    int *min = (int*)MinHeapGetMin(h);

    if (*min < *item) {
      MinHeapRemoveMin(h);
      MinHeapInsert(h, item);
      free(min);
    } else 
      free(item);
  }

  // The heap stores the largest k values
  // List them by removing each one from the heap

  while(!MinHeapIsEmpty(h))
  {
    
    int *min = MinHeapGetMin(h);
    printf("%d\n", *min);
    MinHeapRemoveMin(h);
    free(min);
  }

  // House-keeping
  MinHeapDestroy(&h);
  fclose(f);
}
