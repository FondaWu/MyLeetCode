package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations2 {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> charList = new ArrayList<>();
        appendAndAdd(digits.toCharArray(), "", charList, 0);
        return charList;
    }

    private static void appendAndAdd(char[] characters, String prefix, List<String> result, Integer index) {
        if (index < characters.length) {
            String firstNum = String.valueOf(characters[index]);
            List<String> firstStr = convertNumToStr(firstNum);
            Integer finalIndex = index + 1;
            firstStr.forEach(f -> {
                appendAndAdd(characters, prefix + f, result, finalIndex);
            });
        } else {
            result.add(prefix);
        }
    }

    private static List<String> convertNumToStr(String firstNum) {
        return mapping.getOrDefault(firstNum, new ArrayList<>());
    }

    private static Map<String, List<String>> mapping = new HashMap<>();

    static {
        ArrayList<String> strings2 = new ArrayList<>();
        strings2.add("a");
        strings2.add("b");
        strings2.add("c");
        mapping.put("2", strings2);
        ArrayList<String> strings3 = new ArrayList<>();
        strings3.add("d");
        strings3.add("e");
        strings3.add("f");
        mapping.put("3", strings3);
        ArrayList<String> strings4 = new ArrayList<>();
        strings4.add("g");
        strings4.add("h");
        strings4.add("i");
        mapping.put("4", strings4);
        ArrayList<String> strings5 = new ArrayList<>();
        strings5.add("j");
        strings5.add("k");
        strings5.add("l");
        mapping.put("5", strings5);
        ArrayList<String> strings6 = new ArrayList<>();
        strings6.add("m");
        strings6.add("n");
        strings6.add("o");
        mapping.put("6", strings6);
        ArrayList<String> strings7 = new ArrayList<>();
        strings7.add("p");
        strings7.add("q");
        strings7.add("r");
        strings7.add("s");
        mapping.put("7", strings7);
        ArrayList<String> strings8 = new ArrayList<>();
        strings8.add("t");
        strings8.add("u");
        strings8.add("v");
        mapping.put("8", strings8);
        ArrayList<String> strings9 = new ArrayList<>();
        strings9.add("w");
        strings9.add("x");
        strings9.add("y");
        strings9.add("z");
        mapping.put("9", strings9);
    }
}
