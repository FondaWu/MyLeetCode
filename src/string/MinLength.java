package string;

public class MinLength {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println("运行结果：" + minLength(s));
    }

    public static int minLength(String s) {
        final String[] strs = new String[]{"AB", "CD"};

        int count;
        while (true) {
            count = 0;
            for (int i = 0; i < strs.length; i++) {
                int j = s.indexOf(strs[i]);
                if (j != -1) {
                    s = s.substring(0, j) + s.substring(j + 2);
                    count++;
                }
            }
            if (count == 0) break;
        }
        return s.length();
    }
}
