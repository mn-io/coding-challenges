package toptal;

// https://www.reddit.com/r/freelance/comments/4mucmn/i_failed_the_toptal_coding_test/
public class SplitArray {
    public static void main(String[] args) {
        assertEquals(4, solution(new int[]{5, 5, 2, 3, 5, 1, 6}, 5));
    }

    private static int solution(int[] ints, int x) {
        int max = ints.length;
        for (int potentialSplitValue = 1; potentialSplitValue < max - 1; potentialSplitValue++) {
            int valueCounter = 0;
            for (int lowerI = 0; lowerI < potentialSplitValue; lowerI++) {
                System.out.print(ints[lowerI]);
                if (x == ints[lowerI]) {
                    valueCounter++;
                }
            }
            System.out.print("|");
            for (int upperI = potentialSplitValue + 1; upperI < max; upperI++) {
                System.out.print(ints[upperI]);
                if (x != ints[upperI]) {
                    valueCounter--;
                }
            }

            if (valueCounter == 0) {
                return potentialSplitValue + 1;
            }
            System.out.println();
        }

        return 0;
    }

    private static void assertEquals(int expected, int acutal) {
        if (expected != acutal) {
            throw new IllegalArgumentException("%d != %d ".formatted(expected, acutal));
        }
    }
}
