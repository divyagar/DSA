# Bridges in a graph
- We say that an edge UV in a graph G with C connected components is a bridge if its removal increases the number of connected components of  G.

- The idea for the implementation is exactly the same as for articulation points except for one thing, to say that the edge UV is a bridge, the condition to satisfy is: `discovery_time[U] < low[V]` instead of `discovery_time[U] <= low[V]`.

- If discovery_time[U] is equal to low[V] it means that there is a path from V that goes back to U ( V in this case represents an adjacent node of U ), or in other words we can just say that we found a cycle rooted in U. For articulation points if we remove U from the graph it will increase the number of connected components, but in the case of bridges if we remove the edge UV the number of connected components will remain the same. For bridges we need to be sure that the edge UV is not involved in any cycle. A way to be sure of this is just to check that low[V] is strictly greater than discovery_time[U].

## Implementation
```java
    package Algos;
import java.util.*;
public class Bridges_In_A_Graph {
	static List<List<Integer>> graph = new ArrayList<List<Integer> >();
	static int[] inTime, lowTime;
	static int time = 2;
	static boolean[] visited;
	static int vertices, edges, count = 0;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		vertices = sc.nextInt();
		for(int i = 0; i<vertices; i++){
			graph.add(new ArrayList<Integer>());
		}
		
		edges = sc.nextInt();
		for(int i = 0; i<edges; i++){
			int u = sc.nextInt(), v = sc.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		inTime = new int[vertices];
		lowTime = new int[vertices];
		visited = new boolean[vertices];
		findBridges();
		System.out.println(count);
	}
	
	static void findBridges(){
		visited[0] = true;
		inTime[0] = 1;
		lowTime[0] = 1;
		dfs(0, 0);
	}
	
	static void dfs(int element, int parent){
		int size = graph.get(element).size();
		for(int i = 0; i<size; i++){
			int child = graph.get(element).get(i);
			if(!visited[child]){
				inTime[child] = time;
				lowTime[child] = time;
				time++;
				visited[child] = true;
				dfs(child, element);
				if(lowTime[child] < lowTime[element]){
					lowTime[element] = lowTime[child];
				}
				if(inTime[element] < lowTime[child]){
					count++;
				}
			}

			else{
				if(parent != child){
					if(inTime[child] < lowTime[element]){
						lowTime[element] = inTime[child];
					}
				}
			}
		}
	}
}

```