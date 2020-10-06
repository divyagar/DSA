// program to find k-cores of a graph
// k - cores of a graph are connected components that are left after all vertices of degree less than k are removed from graph.

import java.util.*;
import java.util.Map.Entry;
public class k_cores_of_a_graph {
	static HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
	static int vertices, edges, k;
	static boolean[] visited;
	static int degrees[];
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		vertices = sc.nextInt();
		edges = sc.nextInt();
		k = sc.nextInt();
		
		for(int i = 0; i<edges; i++){
			int u = sc.nextInt(), v = sc.nextInt();
			List<Integer> lst;
			lst = graph.getOrDefault(u, new ArrayList<Integer>());
			lst.add(v);
			graph.put(u, lst);
			lst = graph.getOrDefault(v, new ArrayList<Integer>());
			lst.add(u);
			graph.put(v, lst);
		}
		
		degrees = new int[vertices];
		for(Entry<Integer, List<Integer>> entry : graph.entrySet()){
			degrees[entry.getKey()] = entry.getValue().size();
		}
		
		visited = new boolean[vertices];
		dfs(0);
		for(int i = 0; i<vertices; i++){
			if(degrees[i] >= k){
				System.out.print(i + " -> ");
				for(int j = 0; j<graph.get(i).size(); j++){
					if(degrees[graph.get(i).get(j)] >= k)
						System.out.print(graph.get(i).get(j) + " ");
				}
				System.out.println();
			}
		}
	}
	
	private static boolean dfs(int element){
		visited[element] = true;
		for(int i = 0; i<graph.get(element).size(); i++){
			if(degrees[element] < k){
				degrees[graph.get(element).get(i)]--;
			}
			
			if(!visited[graph.get(element).get(i)]){
				if(dfs(graph.get(element).get(i)))
					degrees[element]--;
			}
			
		}
		
		if(degrees[element] < k)
			return true;
		
		return false;
	}
}
