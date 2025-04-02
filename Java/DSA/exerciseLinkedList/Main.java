package exerciseLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.push(5); // Success
        singlyLinkedList.push(10);    // Success
        singlyLinkedList.push(15);
        singlyLinkedList.push(20);
//        singlyLinkedList.insert(12, 2);
//        singlyLinkedList.insert(13, 100);
//        System.out.println(singlyLinkedList.size);
//        System.out.println(singlyLinkedList.head.value);
//        System.out.println(singlyLinkedList.head.next.value);
//        System.out.println(singlyLinkedList.head.next.next.value);
//        singlyLinkedList.get(0);
//        singlyLinkedList.get(1);
//        singlyLinkedList.get(2);
//        singlyLinkedList.get(3);
        System.out.println(singlyLinkedList.set(2, 100)); // true
        System.out.println(singlyLinkedList.set(4, 100)); // false
    }
}
