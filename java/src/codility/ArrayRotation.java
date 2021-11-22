package codility;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] a = new int[]{3, 8, 9, 7, 6};
        int[] solution = solution(a, 3);
        if (!Arrays.equals(solution, new int[]{9, 7, 6, 3, 8})) throw new AssertionError();
    }

    private static int[] solution(int[] a, int k) {
        int[] solution = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            final int newIndex = (i + k) % a.length;
            System.out.println("shifting " + i + " -> " + newIndex);
            solution[newIndex] = a[i];
        }
        return solution;
    }
}
