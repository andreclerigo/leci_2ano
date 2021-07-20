//
// Joaquim Madeira, AlgC, June 2021
// João Manuel Rodrigues, AlgC, June 2021
//
// Topological Sorting
//

#include "GraphTopologicalSorting.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersQueue.h"

struct _GraphTopoSort {
  unsigned int* marked;            // Aux array
  unsigned int* numIncomingEdges;  // Aux array
  unsigned int* vertexSequence;    // The result
  unsigned int validResult;        // 0 or 1
  unsigned int numVertices;        // From the graph
  Graph* graph;
};

// AUXILIARY FUNCTION
// Allocate memory for the struct
// And for its array fields
// Initialize all struct fields
//
static GraphTopoSort* _create(Graph* g) {
  GraphTopoSort* p = NULL;
  p = (GraphTopoSort*) malloc(sizeof(GraphTopoSort));
  assert(p != NULL);

  p->graph = g;

  // COMPLETAR
  p->numVertices = GraphGetNumVertices(g);

  p->marked = (unsigned int*) calloc(p->numVertices, sizeof(unsigned int));
  assert(p->marked != NULL);

  p->validResult = 0;

  p->numIncomingEdges = (unsigned int*) calloc(p->numVertices, sizeof(unsigned int));
  assert(p->numIncomingEdges != NULL);

  // Preencher numEdges
  for (int i = 0; i < p->numVertices; i++)
    p->numIncomingEdges[i] = GraphGetVertexInDegree(g, i);

  p->vertexSequence = (unsigned int*) calloc(p->numVertices, sizeof(unsigned int));
  assert(p->vertexSequence != NULL);

  return p;
}

//
// Computing the topological sorting, if any, using the 1st algorithm:
// 1 - Create a copy of the graph
// 2 - Successively identify vertices without incoming edges and remove their
//     outgoing edges
// Check if a valid sorting was computed and set the isValid field
// For instance, by checking if the number of elements in the vertexSequence is
// the number of graph vertices
//
GraphTopoSort* GraphTopoSortComputeV1(Graph* g) {
  assert(g != NULL && GraphIsDigraph(g) == 1);

  // Create and initialize the struct

  GraphTopoSort* topoSort = _create(g);
  GraphTopoSort* copy = GraphCopy(topoSort->graph);
  // Build the topological sorting

  // COMPLETAR
  int flag = 1;
  int nextIndex = 0;

  while(flag == 1 && nextIndex < copy->numVertices)
  {
    flag = 0;
    for (int i = 0; i < copy->numVertices; i++)
    {
      if (copy->numIncomingEdges[i] == 0)
      {
        flag = 1;
        copy->vertexSequence[nextIndex++] = i;
        unsigned int outDegreeVertices[] = GraphGetAdjacentsTo(copy->graph, i);

        for (int w = 0; w < sizeof(outDegreeVertices)/sizeof(unsigned int); w++)
          GraphRemoveEdge(g, i, outDegreeVertices[w]);
      }
    }
  }

  if (nextIndex == topoSort->numVertices)
    topoSort->validResult = 1;
  
  return topoSort;
}

//
// Computing the topological sorting, if any, using the 2nd algorithm
// Check if a valid sorting was computed and set the isValid field
// For instance, by checking if the number of elements in the vertexSequence is
// the number of graph vertices
//
GraphTopoSort* GraphTopoSortComputeV2(Graph* g) {
  assert(g != NULL && GraphIsDigraph(g) == 1);

  // Create and initialize the struct
  GraphTopoSort* topoSort = _create(g);

  // Build the topological sorting
  // COMPLETAR
  int flag = 1;
  int nextIndex = 0;

  while (flag == 1 && nextIndex < topoSort->numVertices)
  {
    flag = 0;
    for (int i = 0; i < topoSort->numVertices; i++)
    {
      if (topoSort->numIncomingEdges[i] == 0 && topoSort->marked[i] == 0)
      {
        flag = 1;
        topoSort->vertexSequence[nextIndex++] = i;
        topoSort->marked[i] = 1;
        unsigned int* neighbors = GraphGetAdjacentsTo(g, i);
      
        for (int i = 1; i <= neighbors[0]; i++)
        {
          unsigned int w = neighbors[i];
          topoSort->numIncomingEdges[w]--;
        }
        free(neighbors);
        break;
      }
    }
  }
  
  if (nextIndex == topoSort->numVertices)
    topoSort->validResult = 1;

  return topoSort;
}

