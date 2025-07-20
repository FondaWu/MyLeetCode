package graph;

import graph.base.Node;



public class CloneGraph {
    public static Node[] nodeArray;

    public static void main(String[] args) {

    }

    public static Node cloneGraph1(Node node) {
        nodeArray = new Node[100];
        return visitNode(node);
    }

    private static Node visitNode(Node node) {
        if (node == null) return null;

        nodeArray[node.val-1] = new Node(node.val);
        Node neighborNode;
        for (int i = 0; i < node.neighbors.size(); i++) {
            neighborNode = node.neighbors.get(i);
            if (neighborNode != null && nodeArray[neighborNode.val-1] == null){
                nodeArray[neighborNode.val-1] = visitNode(neighborNode);
            }
            nodeArray[node.val-1].neighbors.add(nodeArray[neighborNode.val-1]);
        }
        return nodeArray[node.val-1];
    }
}
