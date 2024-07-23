package com.collections.interfaces;

public interface IStack<T> {
    void push(T data);
    T pop();
    T peek();
    boolean isEmpty();
    void display();
}
