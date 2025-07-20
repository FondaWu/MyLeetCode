package string;

public class KthCharacter2 {

    public static void main(String[] args) {
        //long k = 10;
        //int[] operations = {0, 1, 0, 1};
        long k = 100000000000000L;
        int[] operations = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        long start = System.currentTimeMillis();
        char result = new KthCharacter2().kthCharacter(k, operations);
        System.out.println("算法执行时间:" + (System.currentTimeMillis() - start));
        System.out.println("计算结果:" + result);
    }

    public char kthCharacter(long k, int[] operations) {
        int n = 64 - Long.numberOfLeadingZeros(k - 1);
        long prevLength = (long) Math.pow(2, n - 1);
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k > prevLength) {
                k -= prevLength;
                if (operations[i] == 1)
                    count++;
            }
            prevLength >>= 1;
        }
        return (char) ('a' + (count % 26));
    }

    public char kthCharacter3(long k, int[] operations) {
        int n = 64 - Long.numberOfLeadingZeros(k - 1);
        long prevLength = (long) Math.pow(2, n - 1);
        // 递归函数：从后往前确定第k个字符
        return findChar(k, n - 1, operations, prevLength);
    }

    private char findChar(long pos, int opIndex, int[] operations, long prevLength) {
        // 基本情况：回到初始状态
        if (opIndex < 0) {
            return 'a';
        }
        long pos2 = pos > prevLength ? pos - prevLength : pos;
        char curChar = findChar(pos2, opIndex - 1, operations, prevLength >> 1);
        if (pos > prevLength && operations[opIndex] == 1)
            curChar = (curChar == 'z') ? 'a' : (char) (curChar + 1);
        return curChar;
    }

    public char kthCharacter2(long k, int[] operations) {
        StringBuilder sb = new StringBuilder("a");
        int n = 64 - Long.numberOfLeadingZeros(k - 1);
        for (int i = 0; i < n; i++) {
            int operation = operations[i];
            if (operation == 0) {
                if (sb.length() > k / 2)
                    return sb.charAt((int) (k - sb.length() - 1));
                sb.append(sb);
            } else if (operation == 1) {
                int len = sb.length();
                for (int j = 0; j < len; j++) {
                    char c = (char) (sb.charAt(j) + 1);
                    if (c == 123) c = 'a';
                    sb.append(c);
                    if (sb.length() == k)
                        return sb.charAt((int) (k - 1));
                }
            } else throw new RuntimeException("Invalid operation:" + operation);
        }

        return sb.charAt((int) (k - 1));
    }

    public char kthCharacter1(long k, int[] operations) {
        StringBuilder sb = new StringBuilder("a");
        int n = 64 - Long.numberOfLeadingZeros(k - 1);
        for (int i = 0; i < n; i++) {
            int operation = operations[i];
            if (operation == 0) {
                if (sb.length() > k / 2)
                    return sb.charAt((int) (k - sb.length() - 1));
                sb.append(sb);
            } else if (operation == 1) {
                for (int j = 0; j < sb.length(); j++) {
                    char c = (char) (((sb.charAt(j) - 'a' + 1) % 26) + 'a');
                    sb.append(c);
                    if (sb.length() == k)
                        return sb.charAt((int) (k - 1));
                }
            } else throw new RuntimeException("Invalid operation:" + operation);
        }

        return sb.charAt((int) (k - 1));
    }

}
