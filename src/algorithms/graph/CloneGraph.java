package algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Clone an undirected graph. Each node in the graph contains a label and a
	 * list of its neighbors.
	 * 
	 * How we serialize an undirected graph:
	 * 
	 * Nodes are labeled uniquely.
	 * 
	 * return a deep copied graph.
	 */
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
    	if (node.neighbors.isEmpty()) return new UndirectedGraphNode(node.label);
    	
    	// <K, V> = <old, new>
    	// add nodes
    	Map<UndirectedGraphNode, UndirectedGraphNode> map = getNodes(node);
    
    	// add edges
    	for (UndirectedGraphNode n : map.keySet()) {
    		UndirectedGraphNode newNode = map.get(n);
    		for (UndirectedGraphNode neighbor : n.neighbors) {
    			newNode.neighbors.add(map.get(neighbor));
    		}
    	}
    
    	return map.get(node);
	}
	
	private static Map<UndirectedGraphNode, UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
    	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    	Set<UndirectedGraphNode> visited = new HashSet<>();
    	Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
    	q.add(node);
    	map.put(node, new UndirectedGraphNode(node.label));
    	visited.add(node);
    	while (!q.isEmpty()) {
    		UndirectedGraphNode tmp = q.poll();
    		for (UndirectedGraphNode n : tmp.neighbors) {
    			if(!visited.contains(n)) {
    				map.put(n, new UndirectedGraphNode(n.label));
    				visited.add(n);
    				q.offer(n);
    			}
    		}
    	}
    
    	return map;
    }
}

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}