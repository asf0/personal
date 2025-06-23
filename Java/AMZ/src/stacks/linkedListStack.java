package stacks;

public class linkedListStack {
    private Node top;

    private class Node{
        int data;
        Node next;
    }

    public linkedListStack() {
        this.top = null;
    }

    public void push(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = top; // point new node to the current top
        top = newNode;
        System.out.println(data + " added to the stack");
    }

    public int pop(){
        if (top == null){
            System.out.println("Stack is empty");
            return -1;
        } else{
            int poppedValue = top.data;
            top = top.next;
            System.out.println(poppedValue + " removed from the stack");
            return poppedValue;
        }
    }

    public int peek(){
        if (top == null){
            System.out.println("Stack is empty");
            return -1;
        } else {
            int peekValue = top.data;
            System.out.println("Top value is " + peekValue);
            return peekValue;
        }
    }
}
