package com.ajinz.main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int Add(String numbers){
        String delimiter, negative_numbers_str = "", split_numbers[];
        List<Integer> negative_numbers = new ArrayList<>();

        // Removing all Spaces
        numbers = numbers.replaceAll(" ", "");

        // for an empty string
        if (numbers == "") return 0;

        int index1 = numbers.indexOf("//");
        int index2 = numbers.indexOf("\\n");

        // checking if delimiter exists in first line
        if (index1 != -1) {
            delimiter = numbers.substring(index1 + 2, index2);
            System.out.println(delimiter);
            numbers = numbers.substring(index2 + 2);
            System.out.println(numbers);

            if (delimiter.endsWith("]") && delimiter.indexOf("[") == 0) {
                // . anything
                // * zero or more
                // ? non capturing group
                Pattern pattern = Pattern.compile("\\[(.*?)\\]");
                Matcher matcher = pattern.matcher(delimiter);

                int groupCount = matcher.groupCount();
                System.out.println("GroupCount" + groupCount);

                while (matcher.find()) {
                    for (int i = 0; i <= groupCount; i++) {
                        String m = matcher.group(i);
                        System.out.println("Group " + i + ": " + m);
                        numbers = numbers.replaceAll(Pattern.quote(m), ",");
                    }
                }
                delimiter = ",";
            }

            // Splitting numbers with delimiter
            split_numbers = numbers.split(Pattern.quote(delimiter));
        }
        else {
            System.out.println(numbers);
            delimiter = ",|\n";

            // Splitting numbers with delimiter
            split_numbers = numbers.split(delimiter);
        }

        // Counting Total of Numbers
        int total = 0;
        for (String n : split_numbers) {
            Integer current = Integer.parseInt(n);
            if (current < 0) {
                negative_numbers.add(current);
                negative_numbers_str += (String.valueOf(current) + " ");
            }

            // Values greater than 1000 should not be added
            if(current < 1001) total += current;
        }

        // Throw Exception if negative Exists
        HandleNegativeValues.throwExceptionIfNegativeExists(negative_numbers_str);

        return total;
    }
}