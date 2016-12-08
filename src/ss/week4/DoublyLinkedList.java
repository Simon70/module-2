package ss.week4;

public class DoublyLinkedList<E> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, E element) {
        Node node = new Node(element);
        if (size == 0) {
            head = node;
        } else if (index == 0) {
            node.next = head;
            head.previous = node;
            head = node;
        } else {
            Node p = getNode(index - 1);
            node.previous = p;
            node.next = p.next;
            p.next = node;
        }
        size++;
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
        Node toRemove = getNode(index);
        if (toRemove.previous != null)
            toRemove.previous.next = toRemove.next;
        if (toRemove.next != null)
            toRemove.next.previous = toRemove.previous;
        size--;
    }

    //@ requires 0 <= index && index < this.size;
    /*@ pure */
    public E get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = 0;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }

    public class Node {
        public Node next;
        public Node previous;
        private E element;

        public Node(E element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        public E getElement() {
            return element;
        }
    }
}
