package array;

public class SubarraySum {

    private static int count = 0;

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        long start = System.currentTimeMillis();
        System.out.println("开始计算。。。");
        int result = subarraySum(nums, 2);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("计算结果：" + result);
    }

    public static int subarraySum(int[] nums, int k) {
        doCombinationSum(nums, 0, k);
        return count;
    }

    private static void doCombinationSum(int[] candidates, int n, int target) {
        if (target == 0) {
            count++;
        } else if (n < candidates.length) {
            doCombinationSum(candidates, n + 1, target);
            if (target >= candidates[n]) {
                doCombinationSum(candidates, n + 1, target - candidates[n]);
            }
        }
    }
}
