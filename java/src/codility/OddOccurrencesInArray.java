package codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] ints = {9, 3, 9, 3, 9, 7, 9};
        int solution = solution(ints);
        if (solution != 7) throw new AssertionError();
    }

    private static int solution(int[] ints) {
        final Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            int value = ints[i];
            Integer counter = values.get(value);
            if (counter == null) {
                counter = 1;
            } else {
                counter++;
            }
            values.put(value, counter);
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : values.entrySet()) {
            if(integerIntegerEntry.getValue() == 1) {
                return integerIntegerEntry.getKey();
            }
        }

        throw new IllegalStateException("Premises not met");
    }
}
