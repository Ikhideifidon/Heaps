package com.github.ikhideifidon;

import java.util.Arrays;

// Maximum Heap
public class ArrayBasedHeap<E extends Object & Comparable<E>>{
    // lChild = 2 * parent + 1
    // rChild = 2 * parent + 2

    // parent = floor((child - 1) / 2)
    private static final int DEFAULT_CAPACITY = 16;
    private int t;                      // Readily available position to insert element
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayBasedHeap(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        this.t = 0;
    }

    public ArrayBasedHeap() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBasedHeap(E[] keys) {
        this(keys.length);
        for (E key : keys)
            this.add(key);
    }

    public int size() { return t; }

    public boolean isEmpty() { return t == 0; }

    public void add(E e) {
        if (t >= data.length - 1)
            ensureCapacity(2 * data.length);
        data[++t] = e;
        trickleUp(t);
    }

    private void trickleUp(int position) {
        if (position == 1) return;
        // Find the parent of this position
        int parent = position / 2;
        if (data[parent].compareTo(data[position]) < 0) {
            swap(position, parent);
            trickleUp(parent);
        }
    }

    private void swap(int from, int to) {
        E temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }

    private void ensureCapacity(int newCapacity) {
        this.data = Arrays.copyOf(this.data, newCapacity);
    }

    public E peek() {
        if (this.isEmpty())
            throw new NullPointerException();
        return data[1];
    }

    public E remove() {
        if (this.isEmpty())
            throw new NullPointerException();
        E root = data[1];
        swap(t, 1);
        data[t--] = null;
        trickleDown(1);
        return root;
    }

    private void trickleDown(int parent) {
        int lChild = (parent * 2) + 1;
        int rChild = (parent * 2) + 2;

        if (lChild == t && data[lChild].compareTo(data[parent]) > 0) {
            swap(parent, lChild);
            return;
        }

        if (rChild == t && data[rChild].compareTo(data[parent]) > 0) {
            swap(parent, rChild);
            return;
        }

        // Leaf child
        if (lChild > t || rChild > t) return;

        int child = data[lChild].compareTo(data[rChild]) > 0 ? lChild : rChild;
        if (this.data[parent].compareTo(this.data[child]) < 0) {
            swap(parent, child);
            trickleDown(child);
        }
    }

}
