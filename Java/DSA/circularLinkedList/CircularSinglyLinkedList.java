package circularLinkedList;

public class CircularSinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCSLL(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void inserCSLL(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createCSLL(nodeValue);
            return;
        }
        else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = head;
        }
        else if (location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
        else {
            Node temp = head;
            int i = 0;
            while (i < location - 1) {
                temp = temp.next;
                i++;
            }
            node.next = temp.next;
            temp.next = node;
        }
        size++;
    }
    public void traverseCSLL() {
        if (head == null) {
            System.out.println("Linked list is empty");
        }
        else {
            Node temp = head;
            for(int i = 0; i < size; i++) {
                System.out.print(temp.value + " ");
                if (i != size - 1) {
                    System.out.print("->");
                }
                temp = temp.next;
            }
        }
    }
}