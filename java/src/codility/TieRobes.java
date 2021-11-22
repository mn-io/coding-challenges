package codility;

import java.util.Arrays;

// https://app.codility.com/programmers/lessons/16-greedy_algorithms/tie_ropes/
// https://codesays.com/2014/solution-to-tie-ropes-by-codility/
public class TieRobes {
    public static void main(String[] args) {
        final int[] a = {1, 2, 3, 4, 1, 1, 3};
        int solution = solution(a, 4);
        if (solution != 3) throw new AssertionError();
    }

    private static int solution(int[] a, int k) {
        int count = 0;
        int length = 0;

        for (int rope : a) {
            length += rope;
            if (length >= k) {
                count++;
                length = 0;
            }
        }
        return count;
    }

    private static int solutionSomethingIncorrect(int[] a, int k) {
        final int[] prefixSums = Arrays.copyOf(a, a.length);
        Arrays.parallelPrefix(prefixSums, Integer::sum);

        System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(prefixSums));

        int counter = 0;
        for (int i = 0; i < prefixSums.length - 1; i++) {
            for (int j = i + 1; j < prefixSums.length; j++) {
                final int m = prefixSums[j];
                final int n = i == 0 ? 0 : prefixSums[i - 1];
                int sum = m - n;
                if (sum >= k) {
                    System.out.printf("i:%d, j:%d, sum:%d = (%d - %d) %n", i, j, sum, m, n);
                    counter++;
                    i = j;
                    break;
                }
            }
            System.out.println();
        }
        return counter;
    }
}
