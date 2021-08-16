/**
 * Prims algorithm
 * 
 * The idea is to start from a vertex and update weight of edges of
 * all connected vertices. Then find the minimum weight edge and
 * add that weight to answer. Repeat this process until all vertices are visited.
 * 
 * Output : 
 * Enter number of vertices : 
 * 5
 * Enter number of edges : 
 * 7
 * Enter edges : 
 * 0 1 2
 * 0 3 6
 * 1 2 3
 * 1 3 8
 * 1 4 5
 * 2 4 7
 * 3 4 9
 * Total weight : 16
 */

package minimum_spanning_tree;

import java.util.*;

public class PrimAlgo {
	private static int[][] graph;
	private static int vertices;
	private static Scanner sc = new Scanner(System.in);
	private static boolean added[];
	private static int weight[];

	private static void initializeGraph() {
		System.out.println("Enter number of vertices : ");
		vertices = sc.nextInt();
		System.out.println("Enter number of edges : ");
		int edges = sc.nextInt();
		graph = new int[vertices][vertices];

		for (int i = 0; i < vertices; ++i) {
			for (int j = 0; j < vertices; ++j) {
				graph[i][j] = -1;
			}
		}

		System.out.println("Enter edges : ");
		// src dest weight
		for (int i = 0; i < edges; ++i) {
			int src = sc.nextInt(), dest = sc.nextInt(), weight = sc.nextInt();
			graph[src][dest] = weight;
			graph[dest][src] = weight;
		}
	}

	// update the weights of adjacent vertices of a vertex
	private static void updateWeights(int vertex) {
		for (int i = 0; i < vertices; ++i) {
			if (!added[i] && graph[vertex][i] > -1) {
				weight[i] = Math.min(weight[i], graph[vertex][i]);
			}
		}
	}

	// find vertex that has minimum weight and is not yet added
	private static Integer findMinWeight() {
		Integer i = null;
		for (int j = 0; j < vertices; ++j) {
			if (!added[j]) {
				if (i == null || (weight[j] < weight[i]))
					i = j;
			}
		}

		return i;
	}

	private static int findMST() {
		added = new boolean[vertices];
		weight = new int[vertices];
		int totalWeight = 0;

		for (int i = 0; i < vertices; ++i) {
			weight[i] = Integer.MAX_VALUE;
		}

		weight[0] = 0;
		Integer next = 0;
		for (int i = 0; i < vertices; ++i) {
			added[next] = true;
			totalWeight += weight[next];
			updateWeights(next);
			next = findMinWeight();
		}

		return totalWeight;
	}

	public static void main(String[] args) {
		initializeGraph();
		System.out.println("Total weight : " + findMST());
	}

}
