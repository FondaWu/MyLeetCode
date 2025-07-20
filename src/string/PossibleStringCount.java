package string;

public class PossibleStringCount {

    public static void main(String[] args) {
        String word = "abbcccc";
        int result = new PossibleStringCount().possibleStringCount(word);
        System.out.println("The result is:" + result);
    }

    public int possibleStringCount(String word) {
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1))
                count++;
        }
        return count;
    }

}
