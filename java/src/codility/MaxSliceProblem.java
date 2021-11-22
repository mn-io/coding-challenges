package codility;

import java.util.Arrays;

// https://codility.com/media/train/7-MaxSlice.pdf
public class MaxSliceProblem {
    public static void main(String[] args) {
        final int[] a = {5, -7, 3, 5, -2, 4, -1};
        final int solution = solutionMaxEnding(a);
        if (10 != solution) throw new AssertionError();
    }

    private static int solutionMaxEnding(int[] a) {
        int maxEnding = 0;
        int maxSlice = 0;
        for (int i : a) {
            final int nextMaxEnding = maxEnding + i;
            System.out.printf("Next Max Ending: %d (%d+%d)%n", nextMaxEnding, maxEnding, i);
            maxEnding = Math.max(0, nextMaxEnding);
            maxSlice = Math.max(maxSlice, maxEnding);
            System.out.printf("Max Ending: %d%nMaxSlice: %d%n%n", maxEnding, maxSlice);
        }

        return maxSlice;
    }

    private static int solutionPrefix(int[] a) {
        final int[] prefixSums = Arrays.copyOf(a, a.length);
        Arrays.parallelPrefix(prefixSums, Integer::sum);

        System.out.println(Arrays.toString(prefixSums));

        int maxResult = 0;
//        int maxResultNaiv = 0;
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = i; j < a.length; j++) {
                System.out.printf("interval: %d - %d", i, j);
                int sum = prefixSums[j] - prefixSums[i - 1];

//                int sumNaiv = 0;
//                for (int k = i; k <= j; k++) {
//                    sumNaiv += a[k];
//                }
                System.out.printf(", sum:%d, sumNaiv:%d%n", sum, 0); //sumNaiv
                maxResult = Math.max(sum, maxResult);
            }
            System.out.println();
        }

        return maxResult;
    }

    private static int solutionNaiv(int[] a) {
        int maxResult = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                System.out.printf("interval: %d - %d", i, j);
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += a[k];
                }
                System.out.printf(", sum: %d%n", sum);
                maxResult = Math.max(sum, maxResult);
            }
            System.out.println();
        }
        return maxResult;
    }
}
