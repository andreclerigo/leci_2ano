//
// Joaquim Madeira, AlgC, June 2021
// João Manuel Rodrigues, AlgC, June 2021
//
// TOPOLOGICAL SORTING EXAMPLE
//

#include "Graph.h"
#include "GraphTopologicalSorting.h"

int main(void) {
  // The DIGRAPH
  Graph* g01 = GraphCreate(7, 1, 0);

  GraphAddEdge(g01, 0, 1);
  GraphAddEdge(g01, 0, 2);
  GraphAddEdge(g01, 0, 3);
  GraphAddEdge(g01, 1, 3);
  GraphAddEdge(g01, 1, 4);
  GraphAddEdge(g01, 2, 5);
  GraphAddEdge(g01, 3, 5);
  GraphAddEdge(g01, 3, 6);
  GraphAddEdge(g01, 4, 3);
  GraphAddEdge(g01, 4, 6);
  GraphAddEdge(g01, 6, 5);

  GraphDisplay(g01);

  // TOPOLOGICAL SORTING
  /**
  printf(" *** 1st Algorithm ***\n");

  GraphTopoSort* result01 = GraphTopoSortComputeV1(g01);

  GraphTopoSortDisplaySequence(result01);

  GraphTopoSortDestroy(&result01);
  **/
  printf(" *** 2nd Algorithm ***\n");

  GraphTopoSort* result02 = GraphTopoSortComputeV2(g01);

  GraphTopoSortDisplaySequence(result02);

  GraphTopoSortDestroy(&result02);
  
  printf(" *** 3rd Algorithm ***\n");

  GraphTopoSort* result03 = GraphTopoSortComputeV3(g01);

  GraphTopoSortDisplay(result03);

  GraphTopoSortDestroy(&result03);

  // ANOTHER DIGRAPH
  
  Graph* g02 = GraphCreate(5, 1, 0);

  GraphAddEdge(g02, 0, 1);
  GraphAddEdge(g02, 1, 2);
  GraphAddEdge(g02, 2, 3);
  GraphAddEdge(g02, 3, 1);
  GraphAddEdge(g02, 1, 4);

  GraphDisplay(g02);
  
  // TOPOLOGICAL SORTING
  /**
  printf(" *** 1st Algorithm ***\n");

  result01 = GraphTopoSortComputeV1(g02);

  GraphTopoSortDisplaySequence(result01);

  GraphTopoSortDestroy(&result01);
  **/
  printf(" *** 2nd Algorithm ***\n");

  result02 = GraphTopoSortComputeV2(g02);

  GraphTopoSortDisplaySequence(result02);

  GraphTopoSortDestroy(&result02);

  printf(" *** 3rd Algorithm ***\n");
  
  result03 = GraphTopoSortComputeV3(g02);

  GraphTopoSortDisplay(result03);

  GraphTopoSortDestroy(&result03);

  // House-keeping
  GraphDestroy(&g01);
  GraphDestroy(&g02);
  
  return 0;
}
