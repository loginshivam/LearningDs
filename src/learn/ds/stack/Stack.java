package learn.ds.stack;

public class Stack {

	public static void main(String args[]) {

		StackImpl stack = new StackImpl();
		System.out.println("Is empty -> " + stack.isEmpty());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("Is empty -> " + stack.isEmpty());
		System.out.println("Top value remove -> " + stack.pop());
		System.out.println("Top at -> " + stack.getTop());
		stack.push(100);
		System.out.println("Now removed -> " + stack.pop());
		System.out.println("Top at -> " + stack.getTop());

	}

}

class StackImpl {
	int top = -1;
	final static int size = 10;
	int[] stack;

	StackImpl() {
		this.stack = new int[size];
	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		int val = stack[top];
		top--;
		return val;
	}

	public void push(int ele) {
		top++;
		if (top >= size) {
			System.out.println("Stack is full");
			top--;
		}
		stack[top] = ele;
	}

	public int getTop() {
		return stack[top];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

}
