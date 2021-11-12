public class BinarySkills {


    //In Java sind alle Ganzzahl-Datentypen vorzeichenbehaftet,
    // und die Operatoren << und >> führen arithmetische Verschiebungen durch.
    // In Java gibt es zusätzlich den Operator >>>, der eine logische Rechtsverschiebung durchführt.
    // Da logische und arithmetische Linksverschiebungen identisch sind, gibt es keinen <<<-Operator.

    // >>>  The only difference is that the empty spaces in the left are filled with 0 irrespective of whether
    // the number is positive or negative. Therefore, the result will always be a positive integer.
    public static void main(String[] args) {
        for (int i = -5; i < 5; i++) {
            int result = i >> 1;
            int result2 = i >>> 1;
            System.out.println(i + ": " + result + " | " + result2);
        }
    }

    public static void not(String[] args) {
        int i = ~1;
        System.out.println(i);
    }

    // x * Math.pow(2,i) = x << i
    public static void mathEquals(String[] args) {
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
