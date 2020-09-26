// Program to find all articulation points in a graph

// An articulation point is a vertex in an undirected connected graph iff removing it disconnects the graph.They are used to designing reliable networks.
// They represents vulnerability in a connected network.

// Alogithm : The idea is to use DFS. In DFS, a vertex u is parent of another vertex v, if v is discovered by u. In DFS, a vertex u is articulation point
// if one of the condition is true:

// 1. u is root and it has at lease 2 children.
// 2. u is not root and it has a child v such that no vertex in subtree rooted with v has a back edge to one of the ancestors of u.


package Algos;
import java.util.*;
public class Articulation_Points_In_Graph {
	static List<List<Integer>> graph = new ArrayList<List<Integer> >();
	static List<Integer> ans = new ArrayList<Integer>();
	static int[] inTime, lowTime;
	static int time = 2;
	static boolean[] visited;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		inTime = new int[vertices+1];
		lowTime = new int[vertices+1];
		visited = new boolean[vertices+1];
		for(int i = 0; i<=vertices; i++){
			graph.add(new ArrayList<Integer>());
		}
		
		int edges = sc.nextInt();
		for(int i = 0; i<edges; i++){
			int u = sc.nextInt(), v = sc.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		findArticulation();
		Set<Integer> finalAns = new HashSet<Integer>(ans);
		System.out.println(finalAns);
		
	}
	
	static void findArticulation(){
		inTime[1] = 1;
		lowTime[1] = 1;
		visited[1] = true;
		dfs(1);
	}
	
	static void dfs(int element){
		int size = graph.get(element).size();
		int i = 0;
		while(i < size){
			// if element is one and i is not first child
			if(element == 1 && i > 0){
				// if child of element is not visited that means that current child is not connected to previous childs. That in turn means removal of 
				// root will result in disconnected graph.
				if(!visited[graph.get(element).get(i)])
					ans.add(1);
			}
			
			int ele = graph.get(element).get(i);
			if(!visited[ele]){
				inTime[ele] = time;
				lowTime[ele] = time;
				time++;
				visited[ele] = true;
				dfs(ele);
				// If lowTime of child which is just visited is less than lowTime of element then assign lowTime of child to lowTime of element
				if(lowTime[ele] < lowTime[element]){
					lowTime[element] = lowTime[ele];
				}
				// If lowTime of child is equal to inTime of element that means that removal of element will result in disconnected graph
				if(lowTime[ele] == inTime[element] && element != 1)
					ans.add(element);
			}
			else{
				// If current child is already visited and inTime of child is less than lowTime of element, which means back edge
				if(inTime[ele] < lowTime[element]){
					lowTime[element] = inTime[ele];
				}
			}
			i++;
		}
		
	}
}
