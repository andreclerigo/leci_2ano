// You should not need to change this file.

#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "Date.h"
#include "Person.h"

// MACRO to print expression X of type int (int X) and its result
#define SHOWint(X) do{ printf("%s -> %d\n", #X, (X)); }while(0)

// MACRO to print expression X of type string (char* X) and its result
#define SHOWstr(X) do{ printf("%s -> %s\n", #X, (X)); }while(0)

// MACRO to print expression X of type date (Date* X) and its result
#define SHOWDate(X) do{ printf("%s -> %s\n", #X, DateFormat(X, YMD)); }while(0)

// MACRO to print expression X of type Person and its result
#define SHOWPerson(X) do{ printf("%s -> ", #X); PersonPrintf(X, "\n"); }while(0)

// (C preprocessor macros are quite powerful.)

// Returns +1, -1 or 0 if d>0, d<0 or d==0
int signum(int d) {
  return (d>0)-(d<0);
}

int main(int argc, char* argv[]) {
  int lasttest = 9999;
  if (argc > 1) {
    lasttest = atoi(argv[1]);  // last test to perform
  }
  int test = 0;

  printf("\n%d) Date Constants---\n", test);
  SHOWDate(&DateMIN);
  SHOWDate(&DateMAX);
  //DateMIN.day = 9;  // Changing constants is forbiden!
  
  printf("\n%d) Date Automatic Variables---\n", test);
  // We can define automatic or static variables of type Date.
  // We may even initialize them directly:
  Date dd0 = {1999, 9, 9};  // BUT we should be CAREFUL!
  SHOWDate(&dd0);
  Date dd1 = {1999, 9, 31}; // This works, BUT date is INVALID!
  SHOWDate(&dd1);
  
  // Since the data structure is public (exposed in Date.h),
  // we can access the fields directly.
  SHOWint(dd0.year);
  SHOWint(dd0.month);
  SHOWint(dd0.day);
  
  // Since the fields are public, we can even do this:
  dd1.day = 0;  // This works, BUT date is INVALID!
  // Who is responsible for ensuring the invariant?
  
  if (++test > lasttest) return 0;
  printf("\n%d) DateCreate---\n", test);
  // We can dynamically create (allocate) a Date variable
  // and initialize it (DateCreate is analogous to a constructor).
  Date* d1 = DateCreate(2019, 12, 25);  // NOTE: d1 is a POINTER!
  SHOWDate(d1);
  // ADVANTAGE: DateCreate requires that arguments satisfy preconditions
  //   so that the created date is guaranteed to satisfy the invariant!
  //   d1 = DateCreate(1999, 9, 31);  // would FAIL!
  // DISADVANTAGE: We must keep track of memory and eventually free it!

  Date* d2 = DateCreate(2020, 4, 2);
  SHOWDate(d2);
  assert(d2 != d1); // should be two different addresses in memory
  SHOWDate(d1);     // d1 should not be changed
  
  if (++test > lasttest) return 0;
  printf("\n%d) DateDestroy---\n", test);
  DateDestroy(&d2);   // argument is the address of the pointer varible
  SHOWDate(d2);       // d2 should now be NULL
  assert(d2==NULL);   // AND memory should be freed! (check with valgrind)
  d2 = DateCreate(2020, 3, 2);  // After freeing, d2 can be reused
  SHOWDate(d1);
  SHOWDate(d2);
  
  if (++test > lasttest) return 0;
  printf("\n%d) DateFormat---\n", test);
  SHOWstr(DateFormat(d1, YMD));
  SHOWstr(DateFormat(d1, DMY));
  SHOWstr(DateFormat(d1, MDY));
  // What happens if we print two dates on the same call?  Why?
  // This was planned, but it may be surpring!
  printf("d1 -> %s  d2 -> %s\n", DateFormat(d1, YMD), DateFormat(d2, YMD));
  
  if (++test > lasttest) return 0;
  printf("\n%d) DateParse---\n", test);
  Date dd3, dd4, dd5;
  SHOWint( DateParse(&dd3, "1111-2-3", YMD) );
  SHOWDate(&dd3);
  SHOWint( DateParse(&dd4, "11/2/3333", DMY) );
  SHOWDate(&dd4);
  SHOWint( DateParse(&dd5, "11/22/3333", MDY) );
  SHOWDate(&dd5);
  SHOWint( DateParse(&dd5, "11/22/1111", DMY) );  // should fail
  SHOWDate(&dd5);
  
  
  if (++test > lasttest) return 0;
  printf("\n%d) DateCompare---\n", test);
  SHOWint(signum(DateCompare(d1, d1)));
  SHOWint(signum(DateCompare(d1, d2)));
  SHOWint(signum(DateCompare(d2, d1)));
  SHOWint(signum(DateCompare(d2, d2)));
  
  if (++test > lasttest) return 0;
  dd0 = *d1;  // Copy *d1 into dd0
  printf("\n%d) DateIncr---\n", test);
  while (DateCompare(d1, d2) <= 0) {
    SHOWDate(d1);
    DateIncr(d1);
  }
  
  if (++test > lasttest) return 0;
  *d2 = dd0;  // Copy dd0 into *d2
  printf("\n%d) DateDecr---\n", test);
  while (DateCompare(d1, d2) >= 0) {
    SHOWDate(d1);
    DateDecr(d1);
  }
  
  // Free the dates
  // (If you comment out any of these, valgrind should detect it!)
  DateDestroy(&d1);
  DateDestroy(&d2);


  if (++test > lasttest) return 0;
  printf("\n%d) PersonCreate---\n", test);
  Person* p1 = PersonCreate("Edsgar", "Dijkstra", 1930, 5, 11);
  SHOWPerson(p1);
  
  char name1[10] = "Alan";
  char name2[10] = "Turing";
  Person* p2 = PersonCreate(name1, name2, 1912, 6, 23);
  SHOWPerson(p2);
  assert(p2 != p1); // should be two different addresses in memory
  SHOWPerson(p1);   // p1 should not be changed
  name1[3] = '\0';  // truncate name1->"Ala"
  name1[2] = '\0';  // truncate name2->"Tu"
  SHOWPerson(p2);   // *p2 should keep a copy of the original names!
  
  if (++test > lasttest) return 0;
  printf("\n%d) PersonDestroy---\n", test);
  PersonDestroy(&p2);  // argument is the address of the pointer varible
  SHOWPerson(p2);         // p2 should now be NULL
  assert(p2==NULL);
  p2 = PersonCreate("Ada", "Lovelace", 1815, 12, 10);
  SHOWPerson(p1);
  SHOWPerson(p2);
  
  if (++test > lasttest) return 0;
  printf("\n%d) PersonCompareByBirth---\n", test);
  SHOWint(signum(PersonCompareByBirth(p1, p1)));
  SHOWint(signum(PersonCompareByBirth(p1, p2)));
  SHOWint(signum(PersonCompareByBirth(p2, p1)));
  SHOWint(signum(PersonCompareByBirth(p2, p2)));
  
  if (++test > lasttest) return 0;
  printf("\n%d) PersonCompareByBirth---\n", test);
  SHOWint(signum(PersonCompareByLastFirstName(p1, p1)));
  SHOWint(signum(PersonCompareByLastFirstName(p1, p2)));
  SHOWint(signum(PersonCompareByLastFirstName(p2, p1)));
  SHOWint(signum(PersonCompareByLastFirstName(p2, p2)));
  
  // Free everything
  // (If you comment out any of these, valgrind should detect it!)
  PersonDestroy(&p1);
  PersonDestroy(&p2);
  
  return 0;
}

