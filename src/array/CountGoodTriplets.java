package array;

public class CountGoodTriplets {

    public static void main(String[] args) {
        int arr[] = {3, 0, 1, 1, 9, 7}, a = 7, b = 2, c = 3;
        //int arr[] = {1, 1, 2, 2, 3}, a = 0, b = 0, c = 1;
        int result = new CountGoodTriplets().countGoodTriplets(arr, a, b, c);
        System.out.println("The result is:" + result);
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c)
                        result++;
                }
            }
        }
        return result;
    }
}
