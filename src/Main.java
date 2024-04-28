//import java.text.DecimalFormat;
//import java.text.NumberFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
///**
// * @author Jacob Stone
// * @version 0412202401
// * The main class is the driver for the sorter implementations. For each type of sort (insertion, quick, merge)
// * it will receive a collection of 20k, 40k, 60k, 80k, and 100k then record the time it takes to sort them will be measured.
// */
//public class Main {
//    public static void main(String[] args) {
//
//        //random object and bounds
//        Random rand = new Random();
//        int maxVal = 500000;
//        int minVal = 0;
//
//        //create sorter objects
//        InsertionSorter is = new InsertionSorter();
//        QuickSorter qs = new QuickSorter();
//        MergeSorter ms = new MergeSorter();
//
//        SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new InsertionSorter<Integer>());
//
//        //make the collections
//        List<Integer> insertList = new ArrayList<>();
//        List<Integer> semiSortedInsert = new ArrayList<>();
//        List<Integer> semiSortedQuick = new ArrayList<>();
//        List<Integer> quickList = new ArrayList<>();
//        List<Integer> mergeList = new ArrayList<>();
//        List<Integer> semiSortedMerge = new ArrayList<>();
//
//        //populate lists for 20k sort
//        populateLists(insertList, quickList, mergeList, rand, 20000, maxVal, minVal);
//        loadSemiSortedData(semiSortedInsert, semiSortedQuick, semiSortedMerge, 20000);
//
//        //sort random data for 20k iteration
//        sortLists(insertList, mergeList, quickList, 20000, is, qs, ms, "random");
//        //sort semi-sorted data
//        sortLists(semiSortedInsert, semiSortedMerge, semiSortedQuick, 20000, is, qs, ms, "semi-sorted");
//        //sort sorted data, pass the lists from the initial sort, these should already be sorted
//        sortLists(insertList, mergeList, quickList, 20000, is, qs, ms, "sorted");
//
//
//        //clear, prep for 40k
//        clearLists(insertList, mergeList, quickList);
//        clearLists(semiSortedInsert, semiSortedMerge, semiSortedQuick);
//
//        //populate lists for 40k sort
//        populateLists(insertList, quickList, mergeList, rand, 40000, maxVal, minVal);
//        loadSemiSortedData(semiSortedInsert, semiSortedQuick, semiSortedMerge, 40000);
//
//
//        //sort random data for 40k iteration
//        sortLists(insertList, mergeList, quickList,40000, is, qs, ms, "random");
//        //sort semi-sorted data
//        sortLists(semiSortedInsert, semiSortedMerge, semiSortedQuick, 40000, is, qs, ms, "semi-sorted");
//        //sort sorted data, pass the lists from the initial sort, these should already be sorted
//        sortLists(insertList, mergeList, quickList, 40000, is, qs, ms, "sorted");
//
//
//        //clear, prep for 40k
//        clearLists(insertList, mergeList, quickList);
//        clearLists(semiSortedInsert, semiSortedMerge, semiSortedQuick);
//
//        //populate lists for 60k sort
//        populateLists(insertList, quickList, mergeList, rand, 60000, maxVal, minVal);
//        loadSemiSortedData(semiSortedInsert, semiSortedQuick, semiSortedMerge, 60000);
//
//        //sort random data for 60k iteration
//        sortLists(insertList, mergeList, quickList, 60000, is, qs, ms, "random");
//        //sort semi-sorted data
//        sortLists(semiSortedInsert, semiSortedMerge, semiSortedQuick, 60000, is, qs, ms, "semi-sorted");
//        //sort sorted data, pass the lists from the initial sort, these should already be sorted
//        sortLists(insertList, mergeList, quickList, 60000, is, qs, ms, "sorted");
//
//
//        //clear, prep for 80k
//        clearLists(insertList, mergeList, quickList);
//        clearLists(semiSortedInsert, semiSortedMerge, semiSortedQuick);
//
//        //populate lists for 80k sort
//        populateLists(insertList, quickList, mergeList, rand, 80000, maxVal, minVal);
//        loadSemiSortedData(semiSortedInsert, semiSortedQuick, semiSortedMerge, 80000);
//
//
//
//        //sort random data for 80k iteration
//        sortLists(insertList, mergeList, quickList, 80000, is, qs, ms, "random");
//        //sort semi-sorted data
//        sortLists(semiSortedInsert, semiSortedMerge, semiSortedQuick, 80000, is, qs, ms, "semi-sorted");
//        //sort sorted data, pass the lists from the initial sort, these should already be sorted
//        sortLists(insertList, mergeList, quickList, 20000, is, qs, ms, "sorted");
//
//
//
//        //clear, prep for 100k
//        clearLists(insertList, mergeList, quickList);
//        clearLists(semiSortedInsert, semiSortedMerge, semiSortedQuick);
//
//        //populate lists for 100k sort
//        populateLists(insertList, quickList, mergeList, rand, 100000, maxVal, minVal);
//        loadSemiSortedData(semiSortedInsert, semiSortedQuick, semiSortedMerge, 100000);
//
//
//        //sort random data for 100k iteration
//        sortLists(insertList, mergeList, quickList, 100000, is, qs, ms, "random");
//        //sort semi-sorted data
//        sortLists(semiSortedInsert, semiSortedQuick, semiSortedMerge, 100000, is, qs, ms, "semi-sorted");
//        //sort sorted data, pass the lists from the initial sort, these should already be sorted
//        sortLists(insertList, mergeList, quickList, 20000, is, qs, ms, "sorted");
//
//        System.out.println("All sorts have finished...\nGoodbye!");
//    }
//
//    /**
//     * clearLists() is used to remove data from the lists, priming them for the next load.
//     * @param insertList the insertion sort list
//     * @param mergeList the merge sort list
//     * @param quickList the quicksort list
//     */
//    public static void clearLists(List<Integer> insertList, List<Integer> mergeList, List<Integer> quickList) {
//        insertList.clear();
//        mergeList.clear();
//        quickList.clear();
//    }
//
//    /**
//     *  populateLists() is used to load numbers into the list.
//     * @param insertList the list for the insertion sort
//     * @param mergeList the list for the merge sort
//     * @param quickList the list for the quick sort
//     * @param rand the Random object used to generate the random numbers
//     * @param listSize the size of the list iteration (20k, 40k, 60k, etc.)
//     * @param maxVal the upper bound of the values within the list
//     * @param minVal the lower bound of the values within the list
//     */
//    public static void populateLists(List<Integer> insertList, List<Integer> mergeList, List<Integer> quickList,
//                              Random rand, int listSize, int maxVal, int minVal) {
//
//        for(int i = 0; i < listSize; i++) {
//            int randomNumber = rand.nextInt(maxVal - minVal + 1) + minVal;
//            insertList.add(randomNumber);
//            quickList.add(randomNumber);
//            mergeList.add(randomNumber);
//        }
//    }
//
//    /**
//     * sortRandomLists() will sort the collections containing randomly generated numbers
//     * @param insertList the list to be sorted via Insertion sort
//     * @param mergeList the list to be sorted via Merge sort
//     * @param quickList the list to be sorted via Quick sort
//     * @param collectionSize the size of the sort iteration (20k, 40k, 60k, 80k, 100k)
//     * @param is InsertionSorter
//     * @param qs QuickSorter
//     * @param ms MergeSorter
//     */
//    public static void sortLists(List<Integer> insertList, List<Integer> mergeList, List<Integer>
//            quickList, int collectionSize, InsertionSorter is, QuickSorter qs, MergeSorter ms, String dataType){
//
//        System.out.println("Starting insertion sort on " + collectionSize + " " + dataType + " collection...");
//        long start = System.currentTimeMillis();
//        is.sortArray(insertList);
//        long end = System.currentTimeMillis();
//        NumberFormat format = new DecimalFormat("#0.00000");
//        System.out.println("Execution time for " + collectionSize + " " + dataType + " insertion sort is: "
//                + format.format((end - start) / 1000d) + " seconds");
//
//        System.out.println("\nStarting merge sort on " + collectionSize + " " + dataType + " collection...");
//        start = System.currentTimeMillis();
//        ms.sortArray(mergeList);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time for " + collectionSize + " " + dataType + " element merge sort is: "
//                + format.format((end - start) / 1000d) + " seconds");
//
//        System.out.println("\nStarting quick sort on " + collectionSize + " " + dataType + " collection...");
//        start = System.currentTimeMillis();
//        qs.sortArray(quickList);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time for " + collectionSize + " " + dataType + " quick sort is: "
//                + format.format((end - start) / 1000d) + " seconds\n");
//    }
//
//    /**
//     *
//     * This method will load a collection of semi-sorted data
//     * @param semiSortedInsert the list that will be used for an insertion sort
//     * @param semiSortedQuick the list that will be used for a quick sort
//     * @param semiSortedMerge the list that will be used for a merge sort
//     * @param collectionSize the size of the collections
//     */
//    public static void loadSemiSortedData(List<Integer> semiSortedInsert, List<Integer> semiSortedQuick,
//                                          List<Integer> semiSortedMerge, int collectionSize){
//        for(int i = 0; i < collectionSize; i++){
//            if(i % 1000 == 0){
//                semiSortedInsert.add(i,i - 5);
//                semiSortedMerge.add(i, - 5);
//                semiSortedQuick.add(i, - 5);
//            }
//            else{
//                semiSortedInsert.add(i);
//                semiSortedMerge.add(i);
//                semiSortedQuick.add(i);
//            }
//        }
//    }
//}

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //fields for random data
        Random rand = new Random();
        int maxVal = 500000;
        int minVal = 0;

        //make sorters
        InsertionSorter<Integer> is = new InsertionSorter<Integer>();
        QuickSorter<Integer> qs = new QuickSorter<Integer>();
        MergeSorter<Integer> ms = new MergeSorter<Integer>();


        //SorterList<Integer, ISorter<Integer>> sorterList = new SorterList<>(new InsertionSorter<Integer>());

        //make the lists that will be used
        SorterList<Integer, ISorter<Integer>> insertList = new SorterList<>(is);
        SorterList<Integer, ISorter<Integer>> semiSortedInsert = new SorterList<>(is);
        SorterList<Integer, ISorter<Integer>> semiSortedQuick = new SorterList<>(qs);
        SorterList<Integer, ISorter<Integer>> quickList = new SorterList<>(qs);
        SorterList<Integer, ISorter<Integer>> mergeList = new SorterList<>(ms);
        SorterList<Integer, ISorter<Integer>> semiSortedMerge = new SorterList<>(ms);

        //prep for 20k
        populateLists(insertList, quickList, mergeList, rand, 20000, maxVal, minVal);
        loadSemiSortedData(semiSortedInsert, semiSortedQuick, semiSortedMerge, 20000);

        //sort 20k
        sortLists(insertList, mergeList, quickList, 20000, is, qs, ms, "random");
        sortLists(semiSortedInsert, semiSortedMerge, semiSortedQuick, 20000, is, qs, ms, "semi-sorted");
        sortLists(insertList, mergeList, quickList, 20000, is, qs, ms, "sorted");

        //clear 20k
        clearLists(insertList, mergeList, quickList);
        clearLists(semiSortedInsert, semiSortedMerge, semiSortedQuick);

        //prep for 40k
        populateLists(insertList, quickList, mergeList, rand, 40000, maxVal, minVal);
        loadSemiSortedData(semiSortedInsert, semiSortedQuick, semiSortedMerge, 40000);

        //sort 40k
        sortLists(insertList, mergeList, quickList, 40000, is, qs, ms, "random");
        sortLists(semiSortedInsert, semiSortedMerge, semiSortedQuick, 40000, is, qs, ms, "semi-sorted");
        sortLists(insertList, mergeList, quickList, 40000, is, qs, ms, "sorted");

        //clear 40k
        clearLists(insertList, mergeList, quickList);
        clearLists(semiSortedInsert, semiSortedMerge, semiSortedQuick);

        //prep for 60k
        populateLists(insertList, quickList, mergeList, rand, 60000, maxVal, minVal);
        loadSemiSortedData(semiSortedInsert, semiSortedQuick, semiSortedMerge, 60000);

        //sort 60k
        sortLists(insertList, mergeList, quickList, 60000, is, qs, ms, "random");
        sortLists(semiSortedInsert, semiSortedMerge, semiSortedQuick, 60000, is, qs, ms, "semi-sorted");
        sortLists(insertList, mergeList, quickList, 60000, is, qs, ms, "sorted");

        //clear 60k
        clearLists(insertList, mergeList, quickList);
        clearLists(semiSortedInsert, semiSortedMerge, semiSortedQuick);

        //prep for 80k
        populateLists(insertList, quickList, mergeList, rand, 80000, maxVal, minVal);
        loadSemiSortedData(semiSortedInsert, semiSortedQuick, semiSortedMerge, 80000);

        //sort 80k
        sortLists(insertList, mergeList, quickList, 80000, is, qs, ms, "random");
        sortLists(semiSortedInsert, semiSortedMerge, semiSortedQuick, 80000, is, qs, ms, "semi-sorted");
        sortLists(insertList, mergeList, quickList, 80000, is, qs, ms, "sorted");

        //clear 80k
        clearLists(insertList, mergeList, quickList);
        clearLists(semiSortedInsert, semiSortedMerge, semiSortedQuick);

        //prep for 100k
        populateLists(insertList, quickList, mergeList, rand, 100000, maxVal, minVal);
        loadSemiSortedData(semiSortedInsert, semiSortedQuick, semiSortedMerge, 100000);

        //sort 100k
        sortLists(insertList, mergeList, quickList, 80000, is, qs, ms, "random");
        sortLists(semiSortedInsert, semiSortedMerge, semiSortedQuick, 80000, is, qs, ms, "semi-sorted");
        sortLists(insertList, mergeList, quickList, 80000, is, qs, ms, "sorted");

        System.out.println("All sorts have finished...\nGoodbye!");
    }

    public static void clearLists(SorterList<Integer, ISorter<Integer>> insertList,
                                  SorterList<Integer, ISorter<Integer>> mergeList,
                                  SorterList<Integer, ISorter<Integer>> quickList) {
        insertList.clear();
        mergeList.clear();
        quickList.clear();
    }

    public static void populateLists(SorterList<Integer, ISorter<Integer>> insertList,
                                     SorterList<Integer, ISorter<Integer>> quickList,
                                     SorterList<Integer, ISorter<Integer>> mergeList,
                                     Random rand, int listSize, int maxVal, int minVal) {

        for(int i = 0; i < listSize; i++) {
            int randomNumber = rand.nextInt(maxVal - minVal + 1) + minVal;
            insertList.add(randomNumber);
            quickList.add(randomNumber);
            mergeList.add(randomNumber);
        }
    }

    public static void sortLists(SorterList<Integer, ISorter<Integer>> insertList,
                                 SorterList<Integer, ISorter<Integer>> mergeList,
                                 SorterList<Integer, ISorter<Integer>> quickList,
                                 int collectionSize, InsertionSorter is, QuickSorter qs, MergeSorter ms,
                                 String dataType){

        System.out.println("Starting insertion sort on " + collectionSize + " " + dataType + " collection...");
        long start = System.currentTimeMillis();
        insertList.sort();
        long end = System.currentTimeMillis();
        NumberFormat format = new DecimalFormat("#0.00000");
        System.out.println("Execution time for " + collectionSize + " " + dataType + " insertion sort is: "
                + format.format((end - start) / 1000d) + " seconds");

        System.out.println("\nStarting merge sort on " + collectionSize + " " + dataType + " collection...");
        start = System.currentTimeMillis();
        mergeList.sort();
        end = System.currentTimeMillis();
        System.out.println("Execution time for " + collectionSize + " " + dataType + " element merge sort is: "
                + format.format((end - start) / 1000d) + " seconds");

        System.out.println("\nStarting quick sort on " + collectionSize + " " + dataType + " collection...");
        start = System.currentTimeMillis();
        quickList.sort();
        end = System.currentTimeMillis();
        System.out.println("Execution time for " + collectionSize + " " + dataType + " quick sort is: "
                + format.format((end - start) / 1000d) + " seconds\n");
    }

    public static void loadSemiSortedData(SorterList<Integer, ISorter<Integer>> semiSortedInsert,
                                          SorterList<Integer, ISorter<Integer>> semiSortedQuick,
                                          SorterList<Integer, ISorter<Integer>> semiSortedMerge,
                                          int collectionSize){
        for(int i = 0; i < collectionSize; i++){
            if(i % 1000 == 0){
                semiSortedInsert.add(i - 5);
                semiSortedMerge.add(i - 5);
                semiSortedQuick.add(i - 5);
            }
            else{
                semiSortedInsert.add(i);
                semiSortedMerge.add(i);
                semiSortedQuick.add(i);
            }
        }
    }
}
