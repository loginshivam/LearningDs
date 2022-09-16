package learn.ds.stack;

public class Main {
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(5);
		lru.put(10, 100);
		lru.printDLL();
		lru.put(20, 200);
		lru.printDLL();
		lru.put(30, 300);
		lru.printDLL();
		lru.put(40, 400);
		lru.printDLL();
		lru.put(50, 500);
		lru.printDLL();
		lru.put(20, 600);
		lru.printDLL();
		lru.put(70,200);
		lru.printDLL();
	}

}
