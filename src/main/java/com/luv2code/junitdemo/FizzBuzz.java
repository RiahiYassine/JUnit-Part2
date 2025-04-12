package com.luv2code.junitdemo;

public class FizzBuzz {

    // FizzBuzz is a utility class
    private FizzBuzz() {
        throw new IllegalStateException("Utility class");
    }

    public static String compute(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else {
            if (i % 5 == 0) {
                return "Buzz";
            } else {
                return Integer.toString(i);
            }
        }
    }
}
