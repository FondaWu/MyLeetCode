package tree.binarytree;

import java.util.*;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,null,null,5};
        TreeNode root = TreeNode.constructTree(array);
        List<List<Integer>> lists = new LevelOrderTraversal().levelOrder(root);
        lists.forEach(l -> System.out.println(Arrays.toString(l.toArray())));
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        // 特殊情况处理，如果树根节点为空，返回空列表
        if (root == null) return new ArrayList<>();

        // 存储所有层节点列表的列表
        List<List<Integer>> lists = new ArrayList<>();
        // 当前层节点列表
        List<Integer> list = new ArrayList<>();
        // 定义一个队列，临时存放所访问的树节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 首先将树的根节点放入队列中
        queue.add(root);
        TreeNode node;

        // 初始化当前父节点个数为1（即根节点），以及子节点个数
        int curLevelCount = 1, nextLevelCount = 0;

        while (curLevelCount > 0) {
            // 从队列里弹出一个父节点，并将父节点数据减1
            node = queue.poll();
            curLevelCount--;
            // 将此父节点放入当前层节点列表
            list.add(node.val);
            // 如果此节点左子节点不为空，放入队列中，并将子节点数目加1
            if (node.left != null) {
                queue.add(node.left);
                nextLevelCount++;
            }
            // 如果此节点右子节点不为空，放入队列中，并将子节点数目加1
            if (node.right != null) {
                queue.add(node.right);
                nextLevelCount++;
            }
            // 如果当前层父节点访问完毕
            if (curLevelCount == 0){
                // 将当前层节点，拷贝到结果列表中，并进行清空
                lists.add(new ArrayList<>(list));
                list.clear();
                // 然后将下一层所有节点作为当前层节点，重启新一轮的遍历
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        // 最后返回结果
        return lists;
    }
}

