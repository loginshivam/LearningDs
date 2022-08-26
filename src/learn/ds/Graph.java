package learn.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int n = 7; // Node of the graphs

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}

		// edge 1
		list.get(1).add(2);

		// edge 2
		list.get(2).add(1);
		list.get(2).add(4);
		list.get(2).add(7);

		// edge 3
		list.get(3).add(6);

		// edge 4
		list.get(4).add(2);
		list.get(4).add(5);

		// edge 5
		list.get(5).add(4);
		list.get(5).add(7);

		// edge 6
		list.get(6).add(3);

		// edge 7
		list.get(7).add(2);
		list.get(7).add(5);

		ArrayList<Integer> result = bfs(list, n);

		for (int i : result) {
			System.out.print(i + " ");
		}

		result = dfs(list, n);

		System.out.println("\nDFS");
		for (int i : result) {
			System.out.print(i + " ");
		}

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		n = 8; 
		for (int i=0;i<=8;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//0
		graph.get(0).add(1);
		graph.get(0).add(3);
		
		//1
		graph.get(1).add(0);
		graph.get(1).add(3);
		graph.get(1).add(2);
		
		//2
		graph.get(2).add(1);
		graph.get(2).add(6);
		
		//3
		graph.get(3).add(0);
		graph.get(3).add(1);
		graph.get(3).add(4);
		
		//4
		graph.get(4).add(3);
		graph.get(4).add(5);
		
		//5
		graph.get(5).add(4);
		graph.get(5).add(6);
		
		//6
		graph.get(6).add(2);
		graph.get(6).add(5);
		graph.get(6).add(7);
		graph.get(6).add(8);
		
		//7
		graph.get(7).add(6);
		graph.get(7).add(8);
		
		//8
		graph.get(8).add(6);
		graph.get(8).add(7);
		
		
		System.out.println("\n sortestPath -> ");
		int arr[] = shortestPath(graph, n);

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	//need a queue for travel and visit array for storing visited node and a list to store the graph values
	public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph, int vertex) {

		boolean visit[] = new boolean[vertex + 1];
		ArrayList<Integer> bfs = new ArrayList<Integer>();

		for (int i = 0; i < vertex; i++) {
			visit[i] = false;
		}

		for (int i = 1; i < vertex; i++) {

			if (!visit[i]) {

				Queue<Integer> queue = new LinkedList<Integer>();

				queue.add(i);
				visit[i] = true;

				while (!queue.isEmpty()) {

					int value = queue.poll();
					bfs.add(value);

					for (int val : graph.get(value)) {

						if (!visit[val]) {

							queue.add(val);
							visit[val] = true;

						}
					}
				}

			}
		}

		return bfs;
	}

	// recursion for depth first search and visit for storing visited node. only travel node which are not already traveled.
	public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> graph, int vertex) {

		boolean visit[] = new boolean[vertex + 1];
		ArrayList<Integer> dfs = new ArrayList<Integer>();

		for (int i = 0; i <= vertex; i++) {
			visit[i] = false;
		}

		for (int i = 1; i <= vertex; i++) {
			if (!visit[i]) {
				dfsTravel(i, graph, visit, dfs);
			}
		}

		return dfs;
	}

	public static void dfsTravel(int index, ArrayList<ArrayList<Integer>> graph, boolean visit[],
			ArrayList<Integer> dfs) {
		dfs.add(index);
		visit[index] = true;
		for (int val : graph.get(index)) {
			if (!visit[val]) {
				dfsTravel(val, graph, visit, dfs);
			}
		}

	}

	// store distance in array for each travel. only travel a node if traveled distance is less then last traveled value
	public static int[] shortestPath(ArrayList<ArrayList<Integer>> graph, int vertex) {
		int distance[] = new int[vertex+1];

		for (int i = 0; i <= vertex; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(0);
		distance[0] = 0;

		while (!queue.isEmpty()) {

			int value = queue.poll();

			for (int val : graph.get(value)) {
				if (distance[val] > distance[value] + 1) {
					queue.add(val);
					distance[val] = distance[value] + 1;
				}
			}
		}
		return distance;
	}
}
