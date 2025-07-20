package tree;

import tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSum {

    private static List<List<Integer>> resultLists = new ArrayList<>();

    public static void main(String[] args) {
        //Integer[] array = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        Integer[] array = new Integer[]{1, -2, -3, 1, 3, -2, null, -1};
        TreeNode root = TreeNode.constructTree(array);
        List<List<Integer>> resultLists = pathSum(root, -1);
        for (List<Integer> resultList : resultLists)
            System.out.println("The result is:" + Arrays.toString(resultList.toArray()));
    }

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> resultList = new ArrayList<>();
        traverse(root, targetSum, resultList);
        return resultLists;
    }

    private static void traverse(TreeNode node, int targetSum, List<Integer> resultList) {
        if (node == null) return;

        resultList.add(node.val);
        targetSum -= node.val;

        if (targetSum == 0 && node.left == null && node.right == null) {
            List<Integer> list = new ArrayList<>();
            list.addAll(resultList);
            resultLists.add(list);
        }
        if (node.left != null)
            traverse(node.left, targetSum, resultList);
        if (node.right != null)
            traverse(node.right, targetSum, resultList);
        resultList.remove(resultList.size() - 1);
    }
}
