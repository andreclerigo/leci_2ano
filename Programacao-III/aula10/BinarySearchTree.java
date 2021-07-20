package aula10;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {

    private static class BSTNode<T> {
        T element;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T element) {
            this.element = element;
            left = right = null;
        }
    }

    private BSTNode<T> root;
    private int numNodes;

    public BinarySearchTree() {
        root = null;
        numNodes = 0;
    }

    public int size() {
        return numNodes;
    }

    public void insert(T value) {
        root = insert(value, root);
        numNodes++;
    }

    private BSTNode<T> insert(T value, BSTNode<T> node) {
        if (node == null) {
            node = new BSTNode<>(value);
        } else if (node.element.compareTo(value) > 0) {
            if (node.left == null) {
                node.left = new BSTNode<>(value);
            } else {
                insert(value, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new BSTNode<>(value);
            } else {
                insert(value, node.right);
            }
        }

        return node;
    }

    public void remove(T value) {
        if (contains(value)) {
            root = remove(value, root);
            numNodes--;
        }
    }
    
    private BSTNode<T> remove(T value, BSTNode<T> node) {
        if (node.element.compareTo(value) > 0) {
            return node.left = remove(value, node.left);
        } else if (node.element.compareTo(value) < 0) {
            return node.right = remove(value, node.right);
        } else {
            if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                node = insert(node.left.element, node.right);
            }

            return node;
        }
    }

    public boolean contains(T value) {
        return valueOf(find(value, root)) != null;
    }
    private T valueOf(BSTNode<T> node) {
        return node != null ? node.element : null;
    }
    private BSTNode<T> find(T value, BSTNode<T> node) {
        if (node == null) return null;
        if (node.element.compareTo(value) == 0) {
            return node;
        } else if (node.element.compareTo(value) > 0){
            return find(value, node.left);
        } else {
            return find(value, node.right);
        }
    }

    public void clear() {
        root = null;
        numNodes = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final Stack<BSTNode<T>> branches = new Stack<>();
            {
                BSTNode<T> node = root;
                 while (node != null) {
                     branches.push(node);
                     node = node.left;
                 }
            }
            @Override
            public boolean hasNext() {
                return !branches.isEmpty();
            }

            @Override
            public T next() {
                BSTNode<T> node = branches.pop();
                T value = node.element;

                if (node.right != null) {
                    node = node.right;
                    while (node != null) {
                        branches.push(node);
                        node = node.left;
                    }
                }

                return value;
            }
        };
    }
}
