package com.patri.StringArrayManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateCharacterFinder {

    public static List<Character> getListOfDuplicates(String input) {
        if (input == null) {
            return new ArrayList<Character>();
        }

        List<Character> output = new ArrayList<Character>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    // before we add the elem to the list we check to see if it's not already there
                    if (!output.contains(input.charAt(i))) {
                        output.add(input.charAt(i));
                    }
                }
            }
        }
        return output;
    }

    public static boolean elementIsInList(char element, List<Character> list) {
        if (!list.isEmpty()) {
            for (char character : list) {
                if (element == character) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Character> getListOfDuplicatesWithoutContains(String input) {
        if (input == null) {
            return new ArrayList<Character>();
        }

        List<Character> output = new ArrayList<Character>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    // before we add the elem to the list we check to see if it's not already there
                    if (!elementIsInList(input.charAt(i), output)) {
                        output.add(input.charAt(i));
                    }
                }
            }
        }
        return output;
    }

    public static List<Character> getListOfDuplicatesWithHashMap(String input) {
        if (input == null) {
            return new ArrayList<Character>();
        }

        List<Character> output = new ArrayList<Character>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < input.length(); i++) {
            // we check if the element from the list already exists in HashMap(as key), if it does not exist -> we add it to the Map(as key), if it exists we increment the value for that key

            // it does not exist - we add it to the map
            if (map.get(input.charAt(i)) == null) {
                map.put(input.charAt(i), 1);
            }

            /*
            // solution with contains()
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), 1);
            }*/

            // it does exist - we increase the value for that key
            else {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            }
        }

        for (Character keyFromMap : map.keySet()) {
            if (map.get(keyFromMap) > 1) {
                output.add(keyFromMap);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String test = "test is test";
        System.out.println(getListOfDuplicates(test));
        System.out.println(getListOfDuplicatesWithoutContains(test));
        System.out.println(getListOfDuplicatesWithHashMap(test));
    }
}
