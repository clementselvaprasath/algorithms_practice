package leetcode.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the
 * graph looks like the following:
 * 
 * 1 / \ / \ 0 --- 2 / \ \_/
 * 
 * @author qz
 *
 */
public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		// <K, V> = <orignal node, new Node>
		Map<UndirectedGraphNode, UndirectedGraphNode> map = cloneNodes(node);

		for (UndirectedGraphNode orignal : map.keySet()) {
			for (UndirectedGraphNode neighbor : orignal.neighbors) {
				map.get(orignal).neighbors.add(map.get(neighbor));
			}
		}

		return map.get(node);
	}

	private Map<UndirectedGraphNode, UndirectedGraphNode> cloneNodes(UndirectedGraphNode root) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			UndirectedGraphNode n = q.poll();
			map.put(n, new UndirectedGraphNode(n.label));
			for (UndirectedGraphNode neighbor : n.neighbors) {
				if (!map.containsKey(neighbor)) {
					q.offer(neighbor);
				}
			}
		}

		return map;
	}

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
}
