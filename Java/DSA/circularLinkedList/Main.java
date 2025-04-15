package circularLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCSLL(5);
        csll.inserCSLL(4,0);
        csll.inserCSLL(3,8);
        System.out.println("CSLL created with value: " + csll.head.value);
        csll.traverseCSLL();
    }
}
