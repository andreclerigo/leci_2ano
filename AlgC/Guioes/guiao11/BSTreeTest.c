//
// Joaquim Madeira, AlgC, May 2021
// João Manuel Rodrigues, AlgC, May 2021
//
// TESTING the TAD BST implementation
//

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "BSTree.h"

// Storing pointers to integers

// The comparator for integer items
int comparator(const void* p1, const void* p2) {
  int d = *(int*)p1 - *(int*)p2;
  return (d > 0) - (d < 0);
}

// The printer for integer items
void printer(void* p) { printf("%d ", *(int*)p); }

int main(void) {
  BSTree* t1 = BSTreeCreate(comparator, printer);

  printf("CREATED AN EMPTY TREE\n");

  printf("%d elements\n", BSTreeGetNumberOfNodes(t1));
  printf("height = %d\n", BSTreeGetHeight(t1));

  printf("\nINSERTING\n");
  // Numbers to insert:
  int nums[] = {8, 4, 9, (4), 3, 1, 10, 0, 2, 5, 7, (8), 6};
  int size = sizeof(nums) / sizeof(*nums);

  for (int i = 0; i < size; i++) {
    int* aux = &(nums[i]);
    int ok = BSTreeAdd(t1, aux);
    printf("BSTreeAdd(t1, &(%d)) -> %d\n", *aux, ok);
    BSTreeView(t1);
    BSTreeTestInvariants(t1);
  }
  printf("\nFINISHED INSERTING\n");

  printf("\nQUERY FUNCTIONS\n");
  printf("NumElements = %d\n", BSTreeGetNumberOfNodes(t1));
  printf("Height = %d\n", BSTreeGetHeight(t1));
  printf("Min = %d\n", *((int*)BSTreeGetMin(t1)));
  printf("Max = %d\n", *((int*)BSTreeGetMax(t1)));

  printf("\nTREE CONTAINS\n");
  for (int n = -1; n < size + 3; n += 3) {
    int ok = BSTreeContains(t1, &n);
    printf("BSTreeContains(t1, &(%d)) -> %d\n", n, ok);
  }

  printf("\nTRAVERSE\n");
  BSTreeTraverseINOrder(t1, printer);
  printf("\n");

  printf("\nTRAVERSE with BSTreeGetItems\n");
  Queue *q = BSTreeGetItems(t1);
  while (!QueueIsEmpty(q)) {
    int *aux = (int*)QueueDequeue(q);
    printf("%d ", *aux);
  }
  printf("\n");
  QueueDestroy(&q);

  printf("\nREMOVING items using their VALUE\n");
  for (int i = 1; i < size; i += 2) {
    int* aux = &(nums[i]);
    int ok = BSTreeRemove(t1, aux);
    printf("BSTreeRemove(t1, &(%d)) -> %d\n", *aux, ok);
    BSTreeView(t1);
    BSTreeTestInvariants(t1);
  }
  printf("\nFINISHED REMOVING\n");

  printf("%d elements\n", BSTreeGetNumberOfNodes(t1));
  printf("height = %d\n", BSTreeGetHeight(t1));
  BSTreeTraverseINOrder(t1, printer);
  printf("\n");

  printf("\nREMOVING remaining items in decreasing order\n");
  while (BSTreeGetNumberOfNodes(t1) > 0) {
    int* aux = (int*)BSTreeGetMax(t1);
    int ok = BSTreeRemove(t1, aux);
    printf("BSTreeRemove(t1, &(%d)) -> %d\n", *aux, ok);
    BSTreeView(t1);
    BSTreeTestInvariants(t1);
  }
  printf("\nFINISHED REMOVING\n");

  printf("%d elements\n", BSTreeGetNumberOfNodes(t1));
  printf("height = %d\n", BSTreeGetHeight(t1));
  BSTreeTraverseINOrder(t1, printer);
  printf("\n");

  BSTreeDestroy(&t1);

  return 0;
}
