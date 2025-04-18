package exerciseCircularLinkedList;

public class CircularLinkedList {

    public Node head;
    public Node tail;
    int length;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
            newNode.next = newNode; // Pointing to itself to make the list circular
        } else {
            this.tail.next = newNode;
            newNode.next = this.head;
            this.tail = newNode;
        }
        this.length++;
    }

    @Override
    public String toString() {
        if (this.length == 0) {
            return "";
        }

        Node tempNode = this.head;
        StringBuilder result = new StringBuilder();

        do {
            result.append(tempNode.value);
            tempNode = tempNode.next;
            if (tempNode != this.head) {
                result.append(" -> ");
            }
        } while (tempNode != this.head);

        return result.toString();
    }

    public boolean deleteByValue(int value) {
        // Empty list
        if (length == 0) {
            return false;
        }

        Node currentNode = head;
        Node previousNode = tail;  // start previous at tail

        // Use a do-while loop to ensure we process at least one node
        do {
            if (currentNode.value == value) {
                // Case 1: Only one node in the list.
                if (head == tail) {
                    head = null;
                    tail = null;
                }
                // Case 2: Deleting the head node.
                else if (currentNode == head) {
                    head = head.next;
                    tail.next = head;
                }
                // Case 3: Deleting the tail node.
                else if (currentNode == tail) {
                    tail = previousNode;
                    tail.next = head;
                }
                // Case 4: Deleting a node in the middle.
                else {
                    previousNode.next = currentNode.next;
                }
                length--;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        } while (currentNode != head);

        // Value not found in the list.
        return false;
    }
}
