import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SorterTests {

    @Test
    void testAdd() {
        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new InsertionSorter<Integer>());
        sorterList.add(5);
        sorterList.add(3);
        sorterList.add(8);

        List<Integer> list = sorterList.getList();
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(5, list.get(0));
        Assertions.assertEquals(3, list.get(1));
        Assertions.assertEquals(8, list.get(2));
    }

    @Test
    void testSort() {
        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new MergeSorter<Integer>());
        sorterList.add(5);
        sorterList.add(3);
        sorterList.add(8);

        List<Integer> sortedList = sorterList.sort();
        Assertions.assertEquals(3, sortedList.size());
        Assertions.assertEquals(3, sortedList.get(0));
        Assertions.assertEquals(5, sortedList.get(1));
        Assertions.assertEquals(8, sortedList.get(2));
    }

    @Test
    void testClear() {
        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new QuickSorter<Integer>());
        sorterList.add(5);
        sorterList.add(3);
        sorterList.add(8);

        sorterList.clear();
        List<Integer> list = sorterList.getList();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void testEmptyListSort() {
        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new QuickSorter<Integer>());

        Assertions.assertThrows(IllegalArgumentException.class, sorterList::sort);
    }

    @Test
    void testQuickSort() {
        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new QuickSorter<Integer>());
        sorterList.add(5);
        sorterList.add(3);
        sorterList.add(8);
        sorterList.add(1);
        sorterList.add(2);
        sorterList.add(7);
        sorterList.add(4);

        List<Integer> sortedList = sorterList.sort();
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 7, 8);
        Assertions.assertEquals(expectedList, sortedList);
    }

    @Test
    void testMergeSort() {
        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new MergeSorter<Integer>());
        sorterList.add(5);
        sorterList.add(3);
        sorterList.add(8);
        sorterList.add(1);
        sorterList.add(2);
        sorterList.add(7);
        sorterList.add(4);

        List<Integer> sortedList = sorterList.sort();
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 7, 8);
        Assertions.assertEquals(expectedList, sortedList);
    }

    @Test
    void testInsertionSort() {
        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new InsertionSorter<Integer>());
        sorterList.add(5);
        sorterList.add(3);
        sorterList.add(8);
        sorterList.add(1);
        sorterList.add(2);
        sorterList.add(7);
        sorterList.add(4);

        List<Integer> sortedList = sorterList.sort();
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 7, 8);
        Assertions.assertEquals(expectedList, sortedList);
    }

    @Test
    void testEmptyListQuickSort() {
        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new QuickSorter<Integer>());

        Assertions.assertThrows(IllegalArgumentException.class, sorterList::sort);
    }

    @Test
    void testEmptyListMergeSort() {
        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new MergeSorter<Integer>());

        Assertions.assertThrows(IllegalArgumentException.class, sorterList::sort);
    }

    @Test
    void testEmptyListInsertionSort() {
        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new InsertionSorter<Integer>());

        Assertions.assertThrows(IllegalArgumentException.class, sorterList::sort);
    }
}
