//
// Joaquim Madeira, AlgC, April 2021
//
// Testing the generic sorting module
//
// Arrays store records (struct Person)
//

#include <assert.h>
#include <stdio.h>
#include <string.h>

#include "Sorting.h"

struct Person {
  char firstName[25];
  char lastName[25];
};

int lessForFirstName(void *p1, void *p2) {
  assert(p1 != NULL && p2 != NULL);
  struct Person *first = (struct Person *)p1;
  struct Person *second = (struct Person *)p2;
  return strcmp(first->firstName, second->firstName) < 0;
}

int lessForLastName(void *p1, void *p2) {
  assert(p1 != NULL && p2 != NULL);
  struct Person *first = (struct Person *)p1;
  struct Person *second = (struct Person *)p2;
  return strcmp(first->lastName, second->lastName) < 0;
}

void printForPersons(void *p) {
  assert(p != NULL);
  struct Person *s = (struct Person *)p;  // Casting to the appropriate pointer
  printf("%s %s", s->firstName, s->lastName);
}

void swapForPersons(void *p1, void *p2) {
  assert(p1 != NULL && p2 != NULL);
  struct Person temp = *(struct Person *)p1;
  *(struct Person *)p1 = *(struct Person *)p2;
  *(struct Person *)p2 = temp;
}

int main(void) {
  struct Person profs[6] = {
      {"Joaquim", "Madeira"}, {"Joao", "Rodrigues"},
      {"Augusto", "Silva"},   {"Tomas", "Oliveira e Silva"},
      {"Susana", "Sargento"}, {"Carlos", "Costa"}};

  printArray(profs, 6, sizeof(struct Person), printForPersons);

  // Sorting by the first name
  bubbleSort(profs, 6, sizeof(struct Person), lessForFirstName, swapForPersons);
  assert(isSorted(profs, 6, sizeof(struct Person), lessForFirstName));
  printf("Sorted by the first name:\n");
  printArray(profs, 6, sizeof(struct Person), printForPersons);

  // Sorting by the last name
  bubbleSort(profs, 6, sizeof(struct Person), lessForLastName, swapForPersons);
  assert(isSorted(profs, 6, sizeof(struct Person), lessForLastName));
  printf("Sorted by the last name:\n");
  printArray(profs, 6, sizeof(struct Person), printForPersons);

  return 0;
}