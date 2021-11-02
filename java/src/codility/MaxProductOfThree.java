package codility;

import java.util.Arrays;

// https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] in = new int[]{-3, 1, 2, -2, 5, 6};
        assertEquals(60, solution(in));
    }

    private static void assertEquals(int expected, int acutal) {
        if (expected != acutal) {
            throw new IllegalArgumentException("%d != %d ".formatted(expected, acutal));
        }
    }

    private static int solution(int[] in) {
        System.out.printf("raw: %s%n", Arrays.toString(in));
        int[] of = Arrays.copyOf(in, in.length);
        Arrays.sort(of);
        System.out.printf("sorted: %s%n", Arrays.toString(of));

        int product = 1;
        int[] triplet = new int[3];
        int j = 0;
        for (int i = of.length - 1; i > of.length - 4; i--) {
            System.out.printf("iter %d, index: %d%n", j, i);
            triplet[j] = of[i];
            j++;
            product *= of[i];
        }

        System.out.println(Arrays.toString(triplet));
        return product;
    }
}
