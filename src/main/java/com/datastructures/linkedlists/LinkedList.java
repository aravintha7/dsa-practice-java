package main.java.com.datastructures.linkedlists;

public class LinkedList {
    public Node head = null;

    public LinkedList(int data) {
        head = new Node(data);
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        insert(6, list);
        insert(5, list);
        insert(50, list);
        insert(500, list);
        insert(100, list);
        insert(99, list);
        printLinkedList(list);
        int position = delete(list, 5);
        if (position != -1)
            printLinkedList(list);
        if (deleteByPosition(list, 1)) {
            printLinkedList(list);
        }
        System.out.println("Reversing the list..");
        printLinkedList(list.head = reverse(list.head));

        System.out.println("printing the original list..");
        printLinkedList(list.head = reverse(list.head));
    }

    public static void insert(int data, LinkedList list) {
        Node node = new Node(data);
        if (list.head == null) {
            list.head = node;
        } else {
            Node curr = list.head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    public static void printLinkedList(LinkedList linkedList) {
        Node curr = linkedList.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static int delete(LinkedList list, int value) {
        Node currNode = list.head, prev = null;
        // case:1 empty list
        if (list.head == null) {
            System.out.println("The given linked list is empty.. provide list with some values");
            return -1;
        }
        // case:2 list having the value at the initial position
        if (currNode.data == value) {
            list.head = list.head.next;
            System.out.println("element is at head, removed from list..");
            return 0;
        }
        int position = 0;
        // case: 3 other position
        while (currNode != null && currNode.data != value) {
            prev = currNode;
            currNode = currNode.next;
            position++;
        }
        if (currNode == null) {
            System.out.println("element not found..");
            return -1;
        } else {
            prev.next = currNode.next;
            System.out.printf("The element found at %d\nRemoved the element\n", position);
            return position;
        }
    }

    public static boolean deleteByPosition(LinkedList list, int position) {
        Node head = list.head;
        if (position < 0) {
            System.out.println("Position should be positive");
            return false;
        }
        if (head == null) {
            System.out.println("Can't delete from empty list...");
            return false;
        }
        // case: 1 0th position
        if (position == 0) {
            list.head = list.head.next;
            System.out.println("deleted the head element..");
            return true;
        } else { // case: 2 other position
            int ptr = 0;
            Node prev = null;
            while (head != null && position != ptr) {
                prev = head;
                head = head.next;
                ptr++;
            }
            if (head == null) {
                System.out.println("Position out of range...");
                return false;
            } else {
                prev.next = head.next;
                System.out.println("Found the element and deleted..");
                return true;
            }
        }
    }

    public static Node reverse(Node head) {
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
