package stacks;

import java.util.Stack;

public class main {
    public static void main(String[] args) {
        // create a stack of intengers
//        Stack<Integer> stack = new Stack<>();
//        // push element onto the stack
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//
//        int popValue = stack.pop();
//        System.out.println("Pop Value: " + popValue);
//        // display the stack
//        System.out.println("Stack after pop: " + stack);
//        int topValue = stack.peek();
//        System.out.println("Top Value: " + topValue);
//        System.out.println("Stack after peek: " + stack.peek());

        Stack<String> history = new Stack<>();
        history.push("google.com");
        history.push("facebook.com");
        history.push("youtube.com");
        System.out.println("History after adding websites:" + history);
        String peeked = history.peek();
        System.out.println("Last visited website: " + peeked);
        String popped = history.pop();
        System.out.println("Went back from: " + popped);
        System.out.println("History after going back: " + history);

        Stack<Double> doubleStack = new Stack<>();

//        linkedListStack nstack = new linkedListStack();
//        nstack.push(1);
//        nstack.push(20);
//        nstack.push(30);
//        nstack.pop();
//        System.out.println("Stack after push: " + nstack);
    }
}
