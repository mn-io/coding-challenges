package toptal;

public class PossibleBalance {
    public static void main(String[] args) {
        int i1 = possibleBalance("++-", 2); // should return 1
        if (i1 != 1) throw new AssertionError();
        int i2 = possibleBalance("+++-++-++--+-++++-+--++-++-+-++++-+++--", 12); // 1
        if (i2 != 1) throw new AssertionError();
        int i3 = possibleBalance("+++-++-++--+-++++-+--++-++-+-++++-+++--", 13); // 2
        if (i3 != 2) throw new AssertionError();
        int i4 = possibleBalance("+++-++-++--+-++++-+--++-++-+-++++-+++--", 14); // -1
        if (i4 != -1) throw new AssertionError();
        int i5 = possibleBalance("+++---", 3); // 3
        if (i5 != 3) throw new AssertionError();
        int i6 = possibleBalance("+++-+---", 3); // 3
        if (i6 != 3) throw new AssertionError();
        int i7 = possibleBalance("----+-", -2); // 4
        if (i7 != 4) throw new AssertionError();

        int i8 = possibleBalance("+", 10); // -1
        if (i8 != -1) throw new AssertionError();
        int i9 = possibleBalance("+++-", 2); // 0
        if (i9 != 0) throw new AssertionError();
        int i10 = possibleBalance("+++-", 3); // 1
        if (i10 != 1) throw new AssertionError();
        int i11 = possibleBalance("+++", 1); // 0
        if (i11 != 0) throw new AssertionError();
    }

    private static int possibleBalance(String s, int n) {
        System.out.printf("%s, %d -> ", s, n);
        int removals = 0;

        final char[] chars = s.toCharArray();
        int balance = 0;
        for (int i = 0; i < chars.length; i++) {
            final char c = chars[i];
            if (c == '+') {
                balance++;
            } else {
                balance--;
            }
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            if (balance >= n) {
                System.out.println(removals);
                return removals;
            }
            final char c = chars[i];

            if (c == '+') {
                balance--;
            } else {
                balance++;
            }

            removals++;
        }

        System.out.println(-1);
        return -1;
    }
}
