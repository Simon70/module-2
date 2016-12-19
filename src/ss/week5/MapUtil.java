package ss.week5;

import java.util.*;

public class MapUtil {
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        return containsDuplicates(map.values());
    }

    public static <K, V>
    boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        for (V item : map.values()) {
            if (!range.contains(item)) {
                return false;
            }
        }
        for (V item : range) {
            if (!map.containsValue(item)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> result = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (result.containsKey(entry.getValue())) {
                result.get(entry.getValue()).add(entry.getKey());
            } else {
                HashSet<K> temp = new HashSet<>();
                temp.add(entry.getKey());
                result.put(entry.getValue(), temp);
            }
        }
        return result;
    }

    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> result = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        for (V value : f.values()) {
            if (!g.containsKey(value)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> result = new HashMap<>();

        for (Map.Entry<K, V> entry : f.entrySet()) {
            result.put(entry.getKey(), g.get(entry.getValue()));
        }
        return result;
    }

    private static <E> boolean containsDuplicates(Collection<E> collection) {
        ArrayList<E> items = new ArrayList<>();
        for (E item : collection) {
            if (items.contains(item)) {
                return false;
            } else {
                items.add(item);
            }
        }
        return true;
    }
}
