package learn.ds.stack;

public class Queue {

	public static void main(String[] args) {
		QueueImpl queue = new QueueImpl();
		System.out.println("Is empty -> " + queue.isEmpty());
		System.out.println("Queue size -> " + queue.size());
		queue.push(10);
		queue.push(20);
		queue.push(30);
		queue.push(40);
		System.out.println("Queue size -> " + queue.size());
		System.out.println("Top value -> " + queue.top());
		System.out.println("Pop element ->" + queue.pop());
		System.out.println("Queue top -> " + queue.top());
		queue.push(50);
		queue.push(60);
		queue.push(70);
		System.out.println("Top -> " + queue.top());
		queue.pop();
		queue.pop();
		queue.push(80);
		queue.print();

		System.out.println("\n---------------------------------");
		StackImplUsingQueue stack = new StackImplUsingQueue();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("Pop -> " + stack.pop());
		System.out.println("Size 1	 -> " + stack.size());
		System.out.println("Pop -> " + stack.pop());
		System.out.println("Size -> " + stack.size());
		System.out.println("Pop -> " + stack.pop());
		System.out.println("Pop -> " + stack.pop());
		

	}

}

class QueueImpl {
	private final static int size = 5;
	private int[] queue = new int[size];
	private int front = 0;
	private int rear = 0;
	private int count = 0;

	public void push(int val) {
		if (count >= size) {
			System.out.println("Queue is Full");
			return;
		}
		queue[rear % size] = val;
		count++;
		rear++;

	}

	public int pop() {
		if (count == 0) {
			System.out.println("Queue is Empty");
			return -1;
		}
		int val = queue[front % 5];
		front++;
		count--;
		return val;
	}

	public int top() {
		if (rear == front) {
			System.out.println("Queue is empty");
			return -1;
		}
		return queue[front % size];
	}

	public void print() {

		for (int i = front; i < rear; i++) {
			System.out.print(queue[i % size] + " ");
		}
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public int size() {
		return count;
	}

	public int popRear() {
		if (count == 0) {
			return -1;
		}
		int val = queue[rear-1 % 5];
		rear--;
		count--;
		return val;
	}

	public int topStack() {
		return rear;
	}

}

class StackImplUsingQueue {

	private QueueImpl queue = new QueueImpl();

	public void push(int val) {
		queue.push(val);
	}

	public int pop() {
		return queue.popRear();
	}

	public int size() {
		return queue.size();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
