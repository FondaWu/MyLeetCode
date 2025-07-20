package tree.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void print() {
        System.out.print(this.val + " ");

        if (this.left != null) {
            this.left.print();
        } else {
            System.out.print("null ");
        }

        if (this.right != null) {
            this.right.print();
        } else {
            System.out.print("null ");
        }
    }

    public static TreeNode constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        int index = 0;
        int length = array.length;

        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeNode currNode;
        while (index < length) {
            index++;
            if (index >= length) {
                return root;
            }
            currNode = nodeQueue.poll();
            Integer leftChild = array[index];
            if (leftChild != null) {
                currNode.left = new TreeNode(leftChild);
                nodeQueue.offer(currNode.left);
            }
            index++;
            if (index >= length) {
                return root;
            }
            Integer rightChild = array[index];
            if (rightChild != null) {
                currNode.right = new TreeNode(rightChild);
                nodeQueue.offer(currNode.right);
            }
        }

        return root;
    }

    public static TreeNode constructBST(int[] nums, int start, int end) {
        if (start >= end) return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructBST(nums, start, mid);
        root.right = constructBST(nums, mid + 1, end);

        return root;
    }

    public static TreeNode prevCreatTree(int[] nums, int index) {
        //判断是否为空
        if (index >= nums.length) {
            return null;
        }

        //创建结点
        TreeNode root = new TreeNode(nums[index++]);
        root.left = prevCreatTree(nums, index + 1);
        root.right = prevCreatTree(nums, index + 2);

        return root;
    }

    public static TreeNode findNode(TreeNode root, int val) {
        if (root.val == val) return root;
        TreeNode node;
        if (root.left != null) {
            node = findNode(root.left, val);
            if (node != null)
                return node;
        }
        if (root.right != null) {
            node = findNode(root.right, val);
            if (node != null)
                return node;
        }
        return null;
    }

}
