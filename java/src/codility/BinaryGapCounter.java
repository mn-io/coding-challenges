package codility;

public class BinaryGapCounter {

    public static void main(String[] args) {
        if (solution(9) != 2) throw new AssertionError();
        if (solution(1041) != 5) throw new AssertionError();
        if (solution(32) != 0) throw new AssertionError();
        if (solution(15) != 0) throw new AssertionError();
    }

    public static int solution(int N) {
        String binary = toBinaryString(N);
        int maxCount = 0;

        int count = 0;


        char[] chars = binary.toCharArray();
        outer:
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != '1') {
                continue outer;
            }

            inner:
            for (int j = i+1; j < chars.length; j++) {
                char c1 = chars[j];
                if (c1 == '0') {
                    count++;
                    continue inner;
                }

                maxCount = Math.max(count, maxCount);
                count = 0;
                continue outer;
            }
        }

        return maxCount;
    }

    private static String toBinaryString(int n) {
        var sb = new StringBuilder();

        boolean hasStarted = false;
        for (int i = 31; i >= 0; i--) {
            int pow = (int) Math.pow(2, i);
            if (pow > n) {
                if (hasStarted) {
                    sb.append("0");
                }
                continue;
            }
            hasStarted = true;
            n = n - pow;
            sb.append("1");
        }

        return sb.toString();
        //return Integer.toBinaryString(n);
    }
}
