import java.sql.SQLOutput;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("bob"));
    }

    private static boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }

        char[] chars = word.toCharArray();
        if (chars.length <= 1) {
            return true;
        }

        for (int i = 0; i < chars.length / 2; i++) {
            char c1 = chars[i];
            char c2 = chars[chars.length -1];
            if(c1 == c2) {
                return true;
            }
        }

        return false;
    }
}