//
// Computing the topological sorting, if any, using the 3rd algorithm
// Check if a valid sorting was computed and set the isValid field
// For instance, by checking if the number of elements in the vertexSequence is
// the number of graph vertices
//
GraphTopoSort* GraphTopoSortComputeV3(Graph* g) {
  assert(g != NULL && GraphIsDigraph(g) == 1);

  // Create and initialize the struct

  GraphTopoSort* topoSort = _create(g);

  // Build the topological sorting

  // COMPLETAR
  
  Queue* q = QueueCreate(topoSort->numVertices);

  // Inserir vertices com numEdges[v] == 0
  for (int i = 0; i < topoSort->numVertices; i++)
  {
    if (topoSort->numIncomingEdges[i] == 0)
    {
      QueueEnqueue(q, i);
      topoSort->marked[i] = 1;
    }
  }

  int nextIndex = 0;
  while(!QueueIsEmpty(q))
  {
    unsigned int v = QueueDequeue(q);
    topoSort->vertexSequence[nextIndex++] = v;
    unsigned int* neighbors = GraphGetAdjacentsTo(g, v);
    
    for (int i = 1; i <= neighbors[0]; i++)
    {
      unsigned int w = neighbors[i];
      topoSort->numIncomingEdges[w]--;
      if (topoSort->numIncomingEdges[w] == 0)
        QueueEnqueue(q, w);
    }
    free(neighbors);
  }

  if (nextIndex == topoSort->numVertices)
    topoSort->validResult = 1;
  
  QueueDestroy(&q);

  return topoSort;
}

void GraphTopoSortDestroy(GraphTopoSort** p) {
  assert(*p != NULL);

  GraphTopoSort* aux = *p;

  free(aux->marked);
  free(aux->numIncomingEdges);
  free(aux->vertexSequence);

  free(*p);
  *p = NULL;
}

//
// A valid sorting was computed?
//
int GraphTopoSortIsValid(const GraphTopoSort* p) { return p->validResult; }

//
// Getting an array containing the topological sequence of vertex indices
// Or NULL, if no sequence could be computed
// MEMORY IS ALLOCATED FOR THE RESULTING ARRAY
//
unsigned int* GraphTopoSortGetSequence(const GraphTopoSort* p) {
  // COMPLETAR
  unsigned int *result = (unsigned int*)calloc(p->numVertices, sizeof(unsigned int));
  GraphTopoSort *g = (GraphTopoSort*)malloc(sizeof(struct _GraphTopoSort));

  g = GraphTopoSortComputeV1(p->graph);
  if(g != NULL)
  {
    result = g->vertexSequence;
    return result;
  }

  g = GraphTopoSortComputeV2(p->graph);
  if(g != NULL)
  {
    result = g->vertexSequence;
    return result;
  }

  g = GraphTopoSortComputeV3(p->graph);
  if(g != NULL)
  {
    result = g->vertexSequence;
    return result;
  }
  
  //GraphDestroy(&g);

  return NULL;
}

// DISPLAYING on the console

//
// The toplogical sequence of vertex indices, if it could be computed
//
void GraphTopoSortDisplaySequence(const GraphTopoSort* p) {
  if (p->validResult == 0) {
    printf(" *** The topological sorting could not be computed!! *** \n");
    return;
  }

  printf("Topological Sorting - Vertex indices:\n");
  for (int i = 0; i < GraphGetNumVertices(p->graph); i++) {
    printf("%d ", p->vertexSequence[i]);
  }
  printf("\n");
}

//
// The toplogical sequence of vertex indices, if it could be computed
// Followed by the digraph displayed using the adjecency lists
// Adjacency lists are presented in topologic sorted order
//
void GraphTopoSortDisplay(const GraphTopoSort* p) {
  // The topological order
  GraphTopoSortDisplaySequence(p);

  if (p->validResult == 0) {
    return;
  }

  // The Digraph
  for (int i = 0; i < GraphGetNumVertices(p->graph); i++) {
    GraphListAdjacents(p->graph, p->vertexSequence[i]);
  }
  printf("\n");
}
