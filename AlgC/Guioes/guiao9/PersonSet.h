#ifndef _PERSONSET_
#define _PERSONSET_

#include "Person.h"

// Type for sorted sequences:
typedef struct _PersonSet_ PersonSet;

PersonSet* PersonSetCreate() ;
void PersonSetDestroy(PersonSet **pps) ;
int PersonSetSize(const PersonSet *ps) ;
int PersonSetIsEmpty(const PersonSet *ps) ;
void PersonSetPrint(const PersonSet *ps) ;

void PersonSetAdd(PersonSet *ps, Person *p) ;
Person* PersonSetPop(PersonSet *ps) ;
Person* PersonSetRemove(PersonSet *ps, int id) ;

Person *PersonSetGet(const PersonSet *ps, int id) ;
int PersonSetContains(const PersonSet *ps, int id) ;

PersonSet *PersonSetUnion(const PersonSet *ps1, const PersonSet *ps2) ;
PersonSet *PersonSetIntersection(const PersonSet *ps1, const PersonSet *ps2) ;
PersonSet *PersonSetDifference(const PersonSet *ps1, const PersonSet *ps2) ;

int PersonSetIsSubset(const PersonSet *ps1, const PersonSet *ps2) ;
int PersonSetEquals(const PersonSet *ps1, const PersonSet *ps2) ;

#endif

