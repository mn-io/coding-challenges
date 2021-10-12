package codility;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        if (!arrayEquals(solution(new int[]{3, 8, 9, 7, 6}, 3), new int[]{9, 7, 6, 3, 8})) throw new AssertionError();
        if (!arrayEquals(solution(new int[]{1, 2, 3, 4}, 4), new int[]{1, 2, 3, 4})) throw new AssertionError();

        if (!arrayEquals(solution(new int[]{}, 4), new int[]{})) throw new AssertionError();
        if (!arrayEquals(solution(new int[]{}, 0), new int[]{})) throw new AssertionError();
        if (!arrayEquals(solution(new int[]{}, 100), new int[]{})) throw new AssertionError();
    }

    public static int[] solution(int[] A, int K) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[(i + K) % A.length] = A[i];
        }

        return result;
    }

    public static boolean arrayEquals(int[] expected, int[] actual) {
        return Arrays.equals(expected, actual);
    }
}
