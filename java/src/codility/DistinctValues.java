package codility;

import java.util.Arrays;
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

    public static int solution(int[] in) {
        Arrays.sort(in);

        int prevI = 0;
        int counter = 0;
        for (int i : in) {
            if (prevI != i) {
                counter++;
            }
            prevI = i;
        }

        return counter;
    }

    private static int solution1(int[] in) {
        HashSet<Integer> distinctValues = new HashSet<>();
        for (int i : in) {
            distinctValues.add(i);
        }
        return distinctValues.size();
    }
}
