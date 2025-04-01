package linkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();
        sLL.createSinglyLinkedList(5);
        //System.out.println(sLL.head.value);
        sLL.insertSinglyLinkedList(6, 0);
        //System.out.println(sLL.head.value);
        sLL.insertSinglyLinkedList(7, 2);
        sLL.insertSinglyLinkedList(8, 1);
        sLL.insertSinglyLinkedList(9, 0);
        //System.out.println(sLL.tail.value);
        sLL.traverseSinglyLinkedList();
        sLL.searchNode(7);
        sLL.deletionOfNode(6);
        sLL.traverseSinglyLinkedList();
        sLL.deleteSinglyLinkedList();
        sLL.traverseSinglyLinkedList();

    }
}
