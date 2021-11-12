public class BinarySkills {

    // x * Math.pow(2,i) = x << i

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int x = 0; x < 5; x++) {
                int result1 = (int) (x * Math.pow(2, i));
                int result2 = x << i;
                System.out.printf("i:%d, x:%d: result1: %d, result2: %d, %b%n", i, x, result1, result2, result1 == result2);
            }
        }
    }

    public static void toDecimal(String[] args) {
        String binary = "010000";

        char[] chars = binary.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            int j = chars.length - i - 1;
            if (chars[j] == '1') {
                int decimal = 1 << i;
                result += decimal;
            }
        }

        System.out.println(result);
        System.out.println(binary);
        System.out.println(Integer.toBinaryString(result));
    }

    public static void main1(String[] args) {
        for (int i = 0; i < 32; i++) {
            int n = 1 << i;
            double nn = Math.pow(2, i);
            String asBinaryString = Integer.toBinaryString(n);
            System.out.println(i + ": " + n + " - " + asBinaryString);
        }

    }
}
