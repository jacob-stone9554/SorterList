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
        sortLists(insertList, mergeList, quickList, 100000, is, qs, ms, "random");
        sortLists(semiSortedInsert, semiSortedMerge, semiSortedQuick, 100000, is, qs, ms, "semi-sorted");
        sortLists(insertList, mergeList, quickList, 100000, is, qs, ms, "sorted");

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
                + format.format((end - start) / 1000d) + " seconds with " + insertList.getOpCount() +" operations");

        System.out.println("\nStarting merge sort on " + collectionSize + " " + dataType + " collection...");
        start = System.currentTimeMillis();
        mergeList.sort();
        end = System.currentTimeMillis();
        System.out.println("Execution time for " + collectionSize + " " + dataType + " element merge sort is: "
                + format.format((end - start) / 1000d) + " seconds with " + mergeList.getOpCount() + " operations");

        System.out.println("\nStarting quick sort on " + collectionSize + " " + dataType + " collection...");
        start = System.currentTimeMillis();
        quickList.sort();
        end = System.currentTimeMillis();
        System.out.println("Execution time for " + collectionSize + " " + dataType + " quick sort is: "
                + format.format((end - start) / 1000d) + " seconds with " + quickList.getOpCount() + " operations\n");
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
