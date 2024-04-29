import java.util.ArrayList;
import java.util.List;

public class InsertionSorter<T extends Comparable<T>> implements ISorter<T> {
    private long operationCount; // Counter for operations

    /**
     * Default constructor for the InsertionSorter class.
     */
    public InsertionSorter() {
        operationCount = 0; // Initialize operation count
    }

    /**
     * Sorts a list of elements using the Insertion Sort algorithm.
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

        sort(array);

        return backToList(array);
    }

    /**
     * Helper method to perform the Insertion Sort algorithm on an array of elements.
     *
     * @param arr the array of elements to be sorted
     */
    void sort(T arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
                operationCount++; // Increment operation count for each comparison
            }
            arr[j + 1] = key;
            operationCount++; // Increment operation count for each swap
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
