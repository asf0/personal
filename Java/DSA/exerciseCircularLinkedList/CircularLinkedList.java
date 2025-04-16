package exerciseCircularLinkedList;

public class CircularLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void append(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void prepend(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "Circular Linked List is empty";
        }
        StringBuilder result = new StringBuilder();
        Node current = head;
        do {
            result.append(current.value).append(" -> ");
            current = current.next;
        } while (current != head);
        result.append("(head)");
        return result.toString();
    }
}
