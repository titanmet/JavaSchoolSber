import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    public final Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T t) {
        Integer count = map.get(t);
        if (count == null) {
            map.put(t, 1);
        } else {
            map.put(t, ++count);
        }
    }

    @Override
    public int getCount(T t) {
        try {
            return map.get(t);
        } catch (NullPointerException e) {
            e.getMessage();
            return 0;
        }
    }

    @Override
    public int remove(T t) {
        try {
            return map.remove(t);
        } catch (NullPointerException e) {
            e.getMessage();
            return 0;
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> result) {
        for (Object key: result.toMap().keySet()){
            Integer count = map.get(key);
            if(count == null){
                count = 0;
            }
            map.put((T)key, result.getCount((T) key) + count);
        }
    }

    @Override
    public Map toMap() {
        return map;
    }

    @Override
    public void toMap(Map destination) {
        for (T key: map.keySet()) {
            destination.put(key, map.get(key));
        }
    }
}
