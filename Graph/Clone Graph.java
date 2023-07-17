import java.util.*;
import java.io.*;

/***************************************************************************
 * 
 * Class for graph node is as follows:
 * 
 * class graphNode {
 * public int data;
 * public ArrayList<graphNode> neighbours;
 * 
 * graphNode() {
 * data = 0;
 * neighbours = new ArrayList<graphNode>();
 * }
 * 
 * graphNode(int val) {
 * data = val;
 * neighbours = new ArrayList<graphNode>();
 * }
 * 
 * graphNode(int val, ArrayList<graphNode> neighbours) {
 * data = val;
 * this.neighbours = neighbours;
 * }
 * }
 * 
 ******************************************************************************/

public class Solution {
    public static graphNode cloneGraph(graphNode node) {
        // Write your code here.
        Map<graphNode, graphNode> umap = new HashMap<>();
        Queue<graphNode> q = new LinkedList<>();

        q.offer(node);
        graphNode a = new graphNode(node.data);
        umap.put(node, a);

        while (!q.isEmpty()) {
            graphNode fr = q.poll();

            for (graphNode j : fr.neighbours) {
                if (umap.containsKey(j))
                    umap.get(fr).neighbours.add(umap.get(j));
                else {
                    graphNode newNode = new graphNode(j.data);
                    umap.put(j, newNode);
                    umap.get(fr).neighbours.add(newNode);
                    q.offer(j);
                }
            }
        }

        return umap.get(node);
    }
}