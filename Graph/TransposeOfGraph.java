
/**
 * Transpose Of Graph
 * Also called reverse of a graph
 * 
 * Output : 
 * Enter number of vertices: 
 * 5
 * Enter number of edges: 
 * 7
 * Enter edges: 
 * 0 1
 * 0 4
 * 0 3
 * 2 0
 * 3 2
 * 4 1
 * 4 3
 * Transposed graph : 
 * 0 -> 2 
 * 1 -> 0 4 
 * 2 -> 3 
 * 3 -> 0 4 
 * 4 -> 0 
 */

import java.util.*;

public class TransposeOfGraph {
	static List<List<Integer>> graph, transposedGraph;
	static int vertices, edges;
	static Scanner sc = new Scanner(System.in);

	private static void initializeGraph() {
		System.out.println("Enter edges: ");
		for (int i = 0; i < vertices; ++i) {
			graph.add(new ArrayList());
		}

		for (int i = 0; i < edges; ++i) {
			int v = sc.nextInt(), u = sc.nextInt();
			graph.get(v).add(u);
		}
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

	private static void printGraph(List<List<Integer>> g) {
		for (int i = 0; i < vertices; i++) {
			List<Integer> lst = g.get(i);
			if (lst.size() > 0) {
				System.out.print(i + " -> ");
				for (int num : lst)
					System.out.print(num + " ");
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		graph = new ArrayList();

		System.out.println("Enter number of vertices: ");
		vertices = sc.nextInt();

		System.out.println("Enter number of edges: ");
		edges = sc.nextInt();

		initializeGraph();
		transposeGraph();

		System.out.println("Transposed graph : ");
		printGraph(transposedGraph);
	}
}