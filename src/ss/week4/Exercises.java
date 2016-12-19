package ss.week4;

public class Exercises {
    public static int countNegativeNumbers(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += (i < 0) ? 1 : 0;
        }
        return count;
    }

    public static void reverseArray(int[] ints) {
        for (int i = 0; i < ints.length / 2; i++) {
            int temp = ints[i];
            ints[ints.length - i] = ints[i];
            ints[i] = temp;
        }
    }

    class SimpleList {
        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }

        public class Element {
        }

        public class Node {
            public Node next;
            public Element element;
        }
    }
}
