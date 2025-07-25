package dp;

/*
45. 跳跃游戏 II（中等）
【描述】
给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
【示例】
示例 1:
输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:
输入: nums = [2,3,0,1,4]
输出: 2
【提示】
1）1 <= nums.length <= 104
2）0 <= nums[i] <= 1000
3）题目保证可以到达 nums[n-1]
 */
public class Jump {

    public static void main(String[] args) {
        //int[] nums = new int[]{2, 3, 0, 1, 4};
        //int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums = new int[]{1, 2, 1, 1, 1};
        long start = System.currentTimeMillis();
        int result = new Jump().jump(nums);
        System.out.println("算法执行时间:" + (System.currentTimeMillis() - start) + "MS");
        System.out.println("执行结果：" + result);
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = Math.min(nums.length - i - 1, nums[i]);
            for (int j = 1; j <= n; j++) {
                dp[i + j] = dp[i + j] == 0 ? dp[i] + 1 : Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
