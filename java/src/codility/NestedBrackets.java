package codility;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

// https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
public class NestedBrackets {

    public static void main(String[] args) {
        assertEquals(true, solution("{[()()]}"));
        assertEquals(false, solution("([)()]"));
    }

    private static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) {
            throw new IllegalArgumentException("%b != %b ".formatted(expected, actual));
        }

    }

    private static boolean solution(String in) {
        if (in == null || "".equals(in)) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : in.toCharArray()) {
            switch (c) {
                case '{', '(', '[' -> {
                    stack.push(c);
                }
                case '}', ')', ']' -> {
                    char pop = stack.pop();
                    if (!Objects.equals(c, getCounterPart(pop))) {
                        return false;
                    }
                }

                default -> throw new IllegalStateException("Unexpected value: " + c);
            }
        }
        return true;
    }

    private static char getCounterPart(char in) {
        return switch (in) {
            case '{' -> '}';
            case '(' -> ')';
            case '[' -> ']';
            default -> throw new IllegalStateException("Unexpected value: " + in);
        };
    }
}
