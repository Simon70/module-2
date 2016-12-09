package ss.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by simon on 09.12.16.
 */
public class MergeSort {
    public static <E extends Comparable<E>> void mergesort(List<E> list) {
        if (list.size() > 0) {
            Collections.copy(list, sort(list));
        }
    }

    private static <E extends Comparable<E>> List<E> sort(List<E> list) {
        int mid = list.size() / 2;
        if (list.size() > 1) {
            return merge(sort(list.subList(0, mid)), sort(list.subList(mid, list.size())));
        } else {
            return list;
        }
    }

    private static <E extends Comparable<E>> List<E> merge(List<E> left, List<E> right) {
        int cLeft = 0;
        int cRight = 0;
        List<E> result = new ArrayList<E>();
        while (cLeft < left.size() && cRight < right.size()) {
            if (left.get(cLeft).compareTo(right.get(cRight)) < 0) {
                result.add(left.get(cLeft++));
            } else {
                result.add(right.get(cRight++));
            }
        }
        if (cLeft < left.size()) {
            for (int i = cLeft; i < left.size(); i++) {
                result.add(left.get(i));
            }
        } else if (cRight < right.size()) {
            for (int i = cRight; i < right.size(); i++) {
                result.add(right.get(i));
            }
        }
        return result;
    }

    private static <E extends Comparable<E>> void swap(List<E> list, int start, int end) {
        E temp = list.get(start);
        list.set(start, list.get(end));
        list.set(end, temp);
    }
}
