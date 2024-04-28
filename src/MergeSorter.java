import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Merge Sort algorithm for sorting lists of elements of type T.
 * This class implements the Sorter interface.
 *
 * @param <T> the type of elements to be sorted, must implement Comparable
 */
public class MergeSorter<T extends Comparable<T>> implements ISorter<T> {

    /**
     * Default constructor for the MergeSorter class.
     */
    public MergeSorter() {

    }

    /**
     * Sorts a list of elements using the Merge Sort algorithm.
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

        mergeSort(array, 0, array.length - 1);

        return backToList(array);
    }

    /**
     * Performs the merge operation in the Merge Sort algorithm.
     *
     * @param arr the array of elements to be merged
     * @param l   the left index of the subarray
     * @param m   the middle index of the subarray
     * @param r   the right index of the subarray
     */
    void merge(T arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        T L[] = (T[]) new Comparable[n1];
        T R[] = (T[]) new Comparable[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Performs the recursive merge sort algorithm on an array of elements.
     *
     * @param arr the array of elements to be sorted
     * @param l   the left index of the subarray
     * @param r   the right index of the subarray
     */
    void mergeSort(T arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
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
}
