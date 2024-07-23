package com.collections.interfaces;

public interface IQueue<T> {
    void enqueue(T data);
    T dequeue();
    T peek();
    boolean isEmpty();
    void display();
}
