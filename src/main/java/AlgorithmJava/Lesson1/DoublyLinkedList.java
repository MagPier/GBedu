package AlgorithmJava.Lesson1;

import java.util.*;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
//Задание 3.4
//        На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
//        Реализуйте список заполненный объектами из вашего класса из задания 1.3
public class DoublyLinkedList<T>  {


    private Node<T> first;

    private Node<T> last;

    private int modCount;


    private int size;


    private static class Node<T> {

        Node<T> prev;

        Node<T> next;

        T data;


        public Node(Node<T> prev, T data,Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }


    private class ListItr implements ListIterator<T> {
        private Node<T> lastReturned = null;
        private Node<T> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index) {
            next = (index == size) ? null : getNode(index);
            nextIndex = index;
        }


        public boolean hasNext() {
            return nextIndex < size;
        }


        public T next() {

            checkForComodification();

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastReturned = next;

            next = next.next;

            nextIndex++;

            return lastReturned.data;
        }


        public boolean hasPrevious() {
            return nextIndex > 0;
        }


        public T previous() {

            checkForComodification();

            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            lastReturned = next = (next == null) ? last : next.prev;

            return lastReturned.data;
        }


        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }


        public void remove() {

            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            Node<T> lastNext = lastReturned.next;

            DoublyLinkedList.this.remove(lastReturned);

            if (next == lastReturned) {

                next = lastNext;
            } else {

                nextIndex--;
            }
            lastReturned = null;

            expectedModCount++;
        }

        public void set(T e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.data = e;
        }


        public void add(T e) {
            checkForComodification();
            lastReturned = null;
            DoublyLinkedList.this.add(e, nextIndex);
            nextIndex++;
            expectedModCount++;
        }


        final void checkForComodification() {

            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }


    public T get(int i) {
        Node<T> x = getNode(i);
        return x == null ? null : x.data;
    }


    private Node<T> getNode(int i) {
        if (i >= size) {
            return null;
        }

        if (i < (size >> 1)) {

            Node<T> x = first;
            for (int j = 0; j < i; j++) {

                x = x.next;
            }
            return x;
        } else {

            Node<T> x = last;
            for (int j = size - 1; j > i; j--) {

                x = x.prev;
            }
            return x;
        }
    }


    public boolean addFirst(T o) {
        Node<T> newNode = new Node<>(null, o, first);
        if (first != null) {
            first.prev = newNode;
        } else {
            last = newNode;
        }
        first = newNode;
        size++;
        modCount++;
        return true;
    }


    public boolean add(T o, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("index = " + i);
        }
        if (size == 0 || i == 0) {
            return addFirst(o);
        }
        Node<T> current = first;
        for (int j = 1; j < i && j < size; j++) {
            current = current.next;
        }
        return addAfter(current, o);
    }


    private boolean addAfter(Node<T> current, T o) {
        Node<T> newNode = new Node<>(current, o, current.next);
        if (current.next == null) {
            last = newNode;
        }else {
            current.next.prev = newNode;
        }
        current.next = newNode;
        size++;
        modCount++;
        return true;
    }


    @SuppressWarnings("unchecked")
    public boolean addSort(T o) {
        Comparable<? super T> data = (Comparable<? super T>) o;
        if (size == 0 || data.compareTo(first.data) <= 0) {
            return addFirst(o);
        }
        Node<T> current = first;
        while (current.next != null && data.compareTo(current.next.data) > 0) {
            current = current.next;
        }
        return addAfter(current, o);
    }

    public boolean addSort(T o, Comparator<? super T> c) {

        return false;
    }


    public boolean addLast(T o) {
        Node<T> l = last;

        Node<T> newNode = new Node<T>(l, o, null);

        last = newNode;

        if (l == null) {

            first = newNode;
        } else {

            l.next = newNode;
        }
        size++;
        modCount++;
        return true;
    }


    public T remove(int i) {
        Node<T> x = getNode(i);
        if (x == null) {
            return null;
        }
        return remove(x);
    }


    private T remove(Node<T> x) {
        T oldData = x.data;
        Node<T> prev = x.prev;
        Node<T> next = x.next;

        if (prev == null) {

            first = x.next;
        } else {

            prev.next = next;
            x.prev = null;
        }
        if (next == null) {

            last = x.prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.data = null;
        size--;
        modCount++;
        return oldData;
    }
    public Iterator<T> iterator() {
        return new ListItr(0);
    }
    public ListIterator<T> listIterator(int index) {
        return new ListItr(index);
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}