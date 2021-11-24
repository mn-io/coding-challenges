package codility;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// https://funnelgarden.com/dominator-codility-solution/
// https://app.codility.com/programmers/lessons/8-leader/dominator/
public class Dominator {

    public static record CountPos(AtomicInteger count, List<Integer> positions) {
    }

    public static void main(String[] args) {
        int[] solution = solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3});
        assert Arrays.equals(solution, new int[]{0, 2, 4, 6, 7});
    }

    private static int[] solution(int[] ints) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(ints[0]);

        for (int i : ints) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                final Integer peek = stack.peek();
                if (peek == null) {
                    throw new IllegalStateException("should not happen");
                }
                if (peek == i) {
                    stack.push(i);
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return new int[]{-1};
        }

        int dominator = stack.peek();
        int[] positions = new int[ints.length];
        Arrays.fill(positions, -1);
        int currentPosition = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == dominator) {
                positions[currentPosition] = i;
                currentPosition++;
            }
        }


        return Arrays.copyOf(positions, currentPosition);
    }


    private static int[] solution2(int[] a) {
        // map: Value -> {Count, Pos[]}
        final Map<Integer, CountPos> map = new HashMap<>();
        int maxCount = -1;
        Integer maxValue = null;
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            final CountPos existingMapping = map.get(value);
            if (existingMapping == null) {
                final ArrayList<Integer> positions = new ArrayList<>();
                positions.add(i);
                final CountPos newMapping = new CountPos(new AtomicInteger(1), positions);
                map.put(value, newMapping);
                maxValue = value;
                maxCount = 1;
            } else {
                final int newCount = existingMapping.count.incrementAndGet();
                existingMapping.positions.add(i);
                if (newCount > maxCount) {
                    maxCount = newCount;
                    maxValue = value;
                }
            }
        }

        if (maxCount <= a.length / 2) {
            return new int[]{};
        }

        final List<Integer> positions = map.get(maxValue).positions();
        final int[] result = new int[positions.size()];
        for (int i = 0; i < positions.size(); i++) {
            result[i] = positions.get(i);
        }
        return result;
    }
}
