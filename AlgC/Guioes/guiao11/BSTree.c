// NMEC: 98485
// NOME: André Clérigo
//
// Joaquim Madeira, AlgC, May 2021
// João Manuel Rodrigues, AlgC, May 2020
//
// Binary Search Tree storing pointers to items --- BALANCED TREE version
//

//// PROCURE ... E COMPLETE ////

#include "BSTree.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

struct _BSTreeNode {
  void* item;
  struct _BSTreeNode* left;
  struct _BSTreeNode* right;
  int height;
};

struct _BSTreeHeader {
  unsigned int numNodes;
  struct _BSTreeNode* root;
  compFunc compare;
  printFunc print;
};

BSTree* BSTreeCreate(compFunc compF, printFunc printF) {
  BSTree* t = (BSTree*)malloc(sizeof(struct _BSTreeHeader));
  if (t == NULL) abort();

  t->numNodes = 0;
  t->root = NULL;
  t->compare = compF;
  t->print = printF;
  return t;
}

static void _treeDestroy(struct _BSTreeNode** pRoot) {
  struct _BSTreeNode* root = *pRoot;

  if (root == NULL) return;

  _treeDestroy(&(root->left));
  _treeDestroy(&(root->right));
  free(root);

  *pRoot = NULL;
}
// Q: What kind of tree traversal is this function doing?
// 1) Breadth-first,
// 2) Depth-first pre-order,
// 3) Depth-first in-order or
// 4) Depth-first post-order?
// A: Depth-first post-order
// Q: Is this the best order here? Why?
// A: É a melhor ordem porque estamos a destruir a arvore de baixo para cima 
//    (destruimos primeiro as subarvores e só depois o nó), assim não vamos 
//    precisar de referenciar as subarvores variaveis axuiliares

void BSTreeDestroy(BSTree** pHeader) {
  BSTree* header = *pHeader;
  if (header == NULL) return;

  _treeDestroy(&(header->root));

  free(header);

  *pHeader = NULL;
}

// FUNÇÕES DE CONSULTA

int BSTreeIsEmpty(const BSTree* header) {
  assert(header != NULL);
  return header->root == NULL;
}

unsigned int BSTreeGetNumberOfNodes(const BSTree* header) {
  assert(header != NULL);
  return header->numNodes;
}

// Determina a altura da (sub)árvore que nasce no nó root.
// (Função RECURSIVA interna, que pode ser usada para verificação.)
static int _treeGetHeightREC(const struct _BSTreeNode* root) {
  // Complete a função
  if (root == NULL) return -1;

  int heightLeftSubTree = _treeGetHeightREC(root->left);
  int heightRightSubTree = _treeGetHeightREC(root->right);

  if (heightLeftSubTree > heightRightSubTree)
    return 1+ heightLeftSubTree;

  return 1 + heightRightSubTree;
}

// Funcao auxiliar que consulta o campo height, se o no existir
static int _treeGetHeight(const struct _BSTreeNode* root) {
  if (root == NULL) {
    return -1;
  }
  return root->height;
}

// Devolve a altura da árvore.
// Segundo a convenção usada, uma árvore vazia tem altura=-1
// e uma árvore de um nó tem altura=0.
int BSTreeGetHeight(const BSTree* header) {
  assert(header != NULL);
  return _treeGetHeight(header->root);
}

// Acha e devolve o menor item da árvore.
// Requer que a árvore não esteja vazia!
void* BSTreeGetMin(const BSTree* header) {
  assert(header != NULL);
  assert(!BSTreeIsEmpty(header));

  // Complete a função com uma solução ITERATIVA.
  struct _BSTreeNode* root = header->root;

  while (root->left != NULL)
    root = root->left;

  return root->item;
}

// Acha e devolve o maior item da (sub)árvore que nasce no nó root.
// (Função interna invocada em BSTreeGetMax.)
static void* _treeGetMax(const struct _BSTreeNode* root) {
  assert(root != NULL);

  // Complete a função com uma solução RECURSIVA.
  if (root->right == NULL)
    return root->item;
  
  return _treeGetMax(root->right);
}

// Acha e devolve o maior item da árvore.
// Requer que a árvore não esteja vazia!
void* BSTreeGetMax(const BSTree* header) {
  assert(header != NULL);
  assert(!BSTreeIsEmpty(header));

  return _treeGetMax(header->root);  // chama a função interna recursiva
}

