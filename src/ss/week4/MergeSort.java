package ss.week4;

import java.util.List;

public class MergeSort {
    public static <E extends Comparable<E>> void mergesort(List<E> list) {
        if (list.size() > 0) {
            merge(list, 0, list.size() - 1);
        }
    }

    private static <E extends Comparable<E>> void merge(List<E> list, int start, int end) {
        if (end - start > 2) {
            int mid = (end - start) / 2;
            merge(list, start, mid);
            merge(list, mid + 1, end);
        } else if (list.get(start).compareTo(list.get(end)) > 0) {
            swap(list, start, end);
        }
    }

    private static <E extends Comparable<E>> void swap(List<E> list, int start, int end) {
        E temp = list.get(start);
        list.set(start, list.get(end));
        list.set(end, temp);
    }

}