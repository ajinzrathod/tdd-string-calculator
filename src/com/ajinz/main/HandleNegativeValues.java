package com.ajinz.main;

public class HandleNegativeValues {
    public static class negativesNotAllowed extends Throwable {
        public negativesNotAllowed(String s) {
            super(s);
        }
    }

    public static void throwExceptionIfNegativeExists(String negative_numbers_str) {
        if (negative_numbers_str != "") {
            try {
                throw new negativesNotAllowed("Negatives Not Allowed. Numbers are: " + negative_numbers_str);
            } catch (negativesNotAllowed e) {
                e.printStackTrace();
            }
        }
    }

}