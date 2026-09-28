import java.util.*;
class Main {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    static void insertAtFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    static void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    static void deleteFromFront() {
        if (head == null) {
            return;
        }

        head = head.next;
    }

    static void deleteFromEnd() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    static void deleteFromMiddle(int position) {
        if (head == null) {
            return;
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;

        for (int i = 0; i < position - 1; i++) {
            if (temp.next == null) {
                return;
            }

            temp = temp.next;
        }

        if (temp.next == null) {
            return;
        }

        temp.next = temp.next.next;
    }

    static void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        insertAtEnd(10);
        insertAtEnd(20);
        insertAtEnd(30);
        insertAtEnd(40);
        insertAtEnd(50);

        System.out.println("Original List:");
        display();

        insertAtFront(5);
        System.out.println("After inserting 5 at front:");
        display();

        insertAtEnd(60);
        System.out.println("After inserting 60 at end:");
        display();

        deleteFromFront();
        System.out.println("After deleting from front:");
        display();

        deleteFromEnd();
        System.out.println("After deleting from end:");
        display();

        deleteFromMiddle(2);
        System.out.println("After deleting position 2:");
        display();
    }
}