package tree.binarytree;

import java.util.*;

public class AverageOfLevels {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3,9,20,15,7};
        TreeNode root = TreeNode.constructTree(array);
        List<Double> list = averageOfLevels(root);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode node;
        List<Double> list = new ArrayList<>();
        int parentCount = 1, childCount = 0, tmp = 1;
        double value = 0.0;
        while (parentCount > 0) {
            parentCount--;
            node = queue.poll();
            value += node.val;
            if (node.left != null) {
                queue.add(node.left);
                childCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                childCount++;
            }
            if (parentCount == 0){
                list.add(value / tmp);
                value = 0.0;
                tmp = parentCount = childCount;
                childCount = 0;
            }
        }
        return list;
    }

}
