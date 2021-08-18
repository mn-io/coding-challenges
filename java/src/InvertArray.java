import java.util.Arrays;

public class InvertArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = invert(arr);
        System.out.println(Arrays.toString(arr2));
    }

    private static int[] invert(int[] arr) {
        int[] tmp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[arr.length - i - 1];
        }
        return tmp;
    }
}
