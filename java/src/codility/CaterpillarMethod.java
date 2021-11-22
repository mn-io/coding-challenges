package codility;

public class CaterpillarMethod {

    public static void main(String[] args) {
        final int[] a = {6, 2, 7, 4, 1, 3, 6};
        boolean solution = solution(a, 12);
        if (!solution) throw new AssertionError();
    }

    private static boolean solution(int[] a, int s) {
        int front = 0;
        int total = 0;
        for (int back = 0; back < a.length; back++) {
            while (front < a.length && total + a[front] <= s) {
                System.out.print(front + ", ");
                total += a[front];
                front++;
            }
            System.out.println("total: " + total);
            if (total == s) {
                return true;
            }
            total -= a[back];
        }

        return false;
    }
}
