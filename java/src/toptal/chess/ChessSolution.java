package toptal.chess;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// https://www.reddit.com/r/freelance/comments/4mucmn/i_failed_the_toptal_coding_test/
public class ChessSolution {
    public static void main(String[] args) {
        assertEquals(4, solution(new Point(12, 8)));
    }

    private static int solution(Point dest) {
        Map<Point, Point> visitedPointsFromStart = new HashMap<>();
        Map<Point, Point> visitedPointsFromDest = new HashMap<>();
        Deque<Point> toVisitFromStart = new ArrayDeque<>();
        Deque<Point> toVisitFromDest = new ArrayDeque<>();

        Point start = new Point(0, 0);
        toVisitFromStart.addLast(start);
        toVisitFromDest.addLast(dest);

        while (!toVisitFromStart.isEmpty() || !toVisitFromDest.isEmpty()) {
            Point currentStart = toVisitFromStart.pollFirst();
            if (currentStart != null) {
                System.out.printf("checking from start %s, queue size: %d%n", currentStart, toVisitFromStart.size());
                int pathLength = getPathLength(start, currentStart, dest, visitedPointsFromDest);
                if (pathLength >= 0) {
                    return pathLength;
                }

                fillQueue(currentStart, toVisitFromStart, visitedPointsFromStart);
            }

            Point currentDest = toVisitFromDest.pollFirst();
            if (currentDest != null) {
                System.out.printf("checking from dest %s, queue size: %d%n", currentDest, visitedPointsFromDest.size());
                int pathLength = getPathLength(dest, currentDest, start, visitedPointsFromStart);
                if (pathLength >= 0) {
                    return pathLength;
                }

                fillQueue(currentDest, toVisitFromDest, visitedPointsFromDest);
            }
        }

        return -1;
    }

    private static int getPathLength(Point start, Point currentStart, Point dest, Map<Point, Point> visitedPointsFromDest) {
        if (dest.equals(currentStart)) {
            return currentStart.getLength();
        }

        if (visitedPointsFromDest.containsKey(currentStart) && !currentStart.equals(start)) {
            int currentLength = currentStart.getLength();
            int lengthFromOtherQueue = visitedPointsFromDest.get(currentStart).getLength();
            return currentLength + lengthFromOtherQueue;
        }

        return -1;
    }

    private static void fillQueue(Point current, Deque<Point> toVisit, Map<Point, Point> visitedPoints) {
        for (Point nextPoint : current.getNext()) {
            boolean hasKey = visitedPoints.containsKey(nextPoint);
            if (hasKey) {
                continue;
            }
            visitedPoints.put(nextPoint, nextPoint);
            toVisit.addLast(nextPoint);
        }
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new IllegalArgumentException("%d != %d ".formatted(expected, actual));
        }
    }

}
