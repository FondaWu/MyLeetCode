package string;

public class IntToRoman {

    public static void main(String[] args) {
        String result = intToRoman(1994);
        System.out.println(result);
    }

    private static String intToRoman(int num) {
        String[] romains = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num < nums[i]) {
                i++;
                continue;
            }
            num -= nums[i];
            sb.append(romains[i]);
        }

        return sb.toString();
    }

    private static String intToRoman2(int num) {
        char[] romains = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};

        int i = 0;
        StringBuilder sb = new StringBuilder();
        int n = num / 1000;
        if (n > 0) {
            for (i = 0; i < n; i++) {
                sb.append('I');
            }
            sb.append('M');
            num -= 1000 * n;
        }
        return "";
    }

    private static String intToRoman1(int num) {
        char[] romains = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};

        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = 0;
            for (; i < nums.length; i++) {
                if (num < nums[i])
                    break;
            }
            if (i > 0) {
                int n = num / nums[i - 1];
                for (int j = 0; j < n; j++)
                    sb.append(romains[i - 1]);
                num -= n * nums[i - 1];
            } else {
                for (int j = 0; j < num; j++) {
                    sb.append(romains[0]);
                }
                break;
            }
        }
        return sb.toString();
    }

}
