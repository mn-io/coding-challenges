package codility;

import java.util.Arrays;
import java.util.Comparator;

public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 2, 1, 4, 0};
        int solution = solution(a);
        System.out.println(solution);
        if (solution != 11) throw new AssertionError();
    }

    private static int solution(int[] a) {
        final long[][] circles = new long[a.length][2];
        for (int i = 0; i < a.length; i++) {
            final int v = a[i];
            final long start = i - v;
            final long end = i + v;

            System.out.printf("start %d with radius %d (%d,%d)%n", i, v, start, end);

            circles[i] = new long[]{start, end};
        }

        final int beginFlag = 0;
        final int endFlag = 1;
        final long[][] circlePoints = new long[circles.length * 2][2];
        for (int i = 0; i < circles.length; i++) {
            circlePoints[i * 2] = new long[]{circles[i][0], beginFlag};
            circlePoints[i * 2 + 1] = new long[]{circles[i][1], endFlag};
        }
        Arrays.sort(circlePoints, Comparator.comparingLong(o -> o[0]));

        int intersections = 0;
        int activeCircles = 0;
        for (long[] circlePoint : circlePoints) {
            System.out.println(Arrays.toString(circlePoint));
            final boolean isBeginning = circlePoint[1] == beginFlag;
            if (isBeginning) {
                intersections += activeCircles;
                activeCircles++;
            } else {
                activeCircles--;
            }
        }

        return intersections;
    }
}
