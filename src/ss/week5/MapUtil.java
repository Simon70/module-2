package ss.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapUtil {

	//@\requires f!=null;
	public static <K, V> boolean isOneOnOne(Map<K, V> f) {
		List<V> values = new ArrayList<V>();
		for (Map.Entry<K, V> entry : f.entrySet()) {
			if (!values.contains(entry.getValue())) {
				values.add(entry.getValue());
			} else {
				return false;
			}
		}
		
		return true;
	}

	public static <K, V> boolean isSurjectiveOnRange(Map<K, V> f, Set<V> range) {
		// exercise P-5.2
		Iterator<V> rangeIterator = range.iterator();
		while (rangeIterator.hasNext()) {
			if (!f.containsValue(rangeIterator.next())) {
				return false;
			}
		}
		return true;
	}

	public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		// exercise P-5.3
		Map<V, Set<K>> inverse = new HashMap<V, Set<K>>();
		for (Map.Entry<K, V> entry : map.entrySet()) {
			if (inverse.containsKey(entry.getValue())) {
				inverse.get(entry.getValue()).add(entry.getKey());
			} else {
				inverse.put(entry.getValue(), new HashSet<K>(Arrays.asList(entry.getKey())));
			}
		}

		return inverse;
	}

	public static <K, V> Map<V, K> inverseBijection(Map<K, V> f) {
		// exercise P-5.3
		if (isOneOnOne(f)) {
			Set<V> range = new HashSet<V>(f.values());

			if (isSurjectiveOnRange(f, range)) {
				Map<V,K> result = new HashMap<V,K>();
				Iterator<V> rangeIterator = range.iterator();
				Iterator<K> keyIterator = f.keySet().iterator();
				while(rangeIterator.hasNext() && keyIterator.hasNext()) {
					result.put(rangeIterator.next(), keyIterator.next());
				}
				
				return result;
			}
		}

		return null;
	}

	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		// see exercise P-5.4
		Iterator<V> values = f.values().iterator();
		Set<V> keys = g.keySet();
		while(values.hasNext()) {
			 if(!keys.contains(values.next())) {
				 return false;
			 }
		}
		
		return true;
	}

	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		// exercise P-5.5
		if(compatible(f,g)) {
			HashMap<K,W> composition = new HashMap<K,W>();
			Iterator<V> valueIterator = f.values().iterator();
			Iterator<K> keyIterator = f.keySet().iterator();
			while(valueIterator.hasNext() && keyIterator.hasNext()) {
				V value = valueIterator.next();
				K key = keyIterator.next();
				if(g.containsKey(value)) {
					composition.put(key, g.get(value));
				}
			}
			return composition;
		}
		return null;
	}
}