package codility;

import java.util.Arrays;

public class MinMaxDivision {
    public static void main(String[] args) {
        final int[] a = {2, 1, 5, 1, 2, 2, 2};
        int solution = solution(3, 5, a);
        if (solution != 5) throw new AssertionError();
    }

    private static int solution(int k, int m, int[] a) {
        int lowerBound = Arrays.stream(a).max().getAsInt();
        int upperBound = Arrays.stream(a).sum();

        int blocksneeded = 0;
        int result = 0;
        while (lowerBound <= upperBound) {
            int maxMid = lowerBound + upperBound / 2;
            blocksneeded = blockNo(a, maxMid);
            if (blocksneeded <= k) {
                upperBound = maxMid - 1;
                result = maxMid;
            } else {
                lowerBound = maxMid + 1;
            }
        }
        return result;
    }

    private static int blockNo(int[] a, int maxBlock) {
        int blocksNo = 1;
        int preBlockSum = a[0];
        for (int i = 1; i < a.length; i++) {
            if (preBlockSum + a[i] > maxBlock) {
                preBlockSum = a[i];
                blocksNo++;
            } else {
                preBlockSum += a[i];
            }
        }

        return blocksNo;
    }
}
