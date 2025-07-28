import java.util.Arrays;

public class DoArray {

    private static void basicArray() {
        int[] arr = {1, 2, 3, 4, 5};

        for (int n: arr) {
            System.out.println(n);
        }
    }

    public static String cloneArray(int[] arr) {
        return Arrays.toString(arr.clone());
    }

    public static String sortArray(int[] arr) {
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }

    public static int searchArray(int[] arr, int target) {
        return Arrays.binarySearch(arr, target);
    }
    public static void main(String[] args) {
        basicArray();
        System.out.println(cloneArray(new int[] {1, 2, 3, 4, 5}));
        System.out.println(sortArray(new int[] {3, 4, 6, 1, 7}));
        System.out.println(searchArray(new int[] {1, 2, 3, 4, 5}, 3));
    }
}