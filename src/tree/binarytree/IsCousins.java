package tree.binarytree;

/*
993. 二叉树的堂兄弟节点（简单）
【描述】
在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
【示例】
示例 1：
输入：root = [1,2,3,4], x = 4, y = 3
输出：false
示例 2：
输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
输出：true
示例 3：
输入：root = [1,2,3,null,4], x = 2, y = 3
输出：false
【提示】
1）二叉树的节点数介于 2 到 100 之间。
2）每个节点的值都是唯一的、范围为 1 到 100 的整数。
 */
public class IsCousins {
    private TreeNode xParent;
    private TreeNode yParent;
    private int levelX;
    private int levelY;

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, null, 4, null, 5};
        TreeNode root = TreeNode.constructTree(array);
        boolean result = new IsCousins().isCousins(root, 5, 4);
        System.out.println("The tree is balanced:" + result);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        traverse(root, x, y, 1);
        return (this.levelX == this.levelY && this.xParent != this.yParent);
    }

    private void traverse(TreeNode node, int x, int y, int level) {
        handleNode(node, node.left, x, y, level);
        handleNode(node, node.right, x, y, level);
    }

    private void handleNode(TreeNode parent, TreeNode child, int x, int y, int level) {
        if (child != null) {
            if (child.val == x) {
                this.markNodeX(parent, level);
            } else if (child.val == y) {
                this.markNodeY(parent, level);
            } else {
                traverse(child, x, y, level + 1);
            }
        }
    }

    private void markNodeX(TreeNode node, int level) {
        this.xParent = node;
        this.levelX = level;
    }

    private void markNodeY(TreeNode node, int level) {
        this.yParent = node;
        this.levelY = level;
    }
}
