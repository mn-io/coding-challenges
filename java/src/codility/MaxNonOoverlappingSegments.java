package codility;

// https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
// https://www.martinkysel.com/codility-max-nonoverlapping-segments-solution/

public class MaxNonOoverlappingSegments {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 7, 9, 9};
        int[] b = new int[]{5, 6, 8, 9, 10};
        final int solution = solution(a, b);
        if (solution != 3) throw new AssertionError();
    }

    private static int solution(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("a abd b must be equal length");
        }

        if (a.length < 1) {
            return 0;
        }
        if (a.length <= 1) {
            return 1;
        }

        int cnt = 1;
        int prevEnd = b[0];

        for (int i = 1; i < a.length; i++) {
            final int currentStart = a[i];
            final boolean isNonOverlapping = currentStart > prevEnd;
            System.out.printf("checking %d > %d%n", currentStart, prevEnd);
            if (isNonOverlapping) {
                cnt += 1;
                prevEnd = b[i];
                System.out.println("++");
            }
        }
        return cnt;
    }
}
