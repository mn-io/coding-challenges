package codility;

public class FrogJmp {
    public static void main(String[] args) {
        if (solution(10,85, 30) != 3) throw new AssertionError();
    }

    private static int solution(int x,int y, int d) {
        int left = y - x;
        int jumps = left / d;
        int leftOverJump = left % d;
        if(leftOverJump > 0)  {
            return jumps + 1;
        } else {
            return jumps;
        }
    }
}
