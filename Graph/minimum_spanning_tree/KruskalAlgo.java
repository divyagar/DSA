package minimum_spanning_tree;

/**
 * KruskalAlgo
 * Idea : Sort the edges by weight. Starting with minimum weight edge, check if the addition
 * of edge will form a cycle. If not, add the edge to the MST.
 * 
 * Checking of cycle is done by using union find.
 * 
 * Output : 
 * Enter the number of vertices: 
 * 4
 * Enter the number of edges: 
 * 5
 * Enter the edges of the graph: 
 * 0 1 10
 * 0 2 6
 * 0 3 5
 * 1 3 15
 * 2 3 4
 * Edges of MST: 
 * 2 --> 3  --  4
 * 0 --> 3  --  5
 * 0 --> 1  --  10
 * Total MST weight : 19
 */

import java.util.*;
import java.util.Arrays;

class Edge {
	int src, dest, weight;

	Edge(int s, int d, int w) {
		src = s;
		dest = d;
		weight = w;
	}
}

class Graph {
	int v;
	Edge[] edges;

	Graph(int v, int e) {
		this.v = v;
		this.edges = new Edge[e];
	}
}

public class KruskalAlgo {
	private static Graph graph;
	private static int vertices, edges;
	private static Scanner sc = new Scanner(System.in);
	private static int unionFind[];

	private static void initializeGraph() {
		System.out.println("Enter the number of vertices: ");
		vertices = sc.nextInt();
		System.out.println("Enter the number of edges: ");
		edges = sc.nextInt();

		graph = new Graph(vertices, edges);
		System.out.println("Enter the edges of the graph: ");
		for (int i = 0; i < edges; i++) {
			int s = sc.nextInt(), d = sc.nextInt(), w = sc.nextInt();
			graph.edges[i] = new Edge(s, d, w);
		}

		Arrays.sort(graph.edges, (a, b) -> a.weight - b.weight);
	}

	private static int findMST() {
		unionFind = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			unionFind[i] = i;
		}

		int totalWeight = 0, totalEdges = 0, i = 0;

		System.out.println("Edges of MST: ");
		while (i < edges && totalEdges < vertices - 1) {
			Edge e = graph.edges[i];
			if (find(e.src) != find(e.dest)) {
				System.out.println(e.src + " --> " + e.dest + "  --  " + e.weight);
				union(e.src, e.dest);
				totalWeight += e.weight;
				++totalEdges;
			}

			++i;
		}

		return totalWeight;
	}

	private static void union(int a, int b) {
		unionFind[a] = unionFind[b];
	}

	private static int find(int num) {
		if (unionFind[num] == num)
			return num;

		return unionFind[num] = find(unionFind[num]);
	}

	public static void main(String[] args) {
		initializeGraph();
		System.out.println("Total MST weight : " + findMST());
	}
}