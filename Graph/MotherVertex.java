import java.util.*;
public class MotherVertex {
	static List<List<Integer>> graph;
	static int mother;
	static boolean[] visited;
	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
		graph = new ArrayList();
		int v = 5;
		List<Integer> lst = new ArrayList();
		
		for(int i = 0; i<v; i++) {
			graph.add(new ArrayList());
		}
		
		graph.get(0).add(2);
		graph.get(0).add(3);
		graph.get(1).add(0);
		graph.get(2).add(1);
		graph.get(3).add(4);
		
		visited = new boolean[v];
		for(int i = 1; i<v; i++) {
			if(!visited[i])
				dfs(i);
		}
		System.out.println(mother);
	}
	
	private static void dfs(int root) {
		visited[root] = true;
		List<Integer> lst = graph.get(root);
		int size = lst.size();
		for(int i = 0; i<size; i++) {
			if(!visited[lst.get(i)]) {
				dfs(lst.get(i));
			}
		}
		mother = root;
	}
	
}
