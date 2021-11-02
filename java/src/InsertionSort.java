public class InsertionSort {

    public static void main(String[] args) {
        int[] ints = {1, 5, 3, 7, 4};

        assertSorted(sort(ints));
    }

    private static void assertSorted(int[] sort) {
        for (int i = 0; i < sort.length - 1; i++) {
            int first = sort[i];
            int second = sort[i+1];
            if(first > second) {
                throw new IllegalArgumentException("ints not sorted: %d < %d".formatted(first, second));
            }
        }
    }

    private static int[] sort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int toBeSorted = ints[i];
            int j = i;
            while(j > 0 && ints[j-1] > toBeSorted) {
                ints[j] = ints[j-1];
                j--;
            }
            ints[j] = toBeSorted;
        }
        return ints;
    }
}
