package com.collections.main;

import com.collections.datastructures.DoublyLinkedList;
import com.collections.datastructures.LinkedList;
import com.collections.datastructures.Queue;
import com.collections.datastructures.Stack;
import com.collections.interfaces.IDoublyLinkedList;
import com.collections.interfaces.ILinkedList;
import com.collections.interfaces.IQueue;
import com.collections.interfaces.IStack;

import java.util.InputMismatchException;           //
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMainMenu();
            int choice = getUserInput(scanner);

            if (choice == 0) {
                System.out.println("Exiting... Thank you for using the application!");
                scanner.close();          //closing scanner object
                System.exit(0);          // closing program
            }

            Class<?> dataType = selectDataType(scanner);
            if (dataType == null) {
                System.out.println("Invalid data type choice. Please try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    handleOperations(new LinkedList<>(), scanner, dataType);
                    break;
                case 2:
                    handleOperations(new DoublyLinkedList<>(), scanner, dataType);
                    break;
               
                case 3:
                    handleOperations(new Stack<>(), scanner, dataType);
                    break;
                case 4:
                    handleOperations(new Queue<>(), scanner, dataType);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("================================");
        System.out.println("           MAIN MENU            ");
        System.out.println("================================");
        System.out.println("1. LinkedList Operations");
        System.out.println("2. Doubly LinkedList Operations");
        System.out.println("3. Stack Operations");
        System.out.println("4. Queue Operations");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserInput(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }

    private static Class<?> selectDataType(Scanner scanner) {
        System.out.println("================================");
        System.out.println("        SELECT DATA TYPE        ");
        System.out.println("================================");
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.println("3. Double");
        System.out.print("Enter your choice: ");
        int dataTypeChoice = getUserInput(scanner);

        switch (dataTypeChoice) {
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            default:
                return null;
        }
    }

    private static <T> void handleOperations(Object structure, Scanner scanner, Class<T> dataType) {
        if (structure instanceof ILinkedList)
        {
            linkedListOperations((ILinkedList<T>) structure, scanner, dataType);          // you are having linked list in your data type
        }
        else if (structure instanceof IDoublyLinkedList) {
            DoublylinkedListOperations((IDoublyLinkedList<T>) structure, scanner, dataType);
        }
        else if (structure instanceof IStack)
        {
            stackOperations((IStack<T>) structure, scanner, dataType);
        } 
        else if (structure instanceof IQueue)
        {
            queueOperations((IQueue<T>) structure, scanner, dataType);
        }
    }

    private static <T> void linkedListOperations(ILinkedList<T> linkedList, Scanner scanner, Class<T> dataType) {
        while (true) {
            printLinkedListMenu();
            int choice = getUserInput(scanner);

            switch (choice) {
                case 1:
                    linkedList.add_at_End(getValueFromUser(scanner, dataType));
                    break;
                case 2:
                    linkedList.add_at_First(getValueFromUser(scanner, dataType));
                    break;
                    
                case 3:
                	
                    System.out.print("Enter position in which you want to add: ");
                    int position = scanner.nextInt();
                    linkedList.insertBetween(getValueFromUser(scanner, dataType),position);
                    break;
                case 4:
                    linkedList.display();
                    break;
                    
                    
                case 5:
                	
                    linkedList.remove(getValueFromUser(scanner, dataType));
                    break;
                case 6:
                    linkedList.deleteNodeAtBeginning();
                    break;
                    
                case 7:
                    linkedList.deleteNodeAtEnd();
                    break;
                
                    
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printLinkedListMenu() {
        System.out.println("================================");
        System.out.println("       LINKEDLIST MENU          ");
        System.out.println("================================");
        
        System.out.println("1. Add End");
        System.out.println("2. Add First");
        System.out.println("3.Add Between");
        System.out.println("4. Display");
        System.out.println("5. Remove");
        System.out.println("6. Remove node at beginning");
        System.out.println("7. Remove node at End");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        
    }
    
    private static <T> void DoublylinkedListOperations(IDoublyLinkedList<T> DoublylinkedList, Scanner scanner, Class<T> dataType) {
        while (true) {
            printDoublyLinkedListMenu();
            int choice = getUserInput(scanner);

            switch (choice) {
                case 1:
                	DoublylinkedList.insertAtEnd(getValueFromUser(scanner, dataType));
                    break;
                case 2:
                	DoublylinkedList.insertAtBeginning(getValueFromUser(scanner, dataType));
                    break;
                    
                case 3:
                	
                    System.out.print("Enter position in which you want to add: ");
                    int position = scanner.nextInt();
                    DoublylinkedList.insertBetween(getValueFromUser(scanner, dataType),position);
                    break;
                case 4:
                	DoublylinkedList.printLinkedList();
                    break;
                    
                    
                case 5:
                	System.out.print("Enter position you want to delete: ");
                    int position1 = scanner.nextInt();
                	DoublylinkedList.deleteNode(position1);
                    break;
                case 6:
                	DoublylinkedList.deleteNodeAtBeginning();
                    break;
                    
                case 7:
                	DoublylinkedList.deleteNodeAtEnd();
                    break;
                
                    
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printDoublyLinkedListMenu() {
        System.out.println("================================");
        System.out.println("       DOUBLY LINKEDLIST MENU          ");
        System.out.println("================================");
        
        System.out.println("1. Add End");
        System.out.println("2. Add First");
        System.out.println("3.Add Between");
        System.out.println("4. Display");
        System.out.println("5. Remove");
        System.out.println("6. Remove node at beginning");
        System.out.println("7. Remove node at End");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        
    }
    
    

    private static <T> void stackOperations(IStack<T> stack, Scanner scanner, Class<T> dataType) {
        while (true) {
            printStackMenu();
            int choice = getUserInput(scanner);

            switch (choice) {
                case 1:
                    stack.push(getValueFromUser(scanner, dataType));
                    break;
                case 2:
                    try {
                        System.out.println("Popped value: " + stack.pop());
                    } catch (Exception e) {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Peek value: " + stack.peek());
                    } catch (Exception e) {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printStackMenu() {
        System.out.println("================================");
        System.out.println("         STACK MENU             ");
        System.out.println("================================");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        System.out.println("4. Display");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static <T> void queueOperations(IQueue<T> queue, Scanner scanner, Class<T> dataType) {
        while (true) {
            printQueueMenu();
            int choice = getUserInput(scanner);

            switch (choice) {
                case 1:
                    queue.enqueue(getValueFromUser(scanner, dataType));
                    break;
                case 2:
                    try {
                        System.out.println("Dequeued value: " + queue.dequeue());
                    } catch (Exception e) {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Peek value: " + queue.peek());
                    } catch (Exception e) {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printQueueMenu() {
        System.out.println("================================");
        System.out.println("          QUEUE MENU            ");
        System.out.println("================================");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Peek");
        System.out.println("4. Display");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static <T> T getValueFromUser(Scanner scanner, Class<T> dataType) {
        while (true) {
            System.out.print("Enter value: ");
            try {
                if (dataType == Integer.class) {
                    return dataType.cast(scanner.nextInt());
                } else if (dataType == String.class) {
                    return dataType.cast(scanner.next());
                } else if (dataType == Double.class) {
                    return dataType.cast(scanner.nextDouble());
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear invalid input
                System.out.println("Invalid input for data type " + dataType.getSimpleName() + ". Please try again.");
            }
        }
    }
}