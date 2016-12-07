package ss.week4;

public class LinkedList<E> {

    private /*@ spec_public @*/ int size;
    private Node first;

    //@ ensures \result.size == 0;
    public LinkedList() {
        size = 0;
        first = null;
    }

    public void add(int index, E element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index - 1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size++;
    }

    //@ ensures this.size == \old(size) - 1;
    public void remove(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (get(i).equals(element)) {
                index = i;
                break;
            }
        }
        switch (index) {
            case -1:
                // Do nothing, element not found.
                break;
            case 0:
                // Element is the first element
                first = first.next;
                size--;
                break;
            default:
                Node node = getNode(index - 1);
                node.next = node.next.next;
                size--;
                break;
        }
    }

    public Node findBefore(E element) {
        Node last;
        for (int i = 0; i < size - 1; i++) {
            last = getNode(i);
            if (get(i + 1).equals(element)) {
                return last;
            }
        }
        return null;
    }

    //@ requires 0 <= index && index < this.size();
    public E get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    //@ requires 0 <= i && i < this.size();
    private /*@ pure @*/ Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    //@ ensures \result >= 0;
    public /*@ pure @*/ int size() {
        return size;
    }

    public class Node {
        public Node next;
        private E element;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public E getElement() {
            return element;
        }
    }
}
