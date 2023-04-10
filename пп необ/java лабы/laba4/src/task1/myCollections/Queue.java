package task1.myCollections;

import java.util.NoSuchElementException;

public class Queue<E> implements MyCollection<E>{
    private static class Node<E> {
        E item;
        Queue.Node<E> next;
        Queue.Node<E> prev;

        Node(Queue.Node<E> prev, E element, Queue.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public void push(E e) {
        size++;
        final Node<E> f = head;
        head = new Node<>(f, e, null);
        if (f == null) {
            tail = head;
        } else {
            f.next = head;
        }
    }

    public E pop() {
        final Node<E> l = tail;
        if (l == null) {
            throw new NoSuchElementException();
        }
        size--;
        E element = l.item;
        final Node<E> newTail = l.next;
        l.next = null;
        l.item = null;
        tail = newTail;
        if (newTail == null) { //if there was only one argument
            head = null;
        } else {
            newTail.prev = null;
        }
        return element;
    }

    public E peek() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
