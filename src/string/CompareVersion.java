package string;

public class CompareVersion {

    public static void main(String[] args) {
        //String version1 = "1.2", version2 = "1.10";
        String version1 = "1.01", version2 = "1.001";
        //String version1 = "1.0", version2 = "1.0.0.0";
        int result = new CompareVersion().compareVersion(version1, version2);
        System.out.println("The result is:" + result);
    }

    public int compareVersion(String version1, String version2) {
        final char split = '.';
        int start1 = 0, end1 = 0;
        int start2 = 0, end2 = 0;
        int num1 = 0, num2 = 0;
        while (end1 != -1 || end2 != -1) {
            if (end1 != -1) {
                end1 = version1.indexOf(split, start1);
                if (end1 != -1) {
                    num1 = Integer.parseInt(version1.substring(start1, end1));
                    start1 = end1 + 1;
                } else {
                    num1 = Integer.parseInt(version1.substring(start1));
                }
            } else {
                num1 = 0;
            }
            if (end2 != -1) {
                end2 = version2.indexOf(split, start2);
                if (end2 != -1) {
                    num2 = Integer.parseInt(version2.substring(start2, end2));
                    start2 = end2 + 1;
                } else {
                    num2 = Integer.parseInt(version2.substring(start2));
                }
            } else {
                num2 = 0;
            }
            if (num1 < num2)
                return -1;
            if (num1 > num2)
                return 1;
        }
        return 0;
    }

}
