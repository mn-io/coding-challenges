package toptal.chess;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// https://www.reddit.com/r/freelance/comments/4mucmn/i_failed_the_toptal_coding_test/
public class ChessSolution {
    public static void main(String[] args) {
        assertEquals(4, solution(new Point(12, 8)));
    }

    private static int solution(Point dest) {
        Set<Point> visitedPoints = new HashSet<>();
        Deque<Point> toVisit = new ArrayDeque<>();

        Point start = new Point(0, 0);
        toVisit.addLast(start);

        while (!toVisit.isEmpty()) {
            Point current = toVisit.removeFirst();
            System.out.printf("checking %s, queue size: %d%n", current, toVisit.size());
            if (current.equals(dest)) {
                System.out.println(" - is matching dest");
                return current.getLength();
            }

            Set<Point> nextPoints = current.getNext();
            for (Point nextPoint : nextPoints) {
                boolean added = visitedPoints.add(nextPoint);
                if (!added) {
                    continue;
                }
                toVisit.addLast(nextPoint);
            }
        }

        return -1;
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new IllegalArgumentException("%d != %d ".formatted(expected, actual));
        }
    }

}