// Procura um item na árvore.
// Devolve um ponteiro para a instância do item armazenada na árvore
// ou NULL se não encontrar o item na árvore
void* BSTreeSearch(const BSTree* header, const void* item) {
  assert(header != NULL);
  assert(item != NULL);
  
  int comp;
  struct _BSTreeNode* current = header->root;
  while (current != NULL) {
    // Complete o corpo do ciclo.
    comp = header->compare(current->item, item);
    
    if (comp == 0)
      return current->item;
    else if (comp > 0)
      current = current->left;
    else 
      current = current->right;
  }

  return NULL;
}

// Does the tree contain an element that compares==0 with this item?
int BSTreeContains(const BSTree* header, const void* item) {
  return BSTreeSearch(header, item) != NULL;
}

// Aplica a função function a cada item da árvore.
// (Função interna usada em BSTreeTraverseINOrder.)
static void _treeTraverseINOrder(struct _BSTreeNode* root,
                                 void (*function)(void* p)) {
  // Corrija a função para que os nós sejam visitados por ordem crescente.
  if (root == NULL) return;
  _treeTraverseINOrder(root->left, function);
  function(root->item);
  _treeTraverseINOrder(root->right, function);
}

// Aplica a função function a cada item da árvore.
void BSTreeTraverseINOrder(BSTree* header, void (*function)(void* p)) {
  assert(header != NULL);
  _treeTraverseINOrder(header->root, function);
}

//
// Funcoes auxiliares para manter a ARVORE EQUILIBRADA EM ALTURA
//

static void _updateNodeHeight(struct _BSTreeNode* t) {
  assert(t != NULL);

  int leftHeight = _treeGetHeight(t->left);
  int rightHeight = _treeGetHeight(t->right);

  t->height = 1 + (leftHeight >= rightHeight ? leftHeight : rightHeight);
}

static void _singleRotateWithLeftChild(struct _BSTreeNode** p) {
  struct _BSTreeNode* pLeft = (*p)->left;

  (*p)->left = pLeft->right;
  pLeft->right = *p;

  _updateNodeHeight(*p);
  _updateNodeHeight(pLeft);

  *p = pLeft;
}

static void _singleRotateWithRightChild(struct _BSTreeNode** p) {
  struct _BSTreeNode* pRight = (*p)->right;

  (*p)->right = pRight->left;
  pRight->left = *p;

  _updateNodeHeight(*p);
  _updateNodeHeight(pRight);

  *p = pRight;
}

static void _doubleRotateWithLeftChild(struct _BSTreeNode** p) {
  _singleRotateWithRightChild(&(*p)->left);
  _singleRotateWithLeftChild(p);
}

static void _doubleRotateWithRightChild(struct _BSTreeNode** p) {
  _singleRotateWithLeftChild(&(*p)->right);
  _singleRotateWithRightChild(p);
}

static void _balanceNode(struct _BSTreeNode** pRoot) {
  int leftHeight, rightHeight;

  if (*pRoot == NULL) return;
  leftHeight = _treeGetHeight((*pRoot)->left);
  rightHeight = _treeGetHeight((*pRoot)->right);

  if (leftHeight - rightHeight == 2) {
    leftHeight = _treeGetHeight((*pRoot)->left->left);
    rightHeight = _treeGetHeight((*pRoot)->left->right);
    if (leftHeight >= rightHeight)
      _singleRotateWithLeftChild(pRoot);
    else
      _doubleRotateWithLeftChild(pRoot);
  } else if (rightHeight - leftHeight == 2) {
    rightHeight = _treeGetHeight((*pRoot)->right->right);
    leftHeight = _treeGetHeight((*pRoot)->right->left);
    if (rightHeight >= leftHeight)
      _singleRotateWithRightChild(pRoot);
    else
      _doubleRotateWithRightChild(pRoot);
  } else
    (*pRoot)->height = 
        1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
}

// Operations with items

// Funcao recursiva auxiliar

