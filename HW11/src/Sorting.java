import java.util.Comparator;
import java.util.LinkedList;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {
    public static void main(String[] args) {
        Integer[] arr = {3,2,6,5,1,4,7,8,9};

        Comparator<Integer> comp = Integer::compare;

        mergeSort(arr, comp);
        //lsdRadixSort(arr);

        for(int n : arr) {
            System.out.print(n + " ");
        }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(arr.length <= 1) {
            return;
        }
        int middle = arr.length / 2;
        T[] leftArray = (T[]) new Object[middle];
        T[] rightArray = (T[]) new Object[arr.length - middle];

        int i = 0;
        int j = 0;

        for(; i < arr.length; i++) {
            if(i < middle) {
                leftArray[i] = arr[i];
            }
            else {
                rightArray[j] = arr[i];
                j++;
            }
        }
        mergeSort(leftArray, comparator);
        mergeSort(rightArray, comparator);

        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;
        int z = 0;
        int x = 0;
        int y = 0;

        while(x < leftSize && y < rightSize) {
            if(comparator.compare(leftArray[x], rightArray[y]) < 0) {
                arr[z] = leftArray[x];
                z++;
                x++;
            }
            else {
                arr[z] = rightArray[y];
                z++;
                y++;
            }
        }
        while(x < leftSize) {
            arr[z] = leftArray[x];
            z++;
            x++;
        }
        while(y < rightSize) {
            arr[z] = rightArray[y];
            z++;
            y++;
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        LinkedList<Integer>[] list = new LinkedList[19];
        for(int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
        int base = 10;
        int a = 1;
        boolean isTrue = true;
        while(isTrue == true) {
            isTrue = false;
            for(int n : arr) {
                int listing = n / a;
                if(listing / 10 != 0) {
                    isTrue = true;
                }
                if(list[listing % base + 9] == null) {
                    list[listing % base + 9] = new LinkedList<>();
                }
                list[listing % base + 9].add(n);
            }
            int index = 0;
            for(LinkedList<Integer> i : list) {
                if(i != null) {
                    for(int num : i) {
                        arr[index++] = num;
                    }
                    i.clear();
                }
            }
            a *= 10;
        }
    }
}