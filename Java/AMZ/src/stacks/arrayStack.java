package stacks;

public class arrayStack {
    private int[] stack; // arrat to store stack elements
    private int top; // top of the stack(index of the top element)

    public arrayStack(int size) {
        stack = new int[size]; //create an array of the given size
        top = -1; //initialize the top to -1, indicating an empty stack
    }
    // push adds to the top of the stack
    public void push(int value) {
        if (top == stack.length - 1) { //checj if the stack is full
            System.out.println("Stack is full");
        } else {
            stack[++top] = value; //increment top and add the value
            System.out.println(value + " added to the arraystack");
            System.out.println(top);
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int poppedValue = stack[top--];
            System.out.println(poppedValue + " removed from the arraystack");
            return poppedValue;
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int peekedValue = stack[top];
            System.out.println("Top Value: " + peekedValue);
            return peekedValue;
        }
    }

    public static void main(String[] args) {
        arrayStack arrayStack = new arrayStack(10);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.pop();
        arrayStack.peek();

    }
}
