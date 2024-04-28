import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * SorterTests runs tests against my sorter implementations
 */
public class SorterTests {

    @Test
    void testQuickSort() {
        QuickSorter sorter = new QuickSorter();
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2, 7, 4));
        List<Integer> sortedList = sorter.sortArray(unsortedList);
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 7, 8);
        Assertions.assertEquals(expectedList, sortedList);
    }

    @Test
    void testMergeSort() {
        MergeSorter sorter = new MergeSorter();
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2, 7, 4));
        List<Integer> sortedList = sorter.sortArray(unsortedList);
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 7, 8);
        Assertions.assertEquals(expectedList, sortedList);
    }

    @Test
    void testInsertionSort() {
        InsertionSorter sorter = new InsertionSorter();
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2, 7, 4));
        List<Integer> sortedList = sorter.sortArray(unsortedList);
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 7, 8);
        Assertions.assertEquals(expectedList, sortedList);
    }

    @Test
    void testEmptyListQuickSort() {
        QuickSorter sorter = new QuickSorter();
        List<Integer> emptyList = Collections.emptyList();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sorter.sortArray(emptyList);
        });
    }

    @Test
    void testEmptyListMergeSort() {
        MergeSorter sorter = new MergeSorter();
        List<Integer> emptyList = Collections.emptyList();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sorter.sortArray(emptyList);
        });
    }

    @Test
    void testEmptyListInsertionSort() {
        InsertionSorter sorter = new InsertionSorter();
        List<Integer> emptyList = Collections.emptyList();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sorter.sortArray(emptyList);
        });
    }
}
