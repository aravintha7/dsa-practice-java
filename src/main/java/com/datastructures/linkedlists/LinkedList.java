package main.java.com.datastructures.linkedlists;

/*
 * Class representing a linked list.
 */
public class LinkedList {
    public Node head = null;

    /*
     * Constructor to initialize the head of the linked list with the given data.
     */
    public LinkedList(int data) {
        head = new Node(data);
    }

    /*
     * Class representing a node in the linked list.
     */
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Main method to demonstrate the operations on a LinkedList.
     * Initializes a linked list and performs various operations such as
     * inserting elements, deleting an element by value, deleting an element
     * by position, and reversing the list. Finally, prints the linked list
     * after each operation to show the results.
     *
     * @param args Command-line arguments, ignored.
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        insert(6, list);
        insert(5, list);
        insert(50, list);
        insert(500, list);
        insert(100, list);
        insert(99, list);
        printLinkedList(list);
        // int position = delete(list, 500);
        // if (position != -1)
        // printLinkedList(list);
        if (deleteByPosition(list, 0)) {
            printLinkedList(list);
        }
        // System.out.println("Reversing the list..");
        // printLinkedList(list.head = reverse(list.head));

        // System.out.println("printing the original list..");
        // printLinkedList(list.head = reverse(list.head));
    }

    /************* ✨ Codeium Command 🌟 *************/
    /**
     * Inserts an element with the given data at the end of the linked list.
     * If the list is empty, the inserted element becomes the head of the
     * list. Otherwise, iterates to the end of the list and inserts the new
     * element after the last element.
     *
     * @param data the data to be inserted
     * @param list the linked list to insert into
     */
    public static void insert(int data, LinkedList list) {
        if (list == null) {
            throw new NullPointerException("list is null..");
        }
        if (list.head == null) {
            list.head = new Node(data);
        } else {
            Node curr = list.head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(data);
        }
    }

    public static void insertByPosition(int position, int data, LinkedList list) {
        if (position < 0) {
            throw new ArithmeticException("Position should be non-negative");
        }
        if (list == null) {
            throw new NullPointerException("list is null..");
        }
        if (list.head == null) {
            list.head = new Node(data);
        } else {
            Node curr = list.head;
            // int count = 0;
            // while (count < position - 1) {
            //     curr = curr.next;
            //     count++;
            // }
            // Node newNode = new Node(data);
            // newNode.next = curr.next;
            // curr.next = newNode;
            Node prev = null;
            while (position > 0) {
                prev = curr;
                curr = curr.next;
                position--;
            }
            Node newNode = new Node(data);
            newNode.next = curr;
            prev.next = newNode;
        }
    }

    /****** 66bea244-6ab2-4cef-af46-699002e6a9a9 *******/

    /**
     * Prints the elements of the linked list to the console.
     * Iterates through the list starting from the head and prints
     * each element's data followed by a space. Throws a
     * NullPointerException if the provided linked list is null.
     *
     * @param linkedList the linked list to print
     */
    public static void printLinkedList(LinkedList linkedList) {
        if (linkedList == null) {
            throw new NullPointerException("list is null");
        }

        if (linkedList.head == null) {
            System.out.println("The list is empty..");
            return;
        }

        Node curr = linkedList.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    /************* ✨ Codeium Command 🌟 *************/
    /**
     * Prints the elements of a linked list to the console.
     * Iterates through the list starting from the given head and prints
     * each element's data followed by a space. If the head is null, does
     * nothing.
     *
     * @param head the head of the linked list to print
     */
    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    /************* ✨ Codeium Command 🌟 *************/
    /**
     * Deletes the first occurrence of the specified value from the linked list.
     * If the list is null, throws a NullPointerException. If the list is empty,
     * prints a message and returns -1. If the value is found at the head of the
     * list,
     * deletes the head node and returns its position (0). If the value is found
     * elsewhere in the list, removes the node containing the value and returns its
     * position.
     * If the value is not found in the list, prints a message and returns -1.
     *
     * @param list  the linked list from which to delete the value
     * @param value the value to be deleted from the list
     * @return the position of the deleted element, or -1 if the element is not
     *         found
     */
    public static int delete(LinkedList list, int value) {
        if (list == null) {
            throw new NullPointerException("List is null");
        }
        // case:1 empty list
        if (list.head == null) {
            System.out.println("The given linked list is empty.. provide list with some values");
            return -1;
        }
        Node currNode = list.head, prev = null;
        int position = 0;
        while (currNode != null && currNode.data != value) {
            prev = currNode;
            currNode = currNode.next;
            position++;
        }
        if (currNode == null) {
            System.out.println("element not found..");
            return -1;
        }
        if (prev == null) {
            list.head = list.head.next;
            System.out.printf("element is at head i.e. %dth position, removed from list..\n", position);
            return 0;
        }
        prev.next = currNode.next;
        System.out.printf("The element found at %d\nRemoved the element\n", position);
        return position;
    }

    /****** a64ccde7-d2f4-4b1a-aec0-ac204f57e27f *******/

    /**
     * Deletes the element at the specified position from the linked list.
     * If the list is null, throws a NullPointerException. If the position is
     * negative, prints a message and returns false. If the list is empty,
     * prints a message and returns false. If the position is 0, deletes the
     * head of the list and prints a message. If the position is greater than
     * the size of the list, prints a message and returns false. Otherwise,
     * deletes the element at the specified position and prints a message.
     *
     * @param list     the linked list from which to delete the element
     * @param position the position of the element to be deleted
     * @return true if the element was found and deleted, false otherwise
     */
    public static boolean deleteByPosition(LinkedList list, int position) {
        if (list == null) {
            throw new NullPointerException("List is null");
        }
        if (position < 0) {
            System.out.println("Position should be non-negative");
            return false;
        }
        if (list.head == null) {
            System.out.println("Can't delete from empty list...");
            return false;
        }
        Node current = list.head;
        if (position == 0) {
            list.head = current.next;
            System.out.println("Deleted the head element..");
            return true;
        }
        Node previous = null;
        int index = 0;
        while (current != null && index < position) {
            previous = current;
            current = current.next;
            index++;
        }
        if (current == null) {
            System.out.println("Position out of range...");
            return false;
        }
        previous.next = current.next;
        System.out.println("Found the element and deleted..");
        return true;
    }

    /**
     * Reverses the linked list and returns the reversed list.
     * If the list is null, returns null. Otherwise, iterates through the
     * list and reverses the links between each node.
     *
     * @param head the head of the list to be reversed
     * @return the reversed list
     */
    public static Node reverse(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head, prev = null;
        while (curr != null) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

}