static int _BSTreeAdd(struct _BSTreeNode** pRoot, compFunc compF, void* item) {
  struct _BSTreeNode* root = *pRoot;

  if (root == NULL) {
    root = (struct _BSTreeNode*)malloc(sizeof(*root));
    if (root == NULL) abort();

    root->item = item;
    root->left = root->right = NULL;
    root->height = 0;

    *pRoot = root;
    return 1;
  }

  // Compare with current node
  int comp = compF(item, root->item);

  if (comp < 0) {
    // Try to insert on the left
    if (_BSTreeAdd(&(root->left), compF, item) == 0) {
      // No success
      return 0;
    }

    // Unbalanced on the left ?
    if (_treeGetHeight(root->left) - _treeGetHeight(root->right) == 2) {
      if (compF(item, root->left->item) < 0) {
        _singleRotateWithLeftChild(pRoot);
      } else {
        _doubleRotateWithLeftChild(pRoot);
      }
    }
    _updateNodeHeight(root);
    return 1;
  } else if (comp > 0) {
    // Try to insert on the right
    if (_BSTreeAdd(&(root->right), compF, item) == 0) {
      return 0;
    }

    // Unbalanced on the right ?
    if (_treeGetHeight(root->right) - _treeGetHeight(root->left) == 2) {
      if (compF(item, root->right->item) > 0) {
        _singleRotateWithRightChild(pRoot);
      } else {
        _doubleRotateWithRightChild(pRoot);
      }
    }
    _updateNodeHeight(root);
    return 1;
  } else {  // (comp == 0)
    // Not allowed
    return 0;
  }
}

// Acrescenta um item à árvore, se for válido.
// Devolve 1 (sucesso) se conseguir acrescentar o item
// ou 0 (falha) se o item colide com algum que já esteja na árvore.
int BSTreeAdd(BSTree* header, void* item) {
  assert(header != NULL);

  if (_BSTreeAdd(&(header->root), header->compare, item) == 1) {
    header->numNodes++;
    return 1;
  }
  return 0;
}

// Funcao auxiliar

static void _deleteNextNode(struct _BSTreeNode** pRoot, void** pItem) {
  if ((*pRoot)->left == NULL) {
    // FOUND IT
    struct _BSTreeNode* auxPointer = *pRoot;
    *pItem = auxPointer->item;
    *pRoot = auxPointer->right;
    free(auxPointer);
  } else {
    _deleteNextNode(&((*pRoot)->left), pItem);
    _updateNodeHeight(*pRoot);  // FALTAVA!
  }
}

// This internal function removes the node pointed to by *pPointer.
// Note that pPointer is the address of a variable that points to the node to
// be removed. When it removes the node, it also sets that variable to NULL.
// That variable is either the root field of the _BSTreeHeader struct or
// the left or the right field of the parent _BSTreeNode struct.
// (Pointing to fields inside a struct is something you cannot do in Java.)
static void _removeNode(struct _BSTreeNode** pPointer) {
  struct _BSTreeNode* nodePointer = *pPointer;

  if ((nodePointer->left == NULL) && (nodePointer->right == NULL)) {
    /* A LEAF node */
    free(nodePointer);  // FREE it and
    *pPointer = NULL;   // SET field in parent node (or header) to NULL
  } else if (nodePointer->left == NULL) {
    /* It has only a RIGHT sub-tree */
    *pPointer = nodePointer->right;
    free(nodePointer);
  } else if (nodePointer->right == NULL) {
    /* It has only a LEFT sub-tree */
    *pPointer = nodePointer->left;
    free(nodePointer);
  } else {
    /* Node has TWO CHILDREN */
    /* Replace its item with the item of the next node in-order */
    /* And remove that node */
    _deleteNextNode(&(nodePointer->right), &(nodePointer->item));
  }
}

static int _treeRemoveItem(struct _BSTreeNode** pRoot, const void* item,
                           compFunc compare) {
  struct _BSTreeNode* root = *pRoot;

  if (root == NULL) {
    return 0;
  }
  int result;
  int cmp = compare(item, root->item);
  if (cmp < 0) {
    result = _treeRemoveItem(&(root->left), item, compare);
  } else if (cmp > 0) {
    result = _treeRemoveItem(&(root->right), item, compare);
  } else {  // (cmp == 0)
    _removeNode(pRoot);
    result = 1;
  }
  if (result) {
    _balanceNode(pRoot);  // Balance at this node
  }
  return result;
}

int BSTreeRemove(BSTree* header, const void* item) {
  assert(header != NULL);

  if (_treeRemoveItem(&(header->root), item, header->compare) == 1) {
    header->numNodes--;
    return 1;
  }
  return 0;
}

// Funcao interna necessaria para a funcao BSTreeGetItems

// Percorre a arvore recursivamente e acrescenta os itens a FILA
static void _BSTreeAddItems(const struct _BSTreeNode* p, Queue* q) {
  if (p == NULL) {
    return;
  }

  // Complete a função
  _BSTreeAddItems(p->left, q);
  QueueEnqueue(q, p->item);
  _BSTreeAddItems(p->right, q);
}
// Q: What kind of tree traversal is this function doing?
// 1) Breadth-first,
// 2) Depth-first pre-order,
// 3) Depth-first in-order or
// 4) Depth-first post-order?
// A: Depth-first in-order
// Q: Is this the required order here? Why?
// A: Sim, porque a funcao BSTreeGetItems quer devolver uma arvore ordenada
//    logo a ordem "esquerda - raiz - direita" (in-order) tem que ser respeitada

