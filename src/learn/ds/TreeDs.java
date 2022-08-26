package learn.ds;

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

public class TreeDs {

	public static void main(String[] args) {
		System.out.println("Stroring Tree in Java");
		// storing tree in Java
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(10);
		root.right.right.right.right = new Node(11);

		System.out.print("Tree in order travel ->    ");
		inOrderTravel(root);
		System.out.print("\nPreOrder travel ->         ");
		preOrderTravel(root);
		System.out.print("\nPost Order travel ->       ");
		postOrderTravel(root);
		System.out.print("\nDepth of a tree ->         ");
		System.out.print(depthOfATree(root));
		System.out.println("\n If Tree is Balanced -> ");
		System.out.println(checkIfTreeIsBalanced(root) == -1 ? false : true);

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

	public static int depthOfATree(Node node) {

		if (node == null) {
			return 0;
		}

		return 1 + Math.max(depthOfATree(node.left), depthOfATree(node.right));
	}

	public static int checkIfTreeIsBalanced(Node node) {
		if (node == null) {
			return 0;
		}
		int left = checkIfTreeIsBalanced(node.left);
		int right = checkIfTreeIsBalanced(node.right);
		if (left == -1 || right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return 1 + Math.max(left, right);
	}
}
