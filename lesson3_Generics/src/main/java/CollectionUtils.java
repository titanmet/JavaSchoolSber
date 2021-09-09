import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T t) {
        return source.indexOf(t);
    }

    public static <T> List<? super T> limit(List<T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }

    public static <T> void add(List<? super T> source, T t) {
        source.add(t);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        return c2.stream().anyMatch(c1::contains);
    }

    public static <T extends Comparable<T>> List<T> range(List<T> list, T min, T max) {
        List<T> source = newArrayList();
        list.forEach(e -> {
            if (e.compareTo(min) >= 0 && e.compareTo(max) <= 0) {
                source.add(e);
            }
        });
        return source;
    }

    public static <T> List<T> range(List<T> list, T min, T max, Comparator<T> comparator) {
        List<T> source = newArrayList();
        list.forEach(e -> {
            if (comparator.compare(e, min) >= 0 && comparator.compare(e, max) <= 0) {
                source.add(e);
            }
        });
        source.sort(comparator);
        return source;
    }
}
