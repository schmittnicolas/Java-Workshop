package fr.epita.assistants.linkedlist;

import javax.print.attribute.standard.NumberUp;

public class LinkedList<T extends Comparable<T>> {

    class Node {
        T data;
        Node next;

        public Node(T e) {
            data = e;
            next = null;
        }
    }

    private Node head;

    /**
     * Initializes the list
     **/
    public LinkedList() {
        head = null;
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T e) {
        Node newNode = new Node(e);

        if (head == null || head.data.compareTo(e) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null && cur.next.data.compareTo(e) < 0) {
                cur = cur.next;
            }

            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if there is no element at this
     *                                   index.
     **/
    public T get(int i) {
        if (head == null)
            throw new IndexOutOfBoundsException("List is empty");

        int j = 0;
        Node cur = head;
        while (j != i && cur != null) {
            cur = cur.next;
            j++;
        }

        if (cur != null) {
            return cur.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes the first occurrence of the specified element in the list.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove(T e) {
        if (head.data == e) {
            T t = head.data;
            head = head.next;
            return t;
        } else {
            Node cur = head;
            while (cur.next != null) {
                if (cur.next.data == e) {
                    T t = cur.next.data;
                    cur.next = cur.next.next;
                    return t;
                } else {
                    cur = cur.next;
                }
            }
        }

        return null;
    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        int size = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }

        return size;
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        head = null;
    }
}
