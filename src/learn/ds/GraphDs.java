package learn.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {

	int current;
	int parent;

	Pair(int current, int parent) {
		this.current = current;
		this.parent = parent;
	}
}

public class GraphDs {
	public static void main(String args[]) {
		System.out.println("Storing graph in java");
		int vertex = 10;
		ArrayList<ArrayList<Integer>> graph = graphStore(vertex);
		System.out.print("BFS travel -> ");
		bfsTravel(graph, vertex);
		System.out.print("\nDFS travel -> ");
		dfsTravel(graph, vertex);
		System.out.print("\ncheck if cycle exists -> ");
		String result = findCycle(graph, vertex) == true ? "Cycle exists" : "cycle does not exists";
		System.out.print(result);
		graph = graphStore1(7);
		result = findCycle(graph, 7) == true ? "Cycle exists" : "cycle does not exists";
		System.out.println("\n" + result);
	}

	public static void bfsTravel(ArrayList<ArrayList<Integer>> graph, int vertex) {
		boolean[] visit = new boolean[vertex + 1];
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		for (int i = 0; i <= vertex; i++) {
			visit[i] = false;
		}

		for (int i = 1; i <= vertex; i++) {
			if (!visit[i]) {
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(i);
				visit[i] = true;
				while (!queue.isEmpty()) {
					int ind = queue.poll();
					bfs.add(ind);
					for (int val : graph.get(ind)) {
						if (!visit[val]) {
							queue.add(val);
							visit[val] = true;
						}
					}

				}
			}
		}
		for (int val : bfs) {
			System.out.print(val + " ");
		}

	}

	public static void dfsTravel(ArrayList<ArrayList<Integer>> graph, int vertex) {
		boolean[] visit = new boolean[vertex + 1];
		for (int i = 0; i <= vertex; i++) {
			visit[i] = false;
		}
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		for (int i = 1; i <= vertex; i++) {
			if (!visit[i]) {
				dfsTravelGraph(i, graph, visit, dfs);
			}
		}

		for (int i : dfs) {
			System.out.print(i + " ");
		}

	}

	public static void dfsTravelGraph(int index, ArrayList<ArrayList<Integer>> graph, boolean[] visit,
			ArrayList<Integer> dfs) {
		visit[index] = true;
		dfs.add(index);
		for (int val : graph.get(index)) {
			if (!visit[val]) {
				dfsTravelGraph(val, graph, visit, dfs);
			}
		}

	}

	public static boolean findCycle(ArrayList<ArrayList<Integer>> graph, int vertex) {
		boolean visit[] = new boolean[vertex + 1];
		for (int i = 0; i <= vertex; i++) {
			visit[i] = false;
		}
		for (int i = 1; i <= vertex; i++) {
			if (!visit[i]) {
				Queue<Pair> queue = new LinkedList<Pair>();
				queue.add(new Pair(i, -1));
				visit[i] = true;
				while (!queue.isEmpty()) {
					Pair pair = queue.poll();
					for (int val : graph.get(pair.current)) {
						if (visit[val] && val != pair.parent) {
							return true;
						}
						if (!visit[val]) {
							queue.add(new Pair(val, pair.current));
							visit[val] = true;
						}
					}
				}
			}

		}
		return false;

	}

	public static ArrayList<ArrayList<Integer>> graphStore(int vertex) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= vertex; i++) {
			graph.add(new ArrayList<Integer>());
		}
		graph.get(1).add(2);// 1
		graph.get(1).add(3);

		graph.get(2).add(1);// 2
		graph.get(2).add(3);
		graph.get(2).add(8);

		graph.get(3).add(1);// 3
		graph.get(3).add(2);
		graph.get(3).add(4);

		graph.get(4).add(3);// 4
		graph.get(4).add(7);

		graph.get(5).add(6);// 5

		graph.get(6).add(5);// 6

		graph.get(7).add(4);// 7
		graph.get(7).add(8);

		graph.get(8).add(2);// 8
		graph.get(8).add(7);
		graph.get(8).add(9);
		graph.get(8).add(10);

		graph.get(9).add(8);// 9
		graph.get(9).add(10);//

		graph.get(10).add(9);// 10
		graph.get(10).add(8);
		return graph;
	}

	public static ArrayList<ArrayList<Integer>> graphStore1(int vertex) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= vertex; i++) {
			graph.add(new ArrayList<Integer>());
		}
		graph.get(1).add(2);// 1

		graph.get(2).add(3);// 2
		graph.get(2).add(4);

		graph.get(3).add(2);// 3
		graph.get(3).add(5);

		graph.get(4).add(2);// 4
		// graph.get(4).add(5);

		graph.get(5).add(3);// 5
		// graph.get(5).add(4);

		graph.get(6).add(7);// 6

		graph.get(7).add(6);// 7

		return graph;
	}
}
