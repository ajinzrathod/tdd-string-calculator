package com.ajinz.main;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int Add(String numbers){
        String delimiter, negative_numbers_str = "";
        List<Integer> negative_numbers = new ArrayList<>();

        // Removing all Spaces
        numbers = numbers.replaceAll(" ", "");

        // for an empty string
        if (numbers == "") return 0;

        // first line delimiter
        int index1 = numbers.indexOf("//");
        int index2 = numbers.indexOf("\\n");

        // checking if delimiter exists in first line
        if (index1 != -1) {
            delimiter = numbers.substring(index1 + 2, index2);
            numbers = numbers.substring(index2 + 2);
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
            if(current < 1001)
                total += current;
        }

        // Throw Exception if negative Exists
        HandleNegativeValues.throwExceptionIfNegativeExists(negative_numbers_str);

        return total;
    }

    public static void main(String[] args) {
    }
}