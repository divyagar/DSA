package strongly_connected_graphs;

/**
 * Kosaraju's algorithm is used to find whether a graph is strongly connected or not.
 * 
 * The idea of kosaraju's algorithm is that if a vertex can reach all other vertices,
 * and if the same vertices is reached by all other vertices, then the graph is strongly
 * connected graph.
 * 
 * Implementation : First check if a vertex can reach all other vertices,
 * then transpose it
 * then check whether a vertex in transposed graph can reach all other vertices.
 * 
 * Output: 
 * 
 * ---------------------------------------------------------------------------------------
 * 
 * Enter the number of vertices
 * 5
 * Enter the number of edges
 * 6
 * Enter edges: 
 * 0 1
 * 1 2
 * 2 3
 * 3 0
 * 2 4
 * 4 2
 * Connected : Yes
 * 
 * ----------------------------------------------------------------------------------------
 * 
 * Enter the number of vertices
 * 4
 * Enter the number of edges
 * 3
 * Enter edges: 
 * 0 1
 * 1 2
 * 2 3
 * Connected : No
 */

import java.util.*;

public class KosarajuAlgo {
	private static List<List<Integer>> graph, transposedGraph;
	private static int vertices, edges;
	static Scanner sc = new Scanner(System.in);
	private static boolean visited[];

	private static void initializeGraph() {
		System.out.println("Enter the number of vertices");
		vertices = sc.nextInt();

		System.out.println("Enter the number of edges");
		edges = sc.nextInt();
		graph = new ArrayList<List<Integer>>();

		System.out.println("Enter edges: ");
		for (int i = 0; i < vertices; ++i) {
			graph.add(new ArrayList());
		}

		for (int i = 0; i < edges; ++i) {
			int v = sc.nextInt(), u = sc.nextInt();
			graph.get(v).add(u);
		}
	}

	private static boolean checkConnectivity(List<List<Integer>> g) {
		visited = new boolean[vertices];
		dfs(0, g);

		for (int i = 0; i < vertices; i++) {
			if (!visited[i])
				return false;
		}

		return true;
	}

	private static void dfs(int root, List<List<Integer>> g) {
		if (visited[root])
			return;

		visited[root] = true;
		List<Integer> lst = g.get(root);
		for (int num : lst)
			dfs(num, g);
	}

	private static void transposeGraph() {
		transposedGraph = new ArrayList();

		for (int i = 0; i < vertices; ++i) {
			transposedGraph.add(new ArrayList());
		}

		for (int i = 0; i < vertices; ++i) {
			List<Integer> lst = graph.get(i);
			for (int n : lst) {
				transposedGraph.get(n).add(i);
			}
		}
	}

	public static void main(String[] args) {
		initializeGraph();

		boolean connected = checkConnectivity(graph);
		if (connected) {
			transposeGraph();
			connected = connected && checkConnectivity(transposedGraph);
		}

		System.out.println("Connected : " + (connected ? "Yes" : "No"));
	}
}
