import org.w3c.dom.Node;

import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) {
            throw new IllegalArgumentException("error");
        } else {
            this.root = addHelper(this.root, data);
        }
    }
    private BSTNode<T> addHelper(BSTNode<T> root, T data) {
        if(root == null) {
            return new BSTNode<>(data);
        }
        int intData = data.compareTo(root.getData());
        if(intData == 0) {
            return root;
        } else if(intData < 0) {
            root.setLeft(addHelper(root.getLeft(), data));
        } else {
            root.setRight(addHelper(root.getRight(), data));
        }
        return root;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("null");
        }
        if (!contains(data)) {
            throw new NoSuchElementException("none");
        }
        T removed = get(data);
        root = removeNode(data, root);
        size--;
        return removed;

    }

    private BSTNode<T> removeNode(T data, BSTNode<T> node) {
        if (node == null) {
            return null;
        }
        int indData = data.compareTo(node.getData());
        if (indData <= -1) {
            node.setLeft(removeNode(data, node.getLeft()));
        } else if (indData >= 1) {
            node.setRight(removeNode(data, node.getRight()));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                node.setData(getSuccessor(node.getRight()));
                node.setRight(removeNode(node.getData(), node.getRight()));
            }
        }
        return node;
    }
    private T getSuccessor(BSTNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("error");
        }
        if (root == null) {
            throw new NoSuchElementException("error");
        }
        T n = search(data, root);
        if (n != null) {
            return n;
        } else {
            throw new NoSuchElementException("error");
        }
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
    public void display() {
        displayHelper(root);
    }
    public void displayHelper(BSTNode<T> root) {
        if(root != null) {
            displayHelper(root.getLeft());
            System.out.println(root.getData());
            displayHelper(root.getRight());
        }
    }


    public boolean contains(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("error");
        }
        if (root == null) {
            return false;
        }
        return (search(data, root) != null);
    }
    private T search(T data, BSTNode<T> current) {
        int compare = data.compareTo(current.getData());
        if (compare >= 1) {
            if (current.getRight() == null) {
                return null;
            } else {
                return search(data, current.getRight());
            }
        } else if (compare <= -1) {
            if (current.getLeft() == null) {
                return null;
            } else {
                return search(data, current.getLeft());
            }
        } else {
            return current.getData();
        }
    }
}