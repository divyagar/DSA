
/**
 * Transitive Closure
 * 
 * The reachability matrix of a graph is called transitive closure of a graph.
 * Given transitive closure of a directed graph, we can find which vertex can
 * reach which other vertices.
 * 
 * Floyd warshall algorithm is used to find transitive closure of a graph.
 * 
 * Output :
 * 
 * Enter the number of vertices : 
 * 4
 * Enter the number of edges : 
 * 4
 * Enter the edges : 
 * 0 3
 * 0 1
 * 1 2
 * 2 3
 * true true true true 
 * false true true true 
 * false false true true 
 * false false false true 
 */

import java.util.Scanner;

public class TransitiveClosure {
	private static boolean[][] transitiveClosure;
	private static int vertices, edges;

	private static void initializeTransitiveClosure() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices : ");
		vertices = sc.nextInt();
		System.out.println("Enter the number of edges : ");
		int edges = sc.nextInt();

		transitiveClosure = new boolean[vertices][vertices];
		System.out.println("Enter the edges : ");

		for (int i = 0; i < edges; ++i) {
			// src dest
			int src = sc.nextInt(), dest = sc.nextInt();
			transitiveClosure[src][dest] = true;
		}
	}

	private static void findTransitiveClosure() {
		for (int i = 0; i < vertices; ++i) {
			transitiveClosure[i][i] = true;
			for (int j = 0; j < vertices; ++j) {
				if (i == j)
					continue;
				for (int k = j + 1; k < vertices; ++k) {
					if (i == k)
						continue;
					transitiveClosure[j][k] = transitiveClosure[j][k] || (transitiveClosure[j][i] && transitiveClosure[i][k]);
					transitiveClosure[k][j] = transitiveClosure[k][j] || (transitiveClosure[k][i] && transitiveClosure[i][j]);
				}
			}
		}

		for (int i = 0; i < vertices; ++i) {
			for (int j = 0; j < vertices; ++j) {
				System.out.print(transitiveClosure[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		initializeTransitiveClosure();
		findTransitiveClosure();
	}
}