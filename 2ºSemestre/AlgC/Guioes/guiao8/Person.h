#ifndef PERSON
#define PERSON

#include "Date.h"

typedef struct {
   int id;
   Date birthDate;  // this is the actual structure, not a pointer!
   char* firstName;
   char* lastName;
} Person;


Person* PersonCreate(const char *fname, const char *lname, int yy, int mm, int dd) ;

void PersonDestroy(Person* *pd) ;

void PersonPrintf(Person* p, const char *suffix) ;

int PersonCompareByBirth(const Person *p1, const Person *p2) ;

int PersonCompareByLastFirstName(const Person *p1, const Person *p2) ;

#endif // PERSON
