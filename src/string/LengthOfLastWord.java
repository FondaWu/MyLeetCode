package string;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "a ";
        System.out.println("运行结果：" + lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int count = 0, end = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count == 0) {
                if (s.charAt(i) != ' ') {
                    end = i;
                    count = 1;
                }
            } else {
                if (s.charAt(i) == ' ') {
                    return end - i;
                }
            }
        }
        return end + 1;
    }
}
