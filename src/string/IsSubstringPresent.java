package string;

public class IsSubstringPresent {

    public static void main(String[] args) {
        String s = "abcd";
        boolean result = new IsSubstringPresent().isSubstringPresent(s);
        System.out.println("计算结果:" + result);
    }

    public boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        for (int i = 0; i < s1.length() - 1; i++) {
            String tmp = s1.substring(i, i + 2);
            if (s.indexOf(tmp) != -1)
                return true;
        }
        return false;
    }

}
