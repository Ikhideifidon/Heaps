package com.github.ikhideifidon;

public interface MyInterface<E extends Object & Comparable<E>> extends Iterable<E> {
    public int length();
    public void swapEnds();
    public void insertFirst(E data);
    public void insertLast(E data);
    public void insert(E data, int position);
    public E removeFirst();
    public E removeLast();
    public E remove(E data);
}
