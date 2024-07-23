package com.collections.datastructures;

import com.collections.interfaces.IQueue;

public class Queue<T> implements IQueue<T> {
    private final LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    @Override
    public void enqueue(T data) {
        list.add_at_End(data);
    }

    @Override
    public T dequeue() {
        return list.removeFirst();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    @Override
    public void display()
    {
    	list.display();
    }
}
