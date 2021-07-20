// A possible solution.
// JMR 2021

#include <assert.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "Person.h"

// This variable stores the last ID that was assigned to a Person.
// It should be used to assign serial, unique IDs automatically upon creation.
// The first person will have id=1, the second id=2, etc.
static int lastID = 0;

// Alocate and store a Person.
// Returns the pointer to the new structure.
// (Exits if allocation fails.)
// The names are copied to internally allocated memory.
Person* PersonCreate(const char *fname, const char *lname, int yy, int mm, int dd) {
  // SOLUTION
  size_t flen = strnlen(fname, 100);
  size_t llen = strnlen(lname, 100);
  Person* p = (Person*) malloc(sizeof(*p));
  if (p == NULL) { perror("PersonCreate"); exit(2); }
  
  // Here we decided to allocate space for both strings at once.
  char *s = (char*) malloc((flen+llen+2)*sizeof(char));
  if (s == NULL) { free(p); perror("PersonCreate"); exit(2); }
  p->id = ++lastID;
  p->birthDate.year = (uint16_t)yy;
  p->birthDate.month = (uint8_t)mm;
  p->birthDate.day = (uint8_t)dd;
  p->firstName = s;
  p->lastName = s+flen+1;   // Use pointer arithmetic to find address!
  strcpy(p->firstName, fname); // copy the names
  strcpy(p->lastName, lname);
  return p;
}

// Free the memory pointed to by *pp and by the names inside it,
// and invalidate *pp contents.
// Precondition: *pp must not be NULL.
// Postcondition: *pp is set to NULL.
void PersonDestroy(Person* *pp) {
  assert(*pp != NULL);
  // SOLUTION
  free((*pp)->firstName);  // free the names
  free(*pp);
  *pp = NULL;
}

// Prints a person formatted as "[id, lastname, firstname, birthdate]",
// followed by a suffix string.
void PersonPrintf(Person* p, const char *suffix) {
  if (p == NULL)
    printf("NULL%s", suffix);
  else
    printf("(%d, %s, %s, %s)%s",
           p->id, p->lastName, p->firstName,
           DateFormat(&(p->birthDate), YMD), suffix);
}

// Compare birth dates of two persons.
// Return a negative/positive integer if p1 was born before/after p2.
// Return zero if p1 and p2 were born on the same date.
int PersonCompareByBirth(const Person *p1, const Person *p2) {
  // SOLUTION
  return DateCompare(&(p1->birthDate), &(p2->birthDate));
}

// Compare two persons by last name, then first name (if last name is the same).
// Return a -/+/0 integer if p1 precedes/succeeds/is equal to p2.
int PersonCompareByLastFirstName(const Person *p1, const Person *p2) {
  // SOLUTION
  int cmp = strcmp(p1->lastName, p2->lastName);
  if (cmp != 0) return cmp;
  cmp = strcmp(p1->firstName, p2->firstName);
  return cmp;
}
