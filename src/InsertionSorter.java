import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Insertion Sort algorithm for sorting lists of elements of type T.
 * This class implements the Sorter interface.
 *
 * @param <T> the type of elements to be sorted, must implement Comparable
 */
public class InsertionSorter<T extends Comparable<T>> implements ISorter<T> {

    /**
     * Default constructor for the InsertionSorter class.
     */
    public InsertionSorter() {

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
            }
            arr[j + 1] = key;
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


//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Jacob Stone
// * @version 0414202401
// * Implementation of the Insertion Sort algorithm for sorting lists of Integers.
// * This class implements the ISorter interface.
// */
//public class InsertionSorter implements ISorter<Integer>{
//
//    /**
//     * Default constructor for the InsertionSorter class.
//     */
//    public InsertionSorter(){
//
//    }
//
//    /**
//     * Sorts a list of Integers using the Insertion Sort algorithm.
//     *
//     * @param list the list of Integers to be sorted
//     * @return a sorted list of Integers
//     * @throws IllegalArgumentException if the input list is empty
//     */
//    @Override
//    public List<Integer> sortArray(List<Integer> list) {
//        if (list.isEmpty()) {
//            throw new IllegalArgumentException("Cannot sort an empty list.");
//        }
//        int[] intArray = convertToArray(list);
//
//        sort(intArray);
//
//        return backToList(intArray);
//    }
//
//    /**
//     * Helper method to perform the Insertion Sort algorithm on an array of integers.
//     *
//     * @param arr the array of integers to be sorted
//     */
//    void sort(int arr[])
//    {
//        int n = arr.length;
//        for (int i = 1; i < n; ++i) {
//            int key = arr[i];
//            int j = i - 1;
//
//
//            while (j >= 0 && arr[j] > key) {
//                arr[j + 1] = arr[j];
//                j = j - 1;
//            }
//            arr[j + 1] = key;
//        }
//    }
//
//    /**
//     * Converts a list of Integers into an array of integers.
//     *
//     * @param integerList the list of Integers to be converted
//     * @return an array of integers
//     */
//    private int[] convertToArray(List<Integer> integerList) {
//        int[] arr = new int[integerList.size()];
//
//        for(int i = 0; i < arr.length; i++) {
//            arr[i] = integerList.get(i);
//        }
//
//        return arr;
//    }
//
//    /**
//     * Converts an array of integers back into a list of Integers.
//     *
//     * @param arr the array of integers to be converted
//     * @return a list of Integers
//     */
//    private List<Integer> backToList(int[] arr){
//        List<Integer> intList = new ArrayList<>();
//
//        for(int num : arr) {
//            intList.add(num);
//        }
//
//        return intList;
//    }
//}
