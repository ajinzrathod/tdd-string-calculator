package com.ajinz.main;

public class StringCalculator {
    public int Add(String numbers){
        // Removing all Spaces
        numbers = numbers.replaceAll(" ", "");

        // for an empty string
        if (numbers == "") return 0;
        return 1;
    }
    public static void main(String[] args) {
        System.out.println("Jai Swaminarayan");
    }
}
