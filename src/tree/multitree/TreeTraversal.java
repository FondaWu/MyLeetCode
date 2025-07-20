package tree.multitree;

import java.util.*;

public class TreeTraversal {

    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    public List<Integer> preorder(Node root) {
        List<Integer> dataList = new ArrayList<>();
        traversal(root, dataList, 0);
        return dataList;
    }


    public List<Integer> postorder(Node root) {
        List<Integer> dataList = new ArrayList<>();
        traversal(root, dataList, 1);
        return dataList;
    }

    private static void traversal(Node node, List<Integer> dataList, int type) {
        if (node == null) return;
        if (type == 0) dataList.add(node.val);
        for (Node child : node.children)
            traversal(child, dataList, type);
        if (type == 1) dataList.add(node.val);
    }
    
}
