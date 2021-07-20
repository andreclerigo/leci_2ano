//
// Joaquim Madeira, AlgC, May 2020
//
// Simple Hash Table using Separate Chaining
// Key and Value are STRINGS - To simplify the example
//

#ifndef _HASH_TABLE_
#define _HASH_TABLE_

typedef struct _HashTableHeader HashTable;

typedef unsigned int (*hashFunction)(const char* key);

// Auxiliary functions for experimenting

unsigned int hash1(const char* key);
unsigned int hash2(const char* key);

// TAD Functions

HashTable* HashTableCreate(unsigned int capacity, hashFunction hashF);

void HashTableDestroy(HashTable** p);

// HashTable properties

int HashTableIsEmpty(const HashTable* hashT);

// Getters

int HashTableGetNumberOfItems(const HashTable* hashT);

double HashTableGetLoadFactor(const HashTable* hashT);

// Operations with items

int HashTableContains(const HashTable* hashT, char* key);

char* HashTableGet(HashTable* hashT, char* key);

int HashTablePut(HashTable* hashT, char* key, char* value);

int HashTableReplace(const HashTable* hashT, char* key, char* value);

int HashTableRemove(HashTable* hashT, char* key);

// DISPLAYING on the console

void HashTableDisplay(const HashTable* hashT);

#endif  // _HASH_TABLE_
