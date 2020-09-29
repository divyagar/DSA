# Articulation Points in graph

* A vertex V in a graph G with C connected components is an articulation point if its removal increases the number of connected components of G.

## How to find articulation points?
### Naive approach O(V * (V + E))
```
    For every vertex V in the graph G do
        Remove V from G
        if the number of connected components increases then V is an articulation point
        Add V back to G
```

### Tarjan's approach O(V + E)
- First, we need to know that an ancestor of some node V is a node A that was discoverd before V in a DFS traversal.
- Let's say there is a node V in some graph G that can be reached by a node U through some intermediate nodes (maybe non intermediate nodes) following some DFS traversal, if V can also be reached by A = "ancestor of U" without passing through U then, U is NOT an articulation point because it means that if we remove U from G we can still reach V from A, hence, the number of connected components will remain the same.
- So, we can conclude that the only 2 conditions for U to be an articulation point are:
    1. If all paths from A to V require U to be in the graph
    1. If U is the root of the DFS traversal with at least 2 children subgraphs disconnected from each other.

## Implementation
```java
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

```

