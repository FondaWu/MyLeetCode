package string;

public class Multiply {

    public static void main(String[] args) {
        String num1 = "2", num2 = "3";
        String result  = new Multiply().multiply(num1, num2);
        System.out.println(result);
    }

    private String multiply(String num1, String num2) {
        int i, j;
        int sum;
        int len = num1.length() + num2.length();
        int[] map = new int[len];
        for (i = num1.length() - 1; i >= 0; i--) {
            for (j = num2.length() - 1; j >= 0; j--) {
                sum = (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
                map[len - i - j - 2] += sum;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (i = 0; i < len - 1; i++) {
            map[i + 1] += map[i] / 10;
            sb.append(map[i] % 10);
        }
        sb.append(map[i] % 10);
        String result = sb.reverse().toString().replaceAll("^0+", "");
        return result.equals("") ? "0" : result;
    }

}
