//
// Joaquim Madeira, AlgC, April 2020
// João Manuel Rodrigues, AlgC, May 2020
//
// TESTING the TAD LIST implementation
//

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "SortedList.h"

// Storing pointers to integers

static int NCMP = 0;  // To count comparisons!

// The comparator
int comparator(const void* p1, const void* p2) {
  NCMP++;  // count comparisons
  int d = *(int*)p1 - *(int*)p2;
  return (d > 0) - (d < 0);
}

// Print a list of ints and test invariants.
void printList(List* list) {
  int cpos = ListGetCurrentPos(list);  // save current position
  int size = ListGetSize(list);
  for (int i = 0; i < size; i++) {
    ListMove(list, i);
    int* p = (int*)ListGetCurrentItem(list);
    printf("%d ", *p);
    ListTestInvariants(list);
  }
  printf("\n");
  ListMove(list, cpos);  // restore current position
}

int main(void) {
  List* list = ListCreate(comparator);

  printf("INSERTING\n");
  int r;
  int* aux;
  for (int i = 1; i <= 11; i += 2) {
    aux = (int*)malloc(sizeof(int));
    *aux = i;
    r = ListInsert(list, aux);
    assert(r == 0);  // success
    ListTestInvariants(list);
  }

  r = ListInsert(list, aux);  // Inserting equal element should fail
  assert(r == -1);            // failure

  for (int i = 0; i <= 12; i += 2) {
    aux = (int*)malloc(sizeof(int));
    *aux = i;
    r = ListInsert(list, aux);
    assert(r == 0);  // success
    ListTestInvariants(list);
  }

  printf("%d elements\n", ListGetSize(list));
  printList(list);

  printf("SEARCHING\n");

  for (int i = -6; i <= 18; i += 6) {
    ListMove(list, 5);
    NCMP = 0;
    int ret = ListSearch(list, &i);
    int pos = ListGetCurrentPos(list);
    printf("Searching for %2d: ret=%2d  currentPos=%2d NCMP=%2d\n", i, ret, pos,
           NCMP);
  }

  printf("REMOVING\n");

  ListMoveToHead(list);
  while (ListCurrentIsInside(list)) {
    int* aux = (int*)ListRemoveCurrent(list);
    printf("RemoveCurrent -> %d\n", *aux);
    free(aux);
    printList(list);
    ListMoveToNext(list);  // skip one
  }

  // Cleanup (Try commenting out and run with valgrind)
  while (!ListIsEmpty(list)) {
    int* aux = (int*)ListRemoveHead(list);
    printf("RemoveHead -> %d\n", *aux);
    free(aux);
    printList(list);
  }
  ListDestroy(&list);

  return 0;
}
