package circularLinkedList;

public class CircularSinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCSLL(int nodeValue) {
        Node node = new Node(nodeValue);
        //node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void inserCSLL(int nodeValue, int location) {
        Node node = new Node(nodeValue);
        //node.value = nodeValue;
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
                    System.out.print("-> ");
                }
                temp = temp.next;
            }
            System.out.println("");
        }
    }

    public boolean searchNode(int nodeValue) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return false;
        } else {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.value == nodeValue) {
                    System.out.println("Node found at location: " + i);
                    return true;
                }
                temp = temp.next;
            }
            System.out.println("Node not found");
            return false;
        }
    }
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The CSLL does not exist");
            return;
        }
        else if (location == 0) {
            head = head.next;
            tail.next = head;
            size --;
            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        } else if (location >= size) {
            Node temp = head;
            for (int i = 0; i < size -1; i++) {
                temp = temp.next;
            }
            if (temp == head) {
                tail = null;
                head.next = null;
                head = null;
                size = 0;
                return;
            }
            temp.next = head;
            tail = temp;
            size--;
        }   else {
            Node temp = head;
            for (int i = 0; i < location - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }
    public void deleteCSLL() {
        if (head == null) {
            System.out.println("The CSLL does not exist");
        } else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("The CSLL has been deleted");
        }
    }
}