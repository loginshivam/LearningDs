package learn.function;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;

	}
}

public class DSTest {

	public static void main(String args[]) {
		System.out.println("Hello World");
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		// right tree
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(10);
		root.right.right.right.left = new Node(11);

		System.out.println("Printing In order ->");
		inOrderTravel(root);

		System.out.println("\nPrinting Pre order ->");
		preOrderTravel(root);

		System.out.println("\nPrinting Post order ->");
		postOrderTravel(root);

		System.out.println("\nPrinting Depth Of a tree ->");
		System.out.println(depthOfTree(root));

		System.out.println("Is Balanced ->");
		String str = (checkTreeBalance(root) == -1) ? "Not Balanced" : "Balanced";
		System.out.println(str);

	}

	public static void inOrderTravel(Node node) {
		if (node == null) {
			return;
		}
		inOrderTravel(node.left);
		System.out.print(node.data + " ");
		inOrderTravel(node.right);
	}

	public static void preOrderTravel(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrderTravel(node.left);
		preOrderTravel(node.right);
	}

	public static void postOrderTravel(Node node) {
		if (node == null) {
			return;
		}
		postOrderTravel(node.left);
		postOrderTravel(node.right);
		System.out.print(node.data + " ");
	}

	public static int depthOfTree(Node node) {
		if (node == null) {
			return 0;
		}
		int left = depthOfTree(node.left);
		int right = depthOfTree(node.right);
		return 1 + Math.max(left, right);
	}

	public static int checkTreeBalance(Node node) {
		if (node == null) {
			return 0;
		}

		int left = checkTreeBalance(node.left);
		int right = checkTreeBalance(node.right);

		if (left == -1 || right == -1) {
			return -1;
		}

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return 1 + Math.max(left, right);

	}

}
