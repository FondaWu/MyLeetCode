package number;

public class CountDigitOne {

    public static void main(String[] args) {
        int result = countDigitOne(13);
        System.out.println("The result is:" + result);

    }

    public static int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j > 0) {
                j &= j - 1;
                count++;
            }
        }
        return count;
    }
}
