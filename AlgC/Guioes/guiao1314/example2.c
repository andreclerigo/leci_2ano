//
// Joaquim Madeira, AlgC, June 2021
// João Manuel Rodrigues, AlgC, June 2021
//
// Graph EXAMPLE
//

#include "Graph.h"
#include "GraphBFSWithQueue.h"
#include "GraphDFSRec.h"
#include "GraphDFSWithStack.h"

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

  // Recursive DFS traversal

  GraphDFSRec* traversalRec = GraphDFSRecExecute(g01, 0);

  printf("Path from 0 to 5: ");
  GraphDFSRecShowPath(traversalRec, 5);
  printf("\n");

  GraphDFSRecDestroy(&traversalRec);

  // STACK-based DFS traversal
 
  GraphDFSWithStack* traversalWithStack = GraphDFSWithStackExecute(g01, 0);

  printf("Path from 0 to 5: ");
  GraphDFSWithStackShowPath(traversalWithStack, 5);
  printf("\n");
  
  GraphDFSWithStackDisplay(traversalWithStack);

  GraphDFSWithStackDestroy(&traversalWithStack);

  // QUEUE-based BFS traversal
  GraphBFSWithQueue* traversalWithQueue = GraphBFSWithQueueExecute(g01, 0);

  printf("Path from 0 to 5: ");
  GraphBFSWithQueueShowPath(traversalWithQueue, 5);
  printf("\n");

  GraphBFSWithQueueDisplay(traversalWithQueue);

  GraphBFSWithQueueDestroy(&traversalWithQueue);

  GraphDestroy(&g01);
  
  return 0;
}