// Devolve uma FILA com os itens da árvore ordenados
// ou uma FILA VAZIA se a árvore estiver vazia.
// Funcao ALOCA MEMÓRIA para a FILA, que terá de ser libertada
// pela funcao chamadora.
Queue* BSTreeGetItems(const BSTree* header) {
  assert(header != NULL);

  Queue* itemsQ = QueueCreate();
  assert(itemsQ != NULL);
  _BSTreeAddItems(header->root, itemsQ);
  return itemsQ;
}

// Tree Visualization

static void _treeView(struct _BSTreeNode* root, int level, const char* edge,
                      printFunc print) {
  if (root == NULL) {
    printf("%*s%s\n", 4 * level, edge, "#");  // # represents NULL pointer
  } else {
    _treeView(root->left, level + 1, "/", print);
    printf("%*s[%d]", 4 * level, edge, root->height);
    print(root->item);
    printf("\n");
    _treeView(root->right, level + 1, "\\", print);
  }
}

void BSTreeView(const BSTree* header) {
  _treeView(header->root, 0, ":", header->print);  // : marks the root
  printf("numNodes: %d\n", header->numNodes);
}

// Tests - Auxiliary Functions

static int _BSTreeCountNodes(const struct _BSTreeNode* root) {
  if (root == NULL) {
    return 0;
  }
  return 1 + _BSTreeCountNodes(root->left) + _BSTreeCountNodes(root->right);
}



static int _BSTreeCheckNodesHeight(const struct _BSTreeNode* root) {
  if (root == NULL) {
    return 1;
  }
  if (_BSTreeCheckNodesHeight(root->left) == 0) {
    return 0;
  }
  if (_BSTreeCheckNodesHeight(root->right) == 0) {
    return 0;
  }
  return root->height == _treeGetHeightREC(root);
  // ISTO É INEFICIENTE!
}

static int _BSTreeIsBalanced(const struct _BSTreeNode* root) {
  if (root == NULL) {
    return 1;
  }
  if (_BSTreeIsBalanced(root->left) == 0) {
    return 0;
  }
  if (_BSTreeIsBalanced(root->right) == 0) {
    return 0;
  }
  // Fator de equilíbrio na raiz
  int F = _treeGetHeight(root->right) - _treeGetHeight(root->left);
  int ok = (-1 <= F && F <= 1);
  return ok;
}

int _isBST(struct _BSTreeNode* root, compFunc compF,
           struct _BSTreeNode** previous) {
  if (root == NULL) {
    return 1;
  }

  // IN_ORDER TRAVERSAL
  if (_isBST(root->left, compF, previous) == 0) {
    return 0;
  }

  // Allow only distinct valued nodes
  if (*previous != NULL && compF(root->item, (*previous)->item) <= 0) {
    return 0;
  }
  // Update previous to current
  *previous = root;

  return _isBST(root->right, compF, previous);
}

//
// NEW
//
int BSTreeIsBST(const BSTree* header) {
  struct _BSTreeNode* p = NULL;
  return _isBST(header->root, header->compare, &p);
}

void BSTreeTestInvariants(const BSTree* header) {
  assert(header->numNodes >= 0);
  // check equivalence: numNodes==0 <=> root==NULL
  assert((header->numNodes == 0) == (header->root == NULL));
  // check equivalence: numNodes>0 <=> root!=NULL
  assert((header->numNodes > 0) == (header->root != NULL));
  // check equivalence: numNodes==0 <=> height = -1
  assert((header->numNodes == 0) == (BSTreeGetHeight(header) == -1));
  // check equivalence: numNodes==1 <=> height = 0
  assert((header->numNodes == 1) == (BSTreeGetHeight(header) == 0));
  // check equivalence: numNodes>1 <=> height > 0
  assert((header->numNodes > 1) == (BSTreeGetHeight(header) > 0));
  // Number of nodes ?
  assert(header->numNodes == _BSTreeCountNodes(header->root));
  // Height of each node ?
  assert((header->root == NULL) ||
         (_BSTreeCheckNodesHeight(header->root) == 1));
  // Is BST ?
  assert(BSTreeIsBST(header) == 1);
  // Is BALANCED ?
  assert(_BSTreeIsBalanced(header->root) == 1);
}
