package com.collections.datastructures;

import com.collections.interfaces.ILinkedList;
import com.collections.models.Node;

public class LinkedList<T> implements ILinkedList<T> {
    private Node<T> head;
    private int size;

    
   
    @Override
    public void add_at_First(T data) 
    {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    @Override
	public void insertBetween(T data, int  position) 
	{
		Node<T> newNode = new Node<T>(data);
        Node <T> temp1= head;
        for(int i=0;i<(position-1);i++)
        {
        	temp1 = temp1.next;
        }
        newNode.next = temp1.next;
        temp1.next = newNode;
		
	}
    
    @Override
    public void add_at_End(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    @Override
    public void remove(T data) {
        if (head == null) return;

        if (head.data.equals(data)) {
            head = head.next;
        } else {
            Node<T> temp = head;
            while (temp.next != null && !temp.next.data.equals(data)) {
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        size--;
    }
    
    @Override
    public void deleteNodeAtBeginning() 
    {
        if (head == null) {
            System.out.println("Linked list is empty");
           
        }
        else
        {
        	Node<T> temp = head;
        	temp = temp.next;
        	head = temp;
        	
        }
    }
    
    @Override
    public void deleteNodeAtEnd() 
    {
        if (head == null) 
        {
            System.out.println("Linked list is empty");
            return;
        }
        else
        {
        	Node<T> temp1= head;
        	Node<T> ptr= temp1.next;
        	
        	while(ptr.next != null)
        	{
        		temp1 = ptr;
        		ptr = ptr.next;
        	
        	}
        	temp1.next = null;
        	
        	
        }
    }

    @Override
    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(" ");
    }

    @Override
    public boolean contains(T data)
    {
        Node<T> temp = head;
        while (temp != null) 
        {
            if (temp.data.equals(data)) 
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (head == null) return null;
        return head.data;
    }

	
}


  
