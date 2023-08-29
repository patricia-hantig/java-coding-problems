package com.patri.StringArrayManipulation;

public class SimpleStringPalindrome {

    // ex of palindromes: anina, aniina, ANINA, ANIINA, 0110, !x!, null, empty string
    // not-palindromes: Anina, AninA. , Anin A, 110, !x!x

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return true;
        }

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = new String[] {"ANINA", "anina", "Anina", "aniina", "0110", "!x!", "AninA.", "110", "Anin A", "!x!x", null, ""};
        for (String input: strings) {
            System.out.println("Is the string " + input + " a palindrome? " + isPalindrome(input));
        }

    }
}
