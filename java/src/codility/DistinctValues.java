package codility;

import java.util.HashSet;

// https://app.codility.com/programmers/lessons/6-sorting/distinct/
public class DistinctValues {
    public static void main(String[] args) {
        int[] in = new int[]{2, 1, 1, 2, 3, 1};
        assertEquals(3, solution(in));
    }

    private static void assertEquals(int expected, int acutal) {
        if (expected != acutal) {
            throw new IllegalArgumentException("%d != %d ".formatted(expected, acutal));
        }
    }

    private static int solution(int[] in) {
        HashSet<Integer> distinctValues = new HashSet<>();
        for (int i : in) {
            distinctValues.add(i);
        }
        return distinctValues.size();
    }
}
