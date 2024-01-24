import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("error");
        }
        if (size + 1 >= backingArray.length) {
            resize();
        }
        size = size + 1;
        int index = size;
        backingArray[index] = data;

        while(index > 1 && backingArray[index].compareTo(backingArray[index / 2]) < 0) {
            T temp = backingArray[index];
            backingArray[index] = backingArray[index / 2];
            backingArray[index / 2] = temp;
            index = index / 2;
        }
    }
    private void resize() {
        T[] newBackingArray = (T[]) new Comparable[backingArray.length * 2];
        int count = 0;
        for(T n : backingArray) {
            newBackingArray[count] = n;
            count++;
        }
        backingArray = newBackingArray;
    }

    public void print() {
        for(T n : backingArray) {
            System.out.print(n + " ");
        }
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(size == 0) {
            throw new NoSuchElementException("error");
        }
        T min = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        minHeapify(1);
        return min;
    }
    private void minHeapify(int index) {
        int left, right;
        left = 2 * index;
        right = 2 * index + 1;

        int smallest = index;
        if(left < this.size && backingArray[left].compareTo(backingArray[smallest]) < 0) {
            smallest = left;
        }
        if(right < this.size && backingArray[right].compareTo(backingArray[smallest]) < 0) {
            smallest = right;
        }
        if(smallest != index) {
            T t = backingArray[smallest];
            backingArray[smallest] = backingArray[index];
            backingArray[index] = t;

            minHeapify(smallest);
        }
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String[] args) {
        MinHeap<Integer> a = new MinHeap<>();
        int[] arr = {10,7,11};

        a.add(arr[0]);
        a.add(arr[1]);
        a.add(arr[2]);
        //a.add(arr[3]);
        //a.add(arr[4]);
        //a.add(arr[5]);
        //a.add(arr[6]);
        //a.add(arr[7]);
        //a.add(arr[8]);
        //a.add(arr[9]);
        //a.add(arr[10]);

        //a.remove();

        a.print();
    }
}