package string;

/**
 * @author: FondaWu
 * @create: 2022-01-29 20:02
 * @description: ${description}
 **/
public class RegExp2 {

    public static void main(String[] args) {
        String s = "mississippi", p = "mis*is*p*.";
        //String s = "aa", p = "b*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        do {
            if (matchHere(p, s, false)) {
                return true;
            }
            s = s.substring(1);
        } while (!s.isEmpty());

        return false;
    }

    private static Boolean matchHere(String regexp, String text, boolean star) {
        if (regexp.isEmpty())
            return star;
        if (regexp.length() > 1 && regexp.charAt(1) == '*') {
            return matchStar(regexp.charAt(0), regexp.substring(2), text);
        }
        if (!text.isEmpty() && (regexp.charAt(0) == '.' || regexp.charAt(0) == text.charAt(0)))
            return matchHere(regexp.substring(1), text.substring(1), false);
        return false;
    }

    private static Boolean matchStar(int c, String regexp, String text) {
        while (!text.isEmpty() && (text.charAt(0) == c || c == '.')) {
            if (matchHere(regexp, text, true)) {
                return true;
            }
            text = text.substring(1);
        }
        return !regexp.isEmpty();
    }
}

