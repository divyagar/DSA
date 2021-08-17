package shortest_path_algorithm;

import java.util.*;
import java.util.Map.Entry;

public class Dijkstra_Algo {
	static List<HashMap<Integer, Integer>> graph = new ArrayList<HashMap<Integer, Integer>>();
	static int vertices, edges, startingPoint;
	static HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
	static boolean[] visited;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		vertices = sc.nextInt();
		for (int i = 0; i < vertices; i++) {
			graph.add(new HashMap<Integer, Integer>());
		}
		edges = sc.nextInt();
		for (int i = 0; i < edges; i++) {
			int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
			graph.get(u).put(v, w);
			graph.get(v).put(u, w);
		}

		startingPoint = sc.nextInt();
		for (int i = 0; i < vertices; i++)
			distances.put(i, Integer.MAX_VALUE);

		visited = new boolean[vertices];
		dijkstra();
		System.out.println(distances);
	}

	static void dijkstra() {
		int count = 0;
		distances.put(startingPoint, 0);
		int root = startingPoint;
		while (true) {
			visited[root] = true;
			count++;

			for (Entry ele : graph.get(root).entrySet()) {
				int key = (Integer) ele.getKey();
				if (!visited[key]) {
					int dist = distances.get(root) + ((Integer) ele.getValue());
					int originalDist = distances.get(key);
					if (dist < originalDist) {
						distances.put(key, dist);
					}
				}

			}

			distances = sortByValue(distances);
			if (count < vertices) {
				for (Entry ele : distances.entrySet()) {
					if (!visited[(Integer) ele.getKey()]) {
						root = (Integer) ele.getKey();
						break;
					}
				}
			} else {
				break;
			}
		}
	}

	static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
}
