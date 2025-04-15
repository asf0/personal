package circularLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCSLL(5);
        csll.inserCSLL(4,0);
        csll.inserCSLL(3,8);
        csll.inserCSLL(2,9);
        csll.traverseCSLL();
        System.out.println("CSLL created with value: " + csll.head.value);
        csll.deleteNode(0);
        csll.traverseCSLL();
        csll.deleteNode(1);
        csll.traverseCSLL();
        csll.deleteCSLL();

    }
}
