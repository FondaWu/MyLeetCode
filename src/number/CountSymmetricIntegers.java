package number;

/**
 * 2843. 统计对称整数的数目（简单）
 * 【描述】
 * 给你两个正整数 low 和 high 。
 * 对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。
 * 返回在 [low, high] 范围内的 对称整数的数目 。
 * 【示例】
 * 示例 1：
 * 输入：low = 1, high = 100
 * 输出：9
 * 解释：在 1 到 100 范围内共有 9 个对称整数：11、22、33、44、55、66、77、88 和 99 。
 * 示例 2：
 * 输入：low = 1200, high = 1230
 * 输出：4
 * 解释：在 1200 到 1230 范围内共有 4 个对称整数：1203、1212、1221 和 1230 。
 * <p>
 * 【提示】
 * 1 <= low <= high <= 104
 */
public class CountSymmetricIntegers {
    public static void main(String[] args) {
        //int low = 1, high = 100;
        int low = 1200, high = 1230;
        int result = new CountSymmetricIntegers().countSymmetricIntegers(low, high);
        System.out.println("计算结果：" + result);
    }

    public int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            String str = Integer.toString(i);
            int len = str.length();
            if (len % 2 == 0) {
                int count1 = 0;
                for (int j = 0; j < len / 2; j++) {
                   count1 += Character.getNumericValue(str.charAt(j));
                }
                int count2 = 0;
                for (int k = len / 2; k < len; k++) {
                    count2 += Character.getNumericValue(str.charAt(k));
                }
                if (count1 == count2) result++;
            }
        }
        return result;
    }

    public int countSymmetricIntegers1(int low, int high) {
        int result = 0;
        for (int i = low; i < high; i++) {
            String str = Integer.toString(i);
            int len = str.length();
            if (len % 2 == 0) {
                String str1 = str.substring(0, len / 2);

                String str2 = str.substring(len / 2, len);
                result++;
            }
        }
        return result;
    }

}
