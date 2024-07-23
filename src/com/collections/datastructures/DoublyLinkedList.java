package com.collections.datastructures;

import com.collections.interfaces.IDoublyLinkedList;
import com.collections.models.Node;

public class DoublyLinkedList<T> implements IDoublyLinkedList<T> 
{
	
    private Node<T> head;
    private Node<T> tail;
    //private int size;

	@Override
	public void insertAtBeginning(T data) 
	{
		Node<T> newNode = new Node<T>(data);  // Create a new node
        if (head == null) 
        {
            head = tail = newNode;
        } 
        else 
        {
            newNode.next = head;  // Each new node pointer points to the head
            head.prev = newNode;
            head = newNode;  // New node is the new head
        }
		
	}

	@Override
	public void insertAtEnd(T data)
	{
		Node<T> newNode = new Node<T>(data);
        if (head == null) 
        {
            head = tail = newNode;
        } 
        else 
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
		
	}

	@Override
	public void insertBetween(T data, int position)
	{
		 if (position == 1) 
	        {
	            insertAtBeginning(data);
	            return;
	        }

	        Node<T> newNode = new Node<T>(data);
	        Node<T> temp = head;
	        for (int i = 1; i < position - 1 && temp != null; i++)
	        {
	            temp = temp.next;
	        }

	        if (temp == null || temp.next == null)
	        {
	            insertAtEnd(data);
	        } 
	        else
	        {
	            newNode.next = temp.next;
	            newNode.prev = temp;
	            temp.next.prev = newNode;
	            temp.next = newNode;
	        }
		
	}

	@Override
	public void printLinkedList() 
	{
		Node<T> current = head;
        while (current != null)
        {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
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
		if (head == null) {
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
	public void deleteNode(int position) 
	{
		if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        else
        {
        	
        	Node<T> temp2 = head;
        	Node<T> ptr2 = temp2.next;
        	for(int i=0;i<(position-2);i++)
        	{
        		temp2 = ptr2;
        		ptr2 = ptr2.next;
        	}
        	
        	temp2.next = ptr2.next;
        }		
	}

}