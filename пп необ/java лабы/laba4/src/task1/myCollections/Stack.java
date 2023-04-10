package task1.myCollections;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> implements MyCollection<E>{
    private Object[] arr;
    private int elementCount;

    public Stack() {
        arr = new Object[0];
        elementCount = 0;
    }

    private Object[] grow() {
        int oldCapacity = arr.length;
        int newLength = (oldCapacity < 64) ? (oldCapacity + 2) : (oldCapacity >> 1);
        arr = Arrays.copyOf(arr, newLength);
        return arr;
    }

    public void push(E item) {
        if (elementCount == arr.length) {
            arr = grow();
        }
        arr[elementCount] = item;
        elementCount++;
    }

    public E pop() {
        E obj = peek();
        elementCount--;
        arr[elementCount] = null;
        return obj;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        int len = size();

        if (len == 0) {
            throw new EmptyStackException();
        }
        return (E) arr[len - 1];
    }

    public int size() {
        return elementCount;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
