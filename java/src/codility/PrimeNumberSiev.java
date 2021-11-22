package codility;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrimeNumberSiev {
    public static void main(String[] args) {
        int n = 17;
        int[] solution = solution(n);
        if (!Arrays.equals(solution, new int[]{2, 3, 5, 7, 11, 13, 17})) throw new AssertionError();
    }

    private static int[] solution(int n) {
        final Boolean[] sieve = new Boolean[n + 1];
        Collections.nCopies(n + 1, true).toArray(sieve);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (sieve[i]) { // is potential prime there
                int k = i * i; // start at i^2
                System.out.println(k);
                for (int j = k; j <= n; ) {
                    System.out.println(" - " + j);
                    sieve[j] = false;
                    j += i;
                    printSieve(sieve);
                }
            }
        }

        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                list.add(i);
            }
        }

        final int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }

        System.out.println(Arrays.toString(ints));
        return ints;
    }

    private static void printSieve(Boolean[] sieve) {
        for (int i = 0; i < sieve.length; i++) {
            System.out.print(MessageFormat.format("{0}: {1}, ", i, sieve[i] ? "_" : "f"));
        }
        System.out.println();
    }
}
