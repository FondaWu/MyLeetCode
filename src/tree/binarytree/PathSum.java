package tree.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
113. 路径总和 II（中等）
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点。
【示例】
示例 1：
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
示例 2：
输入：root = [1,2,3], targetSum = 5
输出：[]
示例 3：
输入：root = [1,2], targetSum = 0
输出：[]
【提示】
1）树中节点总数在范围 [0, 5000] 内
2）-1000 <= Node.val <= 1000
3）-1000 <= targetSum <= 1000
 */
public class PathSum {
    private List<List<Integer>> resultLists = new ArrayList<>();
    private List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = TreeNode.constructTree(array);
        List<List<Integer>> resultLists  = new PathSum().pathSum(root, 22);
        System.out.println("The result is:");
        for (List<Integer> resultList : resultLists)
            System.out.println(Arrays.toString(resultList.toArray()));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return resultLists;
    }

    private void traverse(TreeNode node, int targetSum) {
        if (node == null) return;

        resultList.add(node.val);
        targetSum -= node.val;

        if (targetSum == 0 && node.left == null && node.right == null) {
            List<Integer> list = new ArrayList<>();
            list.addAll(resultList);
            resultLists.add(list);
        }
        if (node.left != null)
            traverse(node.left, targetSum);
        if (node.right != null)
            traverse(node.right, targetSum);
        resultList.remove(resultList.size() - 1);
    }
}
