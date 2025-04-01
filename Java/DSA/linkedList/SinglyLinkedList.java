package linkedList;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void createSinglyLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
    }

    // Insert Method

    public void insertSinglyLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if ( head == null ) {
            createSinglyLinkedList(nodeValue);
            return;
        } else if (location == 0) { // add to the beginning
            node.next = head;
            head = node;
        } else if (location == size) { //add to the end
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;

        }
        size++;
    }
    // Traversal Method
    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("Linked List does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if ( i != size -1) {
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }
    // Search Method
    public void searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Node found at location " + i);
                    return;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
    }
    // Delete Method
    public void deletionOfNode(int location) {
        if (head == null) {
            System.out.print("Linked List does not exist");
        } else if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        }
        else if (location > size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                head = tail = null;
                size --;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size --;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size --;
        }
    }
    public void deleteSinglyLinkedList() {
        head = null;
        tail = null;
        System.out.println("Linked List deleted successfully");
    }
}

