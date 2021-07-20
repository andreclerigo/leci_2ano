//
// João Manuel Rodrigues, AlgC, May 2020
// Joaquim Madeira, AlgC, May 2020
//
// Binary Min Heap storing pointers to generic items.
//

#ifndef _MinHeap_
#define _MinHeap_

// The type for MinHeap structures
typedef struct _Heap MinHeap;

// The type for item comparator functions
typedef int (*compFunc)(const void* p1, const void* p2);

// The type for item printer functions
typedef void (*printFunc)(void* p);


// CREATE/DESTROY

MinHeap* MinHeapCreate(int capacity, compFunc compF, printFunc printF) ;

void MinHeapDestroy(MinHeap** pph) ;

// GETTERS

int MinHeapCapacity(MinHeap* ph) ;

int MinHeapSize(MinHeap* ph) ;

int MinHeapIsEmpty(MinHeap* ph) ;

int MinHeapIsFull(MinHeap* ph) ;

void* MinHeapGetMin(MinHeap* ph) ;

// MODIFY

void MinHeapInsert(MinHeap* ph, void* item) ;

void MinHeapRemoveMin(MinHeap* ph) ;

// CHECK/VIEW

int MinHeapCheck(MinHeap* ph) ;

void MinHeapView(MinHeap* ph) ;

#endif
