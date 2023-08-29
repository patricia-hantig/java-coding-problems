package com.patri.StringArrayManipulation;

public class StringReversal {

    public static String reverseString(String input) throws Exception {
        if (input == null) {
            throw new Exception("You entered a null string");
        }

        String output = "";
        for(int i = input.length() - 1 ; i >= 0; i--){
            output += input.charAt(i);
        }
        return output;
    }

    public static String reverseStringWithStringBuilder(String input) throws Exception {
        if (input == null) {
            throw new Exception("You entered a null string");
        }

        StringBuilder output = new StringBuilder("");
        for(int i = input.length() - 1 ; i >= 0; i--){
            output.append(input.charAt(i));
        }
        return output.toString();
    }


    public static void main(String[] args) {
        String[] examples = new String[]{"This is the 1st String!", " ", ""};
        try {
            for (String example : examples) {
                System.out.println("Reverse for string: " + example + " is: " + reverseString(example));
            }

            for (String example : examples) {
                System.out.println("Reverse for string: " + example + " using StringBuilder is: " + reverseStringWithStringBuilder(example));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
