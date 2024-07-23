package com.collections.interfaces;

public interface IDoublyLinkedList<T> 
{
    public void insertAtBeginning(T data);
    public void insertAtEnd(T data);
    public void insertBetween(T data, int position);
    public void printLinkedList();
    public void deleteNodeAtBeginning();
    public void deleteNodeAtEnd();
    public void deleteNode(int position);
   // int size();
    


    




}
