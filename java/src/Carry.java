//numberOfCarryOperations(65, 55) // 2
//        65 + 55 =>
//        1st column: 5 + 5 = 0 (1 is carried)
//        2nd column: 6 + 5 + 1 (carried) = 2 (1 is carried)
//        3rd column: 1 (carried) = 1
//        => 120 (2 carry operations)


public class Carry {

    final static int ASCII_CHAR_OFFSET = 48;

    public static void main(String[] args) {
        System.out.println(numberOfCarryOperations(123, 456) + " == " + 0);
        System.out.println(numberOfCarryOperations(555, 555) + " == " + 3);
        System.out.println(numberOfCarryOperations(900, 11) + " == " + 0);
        System.out.println(numberOfCarryOperations(145, 55) + " == " + 2);
        System.out.println(numberOfCarryOperations(0, 0) + " == " + 0);
        System.out.println(numberOfCarryOperations(1, 99999) + " == " + 5);
        System.out.println(numberOfCarryOperations(999045, 1055) + " == " + 5);
        System.out.println(numberOfCarryOperations(101, 809) + " == " + 1);
        System.out.println(numberOfCarryOperations(189, 209) + " == " + 1);
    }

    private static int numberOfCarryOperations(int operant1, int operant2) {
        char[] op1 = (operant1 + "").toCharArray();
        char[] op2 = (operant2 + "").toCharArray();

        int carryOperationsCounter = 0;
        for (int i = 0; i < op.length; i++) {
            if(i > op1.length) {
                continue;
            }

            if( i > op2.length) {
                continue;
            }

            int c1 = op1[op1.length - i] - ASCII_CHAR_OFFSET;
            int c2 = op2[op2.length - i] - ASCII_CHAR_OFFSET;

            if (c1 + c2 >= 10) {
                carryOperationsCounter++;
                if(i-1 == 0) {
                    carryOperationsCounter++;
                } else {
                    op1[i-1] += (int)1;
                }
            }
        }


        return carryOperationsCounter;
    }
}
