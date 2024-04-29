import java.util.ArrayList;
import java.util.List;

public class QuickSorter<T extends Comparable<T>> implements ISorter<T> {
    private long operationCount; // Counter for operations

    /**
     * Default constructor for the QuickSorter class.
     */
    public QuickSorter() {
        operationCount = 0; // Initialize operation count
    }

    /**
     * Sorts a list of elements using the Quick Sort algorithm.
     *
     * @param list the list of elements to be sorted
     * @return a sorted list of elements
     * @throws IllegalArgumentException if the input list is empty
     */
    @Override
    public List<T> sortArray(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Cannot sort an empty list.");
        }
        T[] array = convertToArray(list);
        quickSort(array, 0, array.length - 1);
        return backToList(array);
    }

    /**
     * Swaps two elements in an array and increments the operation count.
     *
     * @param array the array in which elements are to be swapped
     * @param i     the index of the first element
     * @param j     the index of the second element
     */
    void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        operationCount++; // Increment operation count for each swap
    }

    /**
     * Chooses a pivot and partitions the array based on the pivot for the Quick Sort algorithm.
     *
     * @param array the array to be partitioned
     * @param low   the lower bound of the partition
     * @param high  the upper bound of the partition
     * @return the index of the pivot element after partitioning
     */
    int partition(T[] array, int low, int high) {
        T pivot = array[low + (high - low) / 2]; // Choosing median-of-three as the pivot
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
                operationCount++; // Increment operation count for each comparison
            } while (array[i].compareTo(pivot) < 0);

            do {
                j--;
                operationCount++; // Increment operation count for each comparison
            } while (array[j].compareTo(pivot) > 0);

            if (i >= j) {
                return j;
            }

            swap(array, i, j);
        }
    }

    /**
     * Recursively sorts a portion of an array using the Quick Sort algorithm.
     *
     * @param array the array to be sorted
     * @param low   the lower bound of the array to be sorted
     * @param high  the upper bound of the array to be sorted
     */
    void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex);
            quickSort(array, partitionIndex + 1, high); // Exclude partitionIndex itself
        }
    }

    /**
     * Converts a list of elements into an array of elements.
     *
     * @param list the list of elements to be converted
     * @return an array of elements
     */
    private T[] convertToArray(List<T> list) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) list.toArray(new Comparable[0]);
        return array;
    }

    /**
     * Converts an array of elements back into a list of elements.
     *
     * @param array the array of elements to be converted
     * @return a list of elements
     */
    private List<T> backToList(T[] array) {
        List<T> result = new ArrayList<>();
        for (T element : array) {
            result.add(element);
        }
        return result;
    }

    public long getOperationCount() {
        return operationCount;
    }
}
