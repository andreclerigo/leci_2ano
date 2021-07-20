// AlgC, May 2021

// Run this program with an integer argument such as:  ./Tests 8

#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "Person.h"
#include "PersonSet.h"

// MACRO to print expression X of type int (int X) and its result
#define SHOWint(X) do{ printf("%s -> %d\n", #X, (X)); }while(0)

// MACRO to print expression X of type string (char* X) and its result
#define SHOWstr(X) do{ printf("%s -> %s\n", #X, (X)); }while(0)

// MACRO to print expression X of type date (Date* X) and its result
#define SHOWDate(X) do{ printf("%s -> %s\n", #X, DateFormat(X, YMD)); }while(0)

// MACRO to print expression X of type Person and its result
#define SHOWPerson(X) do{ printf("%s -> ", #X); PersonPrintf(X, "\n"); }while(0)

#define SHOWPersonSet(X) do{ printf("%s -> ", #X); PersonSetPrint(X); }while(0)

int main(int argc, char* argv[]) {

  int lasttest = 9999;
  if (argc > 1) {
    lasttest = atoi(argv[1]);  // last test to perform
  }
  srand(lasttest);  // Initialize generator for repeatability
  int test = 0;

  if (++test > lasttest) return 0;
  printf("\n%d) PersonCreate---\n", test);
  const int NP = 10; // number of persons
  Person *person[NP];
  person[0] = PersonCreate("Eva"    , "Maia"        , 1977, 10, 20);
  person[1] = PersonCreate("Maria"  , "Silva"       , 2003, 12, 30);
  person[2] = PersonCreate("Paulo"  , "Guedes"      , 2003, 12, 31);
  person[3] = PersonCreate("Carlos" , "Silva"       , 1999,  8, 31);
  person[4] = PersonCreate("Filipe" , "Matos"       , 2001,  1,  1);
  person[5] = PersonCreate("Carla"  , "Oliveira"    , 1959,  1,  1);
  person[6] = PersonCreate("Vitor"  , "Maia"        , 1969,  2, 28);
  person[7] = PersonCreate("Olga"   , "Costa"       , 1967,  2, 29);
  person[8] = PersonCreate("Tiago"  , "Santos"      , 1996,  6, 13);
  person[9] = PersonCreate("Sara"   , "Santos"      , 2007,  3,  1);
  
  if (++test > lasttest) return 0;
  printf("\n%d) PersonSetCreate---\n", test);
  PersonSet *ps1 = PersonSetCreate();
  PersonSet *ps2 = PersonSetCreate();
  PersonSet *ps3 = PersonSetCreate();
  SHOWint( PersonSetSize(ps1) );
  // SHOWint( ps1->capacity );
  
  if (++test > lasttest) return 0;
  printf("\n%d) PersonSetAdd---\n", test);
  for (int n = 0; n < 7; n++) {
    int i = rand()%NP;
    PersonSetAdd(ps1, person[i]);
  }
  SHOWPersonSet(ps1);
  for (int n = 0; n < 5; n++) {
    int i = rand()%NP;
    PersonSetAdd(ps2, person[i]);
  }
  SHOWPersonSet(ps2);
  for (int n = 0; n < 3; n++) {
    int i = rand()%NP;
    PersonSetAdd(ps3, person[i]);
  }
  SHOWPersonSet(ps3);
  
  if (++test > lasttest) return 0;
  printf("\n%d) PersonSetRemove---\n", test);
  Person *p;
  for (int k = 0; k < 2; ) {
    int id = 1 + rand()%NP;
    SHOWint( id );
    SHOWPerson( p = PersonSetRemove(ps1, id) );
    if (p != NULL) {
      k++;
      SHOWPersonSet( ps1 );
      PersonSetAdd(ps1, p);   // reinsert removed person
      SHOWPersonSet( ps1 );
    }
  }
  
  if (++test > lasttest) return 0;
  printf("\n%d) PersonSetPop---\n", test);
  while (!PersonSetIsEmpty(ps3)) {
    SHOWPerson( PersonSetPop(ps3) );
  }
  SHOWPersonSet( ps3 );
  
  if (++test > lasttest) return 0;
  printf("\n%d) PersonSetGet / Contains---\n", test);
  for (int k = 0; k < 4; k++) {
    int id = 1 + rand()%NP;
    SHOWint( id );
    SHOWPerson( PersonSetGet(ps1, id) );
    SHOWint( PersonSetContains(ps1, id) );
  }
  
  if (++test > lasttest) return 0;
  printf("\n%d) PersonSetUnion/Intersection/Difference---\n", test);
  SHOWPersonSet( ps1 );
  SHOWPersonSet( ps2 );
  PersonSet *ps4;
  SHOWPersonSet( ps4 = PersonSetUnion(ps1, ps2) );
  PersonSet *ps5;
  SHOWPersonSet( ps5 = PersonSetIntersection(ps1, ps2) );
  PersonSet *ps6;
  SHOWPersonSet( ps6 = PersonSetIntersection(ps2, ps1) );
  PersonSet *ps7;
  SHOWPersonSet( ps7 = PersonSetDifference(ps1, ps2) );

  if (++test > lasttest) return 0;
  printf("\n%d) PersonSetIsSubset/Equals---\n", test);
  SHOWint( PersonSetIsSubset(ps5, ps1) ); // must be true
  SHOWint( PersonSetIsSubset(ps5, ps2) ); // must be true
  SHOWint( PersonSetIsSubset(ps6, ps2) ); // must be false
  
  SHOWint( PersonSetEquals(ps1, ps2) );   // should be false (different sizes)
  SHOWint( PersonSetEquals(ps5, ps6) );   // must be true
  
  PersonSetDestroy(&ps1);
  PersonSetDestroy(&ps2);
  PersonSetDestroy(&ps3);
  PersonSetDestroy(&ps4);
  PersonSetDestroy(&ps5);
  PersonSetDestroy(&ps6);
  PersonSetDestroy(&ps7);
  
  // Free everything
  // (If you comment out any of these, valgrind should detect it!)
  for (int i = 0; i < NP; i++) {
    PersonDestroy(&(person[i]));
  }
  
  return 0;
}

