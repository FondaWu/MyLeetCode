package tree.binarytree;

import java.util.*;

public class LevelOrderBottom {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.constructTree(array);
        List<List<Integer>> lists = new LevelOrderBottom().levelOrderBottom(root);
        lists.forEach(l -> System.out.println(Arrays.toString(l.toArray())));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode node;
        List<List<Integer>> lists = new ArrayList<>();
        int parentCount = 1, childCount = 0;
        List<Integer> list = new ArrayList<>();
        while (parentCount > 0) {
            node = queue.poll();
            parentCount--;
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
                lists.add(0, new ArrayList<>(list));
                list.clear();
            }
        }
        return lists;
    }
}
