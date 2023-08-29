package com.patri.StringArrayManipulation;

public class WhitespaceRemover {

    // \n = new line Windows
    // \r = new line Unix
    // \t = tab
    // " " = space

    public static String removeWhitespaces(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if(!((input.charAt(i) == ' ') || (input.charAt(i) == '\n') || (input.charAt(i) == '\r') || (input.charAt(i) == '\t'))) {
               output += input.charAt(i);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        String[] examples = new String[]{"test is test", "This is my string with a \ttab char and a new \n" +
                "line char and another \r new line char"};
        for (String example : examples) {
            System.out.println(removeWhitespaces(example));
        }
    }
}
