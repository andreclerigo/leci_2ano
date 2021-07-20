//
// Joaquim Madeira, AlgC, May 2020
// João Manuel Rodrigues, AlgC, May 2020
//
// Graph EXAMPLE
//

#include "Graph.h"
#include "GraphDFSRec.h"

int main(void) {
  Graph* g01 = GraphCreate(6, 0, 0);

  GraphAddEdge(g01, 0, 5);
  GraphAddEdge(g01, 2, 4);
  GraphAddEdge(g01, 2, 3);
  GraphAddEdge(g01, 1, 2);
  GraphAddEdge(g01, 0, 1);
  GraphAddEdge(g01, 3, 4);
  GraphAddEdge(g01, 3, 5);
  GraphAddEdge(g01, 0, 2);

  GraphDisplay(g01);

  GraphDFSRec* traversal = GraphDFSRecExecute(g01, 0);

  printf("Path from 0 to 5: ");
  GraphDFSRecShowPath(traversal, 5);
  printf("\n");

  GraphDFSRecDestroy(&traversal);

  GraphDestroy(&g01);

  return 0;
}
