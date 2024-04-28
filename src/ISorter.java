import java.util.List;

public interface ISorter<E extends Comparable<E>> {
    public List<E> sortArray(List<E> list);
}
