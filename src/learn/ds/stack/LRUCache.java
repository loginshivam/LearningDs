package learn.ds.stack;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	DLL dll;
	int capicity;

	Map<Integer, Node> map = new HashMap<Integer, Node>();

	LRUCache(int _capicity) {
		capicity = _capicity;
		dll = new DLL();
	}

	void put(int key, int value) {
		Node node;
		if (map.containsKey(key)) {
			node = map.get(key);
			dll.delete(node);
		} else if (map.size() >= capicity) {
			dll.delete(dll.tail.prev);
			map.remove(dll.tail.prev.key);
		}
		node = dll.insert(key, value);
		map.put(key, node);
	}

	int get(int key) {
		int val = -1;
		if (map.containsKey(key)) {
			Node node = map.get(key);
			val = node.value;
			dll.delete(node);
			node = dll.insert(key, val);
			map.put(key, node);
		}
		return val;
	}

	void printDLL() {
		Node tmp = dll.head.next;
		System.out.println("---------------------------------------------");
		while (tmp.next != null) {
			System.out.print("{" + tmp.key + ":" + tmp.value + "} ");
			tmp = tmp.next;
		}
		System.out.println("\n");
		for (int key : map.keySet()) {
			tmp = map.get(key);
			System.out.print("{" + tmp.key + ":" + tmp.value + "} ");
		}
		System.out.println("\n---------------------------------------------");
	}

}

class Node {
	int key;
	int value;
	Node prev;
	Node next;

	Node(int _key, int _value) {
		key = _key;
		value = _value;
	}

}

class DLL {

	Node head;
	Node tail;

	DLL() {
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
		tail.next = null;
		head.prev = null;

	}

	Node insert(int key, int value) {
		Node node = new Node(key, value);
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
		return node;
	}

	void delete(Node node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}

}