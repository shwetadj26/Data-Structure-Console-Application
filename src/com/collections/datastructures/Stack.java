package com.collections.datastructures;

import com.collections.interfaces.IStack;
import com.collections.models.Node;

public class Stack<T> implements IStack<T> {
    private final LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(T data) {
        list.add_at_First(data);
    }

    @Override
    public T pop() {
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

    
    public int size() {
        return list.size();
    }
    
    @Override
   public  void display()
    {
    	list.display();
    	
    }
}
