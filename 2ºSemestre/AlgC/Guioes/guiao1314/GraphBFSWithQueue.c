//
// Joaquim Madeira, AlgC, May 2020
// João Manuel Rodrigues, AlgC, May 2020
//
// GraphBFS - QUEUE-based Breadth-First Search
//

#include "GraphBFSWithQueue.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersQueue.h"
#include "IntegersStack.h"

struct _GraphBFSWithQueue {
  unsigned int* marked;
  int* distance;
  int* predecessor;
  Graph* graph;
  unsigned int startVertex;
};

GraphBFSWithQueue* GraphBFSWithQueueExecute(Graph* g,
                                            unsigned int startVertex) {
  assert(g != NULL);
  assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

  GraphBFSWithQueue* traversal =
      (GraphBFSWithQueue*)malloc(sizeof(struct _GraphBFSWithQueue));
  assert(traversal != NULL);

  unsigned int numVertices = GraphGetNumVertices(g);

  //
  // COMPLETAR !!
  //
  // CRIAR e INICIALIZAR os campos de traversal
  // traversal->marked
  // traversal->distance
  // traversal->predecessor

  traversal->marked = (unsigned int*)calloc(numVertices, sizeof(unsigned int));
  assert(traversal->marked != NULL);

  traversal->distance = (int*)calloc(numVertices, sizeof(int));
  assert(traversal->distance != NULL);
  
  traversal->predecessor = (int*)malloc(numVertices * sizeof(int));
  assert(traversal->predecessor != NULL);
  for (int i = 0; i < numVertices; i++) {
    traversal->predecessor[i] = -1;
  }
  
  traversal->predecessor[startVertex] = -1;

  traversal->graph = g;
  traversal->startVertex = startVertex;

  // EFETUAR A TRAVESSIA

  // COMPLETAR !!
  Queue* queue = QueueCreate(numVertices);
  QueueEnqueue(queue, traversal->startVertex);
  traversal->marked[startVertex] = 1;

  while(!QueueIsEmpty(queue))
  {
    int v = QueueDequeue(queue);
    unsigned int* neighbors = GraphGetAdjacentsTo(traversal->graph, v);

    for (int i = 1; i <= neighbors[0]; i++) {
      unsigned int w = neighbors[i];
      if (traversal->marked[w] == 0) {
        QueueEnqueue(queue, w);
        traversal->marked[w] = 1;
        traversal->distance[w] = traversal->distance[v] + 1;
        traversal->predecessor[w] = v;
      }
    }
    free(neighbors);
  }

  QueueDestroy(&queue);

  return traversal;
}

void GraphBFSWithQueueDestroy(GraphBFSWithQueue** p) {
  assert(*p != NULL);

  GraphBFSWithQueue* aux = *p;

  free(aux->marked);
  free(aux->predecessor);

  free(*p);
  *p = NULL;
}

// Getting the result

unsigned int GraphBFSWithQueueHasPathTo(const GraphBFSWithQueue* p,
                                        unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return p->marked[v];
}

Stack* GraphBFSWithQueuePathTo(const GraphBFSWithQueue* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = StackCreate(GraphGetNumVertices(p->graph));

  if (p->marked[v] == 0) {
    return s;
  }

  // Store the path
  for (unsigned int current = v; current != p->startVertex;
       current = p->predecessor[current]) {
    StackPush(s, current);
  }

  StackPush(s, p->startVertex);

  return s;
}

// DISPLAYING on the console

void GraphBFSWithQueueShowPath(const GraphBFSWithQueue* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = GraphBFSWithQueuePathTo(p, v);

  while (StackIsEmpty(s) == 0) {
    printf("%d ", StackPop(s));
  }

  StackDestroy(&s);
}

void GraphBFSWithQueueDisplay(const GraphBFSWithQueue* p) {
  // COMPLETAR !!
  Graph* g = p->graph;

  printf("---\n");
  if (GraphIsWeighted(g)) {
    printf("Weighted ");
  }
  if (GraphIsComplete(g)) {
    printf("COMPLETE ");
  }
  if (GraphIsDigraph(g)) {
    printf("Digraph\n");
    printf("Max Out-Degree = %d\n", GraphGetMaxOutDegree(g));
  } else {
    printf("Graph\n");
    printf("Max Degree = %d\n", GraphGetMaxDegree(g));
  }
  printf("Vertices = %2d | Edges = %2d\n", GraphGetNumVertices(g), GraphGetNumEdges(g));

  printf("Initial Vertex: %d\n", p->startVertex);
  for (int i = 0; i < GraphGetNumVertices(g); i++) 
    printf("%d ->\tmarked: %d\tpredecessor: %d\tdistance: %d\n", i, p->marked[i], p->predecessor[i], p->distance[i]);
}
