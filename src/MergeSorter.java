import java.util.ArrayList;
import java.util.List;

public class MergeSorter<T extends Comparable<T>> implements ISorter<T> {
    private long operationCount; // Counter for operations

    public List<T> sortArray(List<T> array) {
        operationCount = 0; // Reset operation count before sorting
        mergeSort(array, 0, array.size() - 1);
        return array;
    }

    private void mergeSort(List<T> array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursive calls for left and right halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    private void merge(List<T> array, int left, int mid, int right) {
        List<T> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            operationCount++; // Increment operation count for each comparison
            if (array.get(i).compareTo(array.get(j)) <= 0) {
                temp.add(array.get(i));
                i++;
            } else {
                temp.add(array.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(array.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(array.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            array.set(left + k, temp.get(k));
            operationCount++; // Increment operation count for each swap
        }
    }

    public long getOperationCount() {
        return operationCount;
    }
}
