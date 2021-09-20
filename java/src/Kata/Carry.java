package Kata;//numberOfCarryOperations(65, 55) // 2
//        65 + 55 =>
//        1st column: 5 + 5 = 0 (1 is carried)
//        2nd column: 6 + 5 + 1 (carried) = 2 (1 is carried)
//        3rd column: 1 (carried) = 1
//        => 120 (2 carry operations)

import java.util.Arrays;

//https://www.geeksforgeeks.org/count-the-number-of-carry-operations-required-to-add-two-numbers/
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

    private static int numberOfCarryOperations(int op1, int op2) {
        char[] o1 = reverse((op1 + "").toCharArray());
        char[] o2 = reverse((op2 + "").toCharArray());
        int max = Math.max(o2.length, o1.length);

        int carryOperationsCounter = 0;
        int currentCarry = 0;
        // System.out.println("working on " + op1 + " + "+ op2);
        for (int i = 0; i < max; i++) {
            int c1 = i >= o1.length ? 0 : o1[i] - '0';
            int c2 = i >= o2.length ? 0 : o2[i] - '0';

            int result = c1 + c2 + currentCarry;
            // System.out.print(" " + c1 + " + " + c2 + " + " + currentCarry + " = " + result);
            if(currentCarry > 0) {
                carryOperationsCounter++;
                currentCarry = 0;
            }
            if (result > 9) {
                currentCarry = result / 10;
            }
            // System.out.println(", " + carryOperationsCounter);
        }

        if(currentCarry > 0) {
            carryOperationsCounter++;
        }

        return carryOperationsCounter;
    }

    private static char[] reverse(char[] in) {
        var out = new char [in.length];
        int i = out.length - 1;
        for (char c : in) {
            out[i] = c;
            i--;
        }

        return out;
    }
}
