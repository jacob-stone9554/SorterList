import java.util.ArrayList;
import java.util.List;

/**
 * A generic class for sorting lists using a specified sorter.
 *
 * @param <T>  the type of elements in the list
 * @param <T2> the type of sorter to be used
 */
public class SorterList<T extends Comparable<T>, T2 extends ISorter<T>> {

    private final List<T> list;
    private final T2 sorter;

    /**
     * Constructs a SorterList with the specified sorter.
     *
     * @param sorter the sorter to be used
     */
    public SorterList(T2 sorter) {
        this.list = new ArrayList<>();
        this.sorter = sorter;
    }

    /**
     * Adds an element to the list.
     *
     * @param element the element to be added
     */
    public void add(T element) {
        list.add(element);
    }

    /**
     * Sorts the list using the specified sorter.
     *
     * @return the sorted list
     * @throws IllegalArgumentException if the list is empty
     */
    public List<T> sort() {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Cannot sort an empty list.");
        }
        return sorter.sortArray(list);
    }

    /**
     * Gets the current list.
     *
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * Clears the elements of the list, making it empty.
     */
    public void clear() {
        list.clear();
    }
}
