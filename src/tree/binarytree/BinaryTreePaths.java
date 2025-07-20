package tree.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, null, 5};
        TreeNode root = TreeNode.constructTree(array);
        List<String> result = binaryTreePaths(root);
        System.out.println("The result is:" + Arrays.toString(result.toArray()));
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        traverse(root, "", result);
        return result;

    }

    private static void traverse(TreeNode node, String s, List<String> result) {
        StringBuffer sb = new StringBuffer(s);
        if (s != "") {
            sb.append("->");
        }
        sb.append(node.val);
        String t = sb.toString();
        if (node.left != null || node.right != null) {
            if (node.left != null)
                traverse(node.left, t, result);
            if (node.right != null)
                traverse(node.right, t, result);
        } else {
            result.add(t);
        }
    }
}
