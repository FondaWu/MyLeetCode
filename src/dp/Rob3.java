package dp;

import common.Utils;
import tree.binarytree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
337. 打家劫舍 III（中等）
【描述】
小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果
两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
【示例】
示例 1:
输入: root = [3,2,3,null,3,null,1]
输出: 7
解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
示例 2:
输入: root = [3,4,5,1,3,null,1]
输出: 9
解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
【提示】
1）树的节点数在 [1, 104] 范围内
2）0 <= Node.val <= 104
 */
public class Rob3 {
    private Map<Integer, Integer> intResultCache = new HashMap<>();

    public int rob(TreeNode root) {
        return rob(root, false);
    }

    private int rob(TreeNode node, boolean parent) {
        // 节点为空，返回0
        if (node == null) {
            return 0;
        }
        // 获取当前节点hashcode，如果父节点被抢劫，hashcode加1
        int hashCode = node.hashCode() + (parent == true ? 1 : 0);
        int result = intResultCache.getOrDefault(hashCode, 0);
        // 如果缓存不包含当前节点
        if (!intResultCache.containsKey(hashCode)) {
            // 如果当前节点父节点被抢劫，那么当前节点不能被抢劫，只能计算两个子节点之和
            if (parent) {
                result = rob(node.left, false) + rob(node.right, false);
            } else { // 如果当前节点父节点不被抢劫，那么当前节点可以选择抢劫或不抢劫
                // 当前节点被抢劫, 当前节点抢劫最大金额等于本节点现金加上两个子节点之和
                int result1 = node.val + rob(node.left, true) + rob(node.right, true);
                // 当前节点不被抢劫, 当前节点抢劫最大金额等于两个子节点之和
                int result2 = rob(node.left, false) + rob(node.right, false);
                // 取两种情况最大值
                result = Math.max(result1, result2);
            }
            // 将计算结果缓存起来
            intResultCache.put(hashCode, result);
        }
        return result;
    }
}
