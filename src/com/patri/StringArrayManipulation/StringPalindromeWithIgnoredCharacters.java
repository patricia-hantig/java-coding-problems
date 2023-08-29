package com.patri.StringArrayManipulation;

public class StringPalindromeWithIgnoredCharacters {

    /*public static String exchangeString(String input) {
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') || (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                output = output + input.charAt(i);
            }
        }

        return output;
    }

    public static boolean isPalindromeWithIgnoredCharacters(String input) {
        if (input == null) {
            return true;
        }

        input = exchangeString(input).toLowerCase();

        for (int i = 0; i < input.length()/2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }*/


    public static boolean isCharacterAlphanumeric(char character){
        // we check if the character is number or Uppercase letter, lowercase letter
        return ((int) character >= 48 && (int) character <= 57) ||
                ((int) character >= 65 && (int) character <= 90) ||
                ((int) character >= 97 && (int) character <= 122);
    }

    public static boolean isPalindromeWithIgnoredCharacters(String input) {
        if (input == null) {
            return true;
        }

        int i = 0;
        int j = input.length() - 1;

        while (i < j) {
            if (isCharacterAlphanumeric(input.charAt(i))) {
                // elem at the beginning is alphanumeric and we can compare it
                if (isCharacterAlphanumeric(input.charAt(j))) {
                    // elem at the end is alphanumeric and we can compare it with the first
                    if (input.charAt(i) == input.charAt(j)) {
                        // here both are the same numbers or both are the same uppercase letter or both are the same lowercase letter
                        i++;
                        j--;
                    } else if (((input.charAt(i) >= 65 && input.charAt(i) <= 90) || (input.charAt(i) >= 97 && input.charAt(i) <= 122))
                            && ((input.charAt(j) >= 65 && input.charAt(j) <= 90) || (input.charAt(j) >= 97 && input.charAt(j) <= 122))
                            && ((input.charAt(i) == input.charAt(j) + 32) || (input.charAt(i) == input.charAt(j) - 32))) {
                        // we check if the values that we have to compare are letters
                        // first is lowercase letter and second is uppercase letter || first is lowercase letter and second is uppercase letter
                        // both are the same letter ( doesn't matter if lower or upper case)
                        i++;
                        j--;
                    } else {
                        return false;
                    }
                } else {
                    // elem is not-alphanumeric and we go to the previous elem
                    j--;
                }
            } else {
                // elem is not-alphanumeric and we go to the next elem
                i++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        /*String example = "A.z9?9.z!a";
        System.out.println(exchangeString(example));

        String[] examplesToTest = new String[] {"ANINA", "ANINa", "AninA", "AninA.", "AniinA", "Anin A", "0110", "!x!", "!x?", "  ..  ", "", " ", null,
                "AniNA", ".x!@#$%x^^", "A.z9?9.z!a", "A.z9?9.z!5a", "A.z9 ?9 .z! a", "A.z9?9   .z!5a"};
        System.out.println(isPalindromeWithIgnoredCharacters(example));
        for (String input : examplesToTest) {
            System.out.println("Is the word: " + input + " a palindrome? " + isPalindromeWithIgnoredCharacters(input));
        }*/

        System.out.println("The ASCII code for letter A is: " + (int)'A');
        System.out.println("The ASCII code for letter Z is: " + (int)'Z');
        System.out.println("The ASCII code for letter a is: " + (int)'a');
        System.out.println("The ASCII code for letter z is: " + (int)'z');
        System.out.println("The ASCII code for number 0 is: " + (int)'0');
        System.out.println("The ASCII code for number 9 is: " + (int)'9');

        System.out.println();

        String[] examplesToTest = new String[] {"ANINA", "ANINa", "AninA", "AninA.", "AniinA", "Anin A", "0110", "!x!", "!x?", "  ..  ", "", " ", null,
                "AniNA", ".x!@#$%x^^", "A.z9?9.z!a", "A.z9?9.z!5a", "A.z9 ?9 .z! a", "A.z9?9   .z!5a", "0P"};
        for (String input : examplesToTest) {
            System.out.println("Is the word: " + input + " a palindrome? " + isPalindromeWithIgnoredCharacters(input));
        }
    }
}
