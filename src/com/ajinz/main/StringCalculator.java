package com.ajinz.main;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class StringCalculator {
    public int Add(String numbers){
        String delimiter, negative_numbers_str = "";
        int index2, index1, multiple = 0;
        List<Integer> negative_numbers = new ArrayList<>();

        // Removing all Spaces
        numbers = numbers.replaceAll(" ", "");

        // for an empty string
        if (numbers == "") return 0;

        // first line delimiter
        // find if delimiter exists inside []
        index1 = numbers.indexOf("//[");

        if (index1 == -1) {
            index1 = numbers.indexOf("//");
            index2 = numbers.indexOf("\\n");
        }
        else{
            index1 += 1;
            index2 = numbers.indexOf("]\\n");
            multiple = 1;
        }

        // to store unique delimiters
        Set<Character> multiple_delimiters = new HashSet<>();

        // checking if delimiter exists in first line
        if (index1 != -1) {
            delimiter = numbers.substring(index1 + 2, index2);

            // Removing braces like this: []
            delimiter = delimiter.replaceAll("[\\[\\]]", "");
            for(int i = 0; i < delimiter.length(); i++)
                multiple_delimiters.add(delimiter.charAt(i));

            // because extra ] is added
            if (multiple == 1) index2++;

            numbers = numbers.substring(index2 + 2);
            numbers = numbers.replaceAll(Pattern.quote(delimiter), ",");

            // replacing each delimiter with comma
            for(Character m:multiple_delimiters){
                String ms = String.valueOf(m);
                numbers = numbers.replaceAll(Pattern.quote(ms), " ");
            }
            // Replacing multiple spaces with comma
            numbers = numbers.replaceAll(" +", ",");
            delimiter = ",";
        }
        else delimiter = ",|\n";

        // Splitting numbers with delimiter
        String[] split_numbers = numbers.split(delimiter);

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