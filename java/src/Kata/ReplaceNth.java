package Kata;

public class ReplaceNth {
    public static void main(String[] args) {
        basicTests();
    }

    public static String replaceNth(String text, int n, char oldValue, char newValue) {
        if(n <= 0) {
            return text;
        }

        var sb = new StringBuilder();
        int currentN = 0;
        int oldValueCount = 0;
        for (char c : text.toCharArray()) {
            if(c == oldValue) {
                currentN++;
                oldValueCount++;

                if(currentN % n == 0) {
                    sb.append(newValue);
                } else {
                    sb.append(oldValue);
                }
            } else {
                sb.append(c);
            }

        }

        if(oldValueCount < n) {
            return text;
        }

        return sb.toString();
    }

    public static void basicTests() {
        assertEquals("Vader soid: No, I am your fother!", replaceNth("Vader said: No, I am your father!", 2, 'a', 'o'));
        assertEquals("Vader said: No, I am your fother!", replaceNth("Vader said: No, I am your father!", 4, 'a', 'o'));
        assertEquals("Vader said: No, I am your father!", replaceNth("Vader said: No, I am your father!", 6, 'a', 'o'));
        assertEquals("Vader said: No, I am your father!", replaceNth("Vader said: No, I am your father!", 0, 'a', 'o'));
        assertEquals("Vader said: No, I am your father!", replaceNth("Vader said: No, I am your father!", -2, 'a', 'o'));
        assertEquals("Vader sayd: No, I am your father!", replaceNth("Vader said: No, I am your father!", 1, 'i', 'y'));

        assertEquals("Luke cries: Noooooioooooioooo!", replaceNth("Luke cries: Noooooooooooooooo!", 6, 'o', 'i'));
        assertEquals("aaa", replaceNth("aaa", 4, 'a', 'i'));
    }

    private static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(expected + " does not match " + actual);
        }
    }
}
