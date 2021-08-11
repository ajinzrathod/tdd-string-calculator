package com.ajinz.main;

public class StringCalculator {
    public int Add(String numbers){
        // Removing all Spaces
        numbers = numbers.replaceAll(" ", "");

        // for an empty string
        if (numbers == "") return 0;

        int total = 0;

        // Splitting numbers from comma
        String[] split_numbers = numbers.split(",");

        // Counting Total
        for (String n : split_numbers) {
            Integer current = Integer.parseInt(n);
            total += current;
        }
        return total;
    }
    public static void main(String[] args) {
    }
}
