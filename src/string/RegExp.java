package string;

/**
 * @author: FondaWu
 * @create: 2022-01-29 20:02
 * @description: ${description}
 **/
public class RegExp {

    public static void main(String[] args) {
        //String s = "mississippi", p = "mis*is*p*.";
        //String s = "aab", p = "c*a*b";
        //String s = "aa", p = "a";
        //String s = "abcd", p = "d*";
        String s = "abcd", p = "c*";
        System.out.println(isMatch(s, p));
    }

    public static Boolean isMatch(String text, String regexp) {
        if (regexp.isEmpty() )
            return text.isEmpty();
        if (regexp.length() > 1 && regexp.charAt(1) == '*') {
            return matchStar(regexp.charAt(0), regexp.substring(2), text);
        }
        if (!text.isEmpty() && (regexp.charAt(0) == '.' || regexp.charAt(0) == text.charAt(0))) {
            return isMatch(text.substring(1), regexp.substring(1));
        }
        return false;
    }

    private static Boolean matchStar(char c, String regexp, String text) {
        do {
            if (isMatch(text, regexp)) {
                return true;
            }
            if (text.isEmpty() || (text.charAt(0) != c && c != '.'))
                break;
            text = text.substring(1);
        } while (true);
        return false;
    }
}

