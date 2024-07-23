package com.collections.interfaces;

public interface ILinkedList<T> {
    void add_at_End(T data);
    void add_at_First(T data);
    void insertBetween(T data, int position);
    void remove(T data);
    void deleteNodeAtBeginning();
    void deleteNodeAtEnd();

    void display();
    boolean contains(T data);
    int size();
    T removeFirst();
    T getFirst();
}
