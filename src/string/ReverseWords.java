package string;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args) {
        String s = "hello    world";
        String result = reverseWords(s);
        System.out.println("result = " + result);
    }


    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (start == -1)
                    start = i;
            } else {
                if (start != -1) {
                    if (sb.length() > 0)
                        sb.insert(0, ' ');
                    sb.insert(0, s, start, i);

                    start = -1;
                }
            }
        }
        if (start != -1) {
            sb.insert(0, ' ');
            sb.insert(0, s, start, s.length());
        }
        return sb.toString();
    }

    public static String reverseWords3(String s) {
        s = s.trim();
        List<String> strList = new ArrayList<>();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (start == -1)
                    start = i;
            } else {
                if (start != -1) {
                    strList.add(s.substring(start, i));
                    start = -1;
                }
            }
        }
        if (start != -1) {
            strList.add(s.substring(start));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = strList.size() - 1; i >= 0; i--) {
            sb.append(strList.get(i));
            if (i != 0)
                sb.append(" ");
        }

        return sb.toString();
    }

    public static String reverseWords2(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        List<String> strList = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() > 0) {
                    strList.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if (sb.length() > 0 && strList.size() > 0)
            sb.append(" ");
        for (int i = strList.size() - 1; i >= 0; i--) {
            sb.append(strList.get(i));
            if (i != 0)
                sb.append(" ");
        }

        return sb.toString();
    }

    public static String reverseWords1(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
            if (i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }

}
