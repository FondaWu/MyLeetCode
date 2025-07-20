package tree.binarytree;

import java.util.*;

public class TreeTraversal {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14};
        TreeNode root = TreeNode.constructTree(array);
        List<Integer> result = inorderTraversal(root);
        System.out.println("The result is:" + Arrays.toString(result.toArray()));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> dataList = new ArrayList<>();
        traversal(root, dataList, 0);
        return dataList;
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> dataList = new ArrayList<>();
        traversal(root, dataList, 1);
        return dataList;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> dataList = new ArrayList<>();
        traversal(root, dataList, 2);
        return dataList;
    }

    private static void traversal(TreeNode node, List<Integer> dataList, int type) {
        if (node == null) return;
        if (type == 0) dataList.add(node.val);
        traversal(node.left, dataList, type);
        if (type == 1) dataList.add(node.val);
        traversal(node.right, dataList, type);
        if (type == 2) dataList.add(node.val);
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode node;
        List<List<Integer>> lists = new ArrayList<>();
        int parentCount = 1, childCount = 0;
        List<Integer> list = new ArrayList<>();
        while (parentCount > 0) {
            parentCount--;
            node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                childCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                childCount++;
            }
            if (parentCount == 0){
                parentCount = childCount;
                childCount = 0;
                lists.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return lists;
    }

}
