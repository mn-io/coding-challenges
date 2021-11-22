package codility;

import java.util.Arrays;

// https://codility.com/media/train/3-PrefixSums.pdf
// https://de.wikipedia.org/wiki/Pr%C3%A4fixsumme
public class PrefixSums {
    public static void main(String[] args) {
        final int[] a = {2, 3, 5, 8, 6, 5, 4, 7, 5, 2, 8};

        int[] sums = new int[a.length];
        sums[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            sums[i] = sums[i - 1] + a[i];
        }

        System.out.println(Arrays.toString(sums));
    }

}
