package number;

public class BaseNeg2 {

    public static void main(String[] args) {
        System.out.println("计算结果：" + new BaseNeg2().baseNeg2(4));
    }

    public String baseNeg2(int n) {
        // 定义一个字符串生成器
        StringBuilder sb = new StringBuilder();
        // 当前数据总和
        int sum = 0;
        // 当前位数值
        int curDigitVal = 1;
        // 当前最高值
        int top = 2;
        while (true) {
            // 如果计入当前位数值，计算当前剩余数值
            int remaining = n - sum - curDigitVal;
            // 计算当前剩余数值是否合法：即目前后面位数不得为1
            if ((remaining & (top - 1)) == 0) {
                // 如果合法，计入当前位数值，字符串生成器加“1”
                sum += curDigitVal;
                sb.append(1);
            } else {
                // 如果合法，计入当前位数值，字符串生成器加“0”
                sb.append(0);
            }
            // 如果当前数据总和等于目标值，跳出循环
            if (sum == n) {
                break;
            }
            // 当前负二进制位数左移1位
            curDigitVal *= -2;
            // 当前最高位左移1位
            top <<= 1;
        }

        return sb.reverse().toString();
    }

    public String baseNeg21(int n) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int i = 0;
        while (true) {
            int curDigitVal = (int) Math.pow(-2, i++);
            int mask = (1 << i) - 1;
            int tmp = n - sum - curDigitVal;
            if (tmp % 2 == 0 && (tmp & mask) == 0) {
                sum += curDigitVal;
                sb.append(1);
            } else {
                sb.append(0);
            }
            if (sum == n) {
                break;
            }
        }

        return sb.reverse().toString();
    }
}
