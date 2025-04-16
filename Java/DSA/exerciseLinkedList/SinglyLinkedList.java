package exerciseLinkedList;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void push(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
            System.out.println("first node");
        } else {
            tail.next = node;
            tail = node;
            System.out.println("Success");
        }
        size++;
    }

    public void get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println(current.value);
    }
    public boolean set(int index, int value) {
        if (index < 0 || index >= size) {
            return false;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;

        }
        current.value = value;
        return true;
    }

    public String rotate(int number) {
        if (head == null) {
            return "empty";
        }
        if (number < 0 || number >= size) {
            return "Index out of bounds";
        }
        Node current = head;
        for (int i = 0; i < number; i++) {
            current = current.next;
        }
        Node newHead = current.next;
        current.next = null;
        tail.next = head;
        head = newHead;
        tail = current;
        return "Success";

    }

    public Node pop() {
        if (head == null) {
            System.out.println("empty");
            return null;
        }
        Node popped = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        size--;
        return popped;
    }
    public boolean insert(int data, int index) {
        Node newNode = new Node();
        newNode.value = data;
        if (index < 0 || index > size) {
            return false;
        } else if (index == 0) {
                newNode.next = head;
                head = newNode;
        } else if (index == size) {
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node current = head;
            int i = 0;
            while (i < index - 1) {
                current = current.next;
                i++;
            }
            Node next = current.next;
            current.next = newNode;
            newNode.next = next;
        }
        size++;
        return true;
    }
    public Node remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = removedNode.next;
            if (removedNode == tail) {
                tail = current;
            }
        }
        size--;
        return removedNode;
    }
}
