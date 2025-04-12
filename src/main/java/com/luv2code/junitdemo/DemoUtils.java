package com.luv2code.junitdemo;

import java.util.List;

public class DemoUtils {

    private static final String greeting = "Hello World";
    private static final String greetingDuplicated = greeting;
    private static final String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};
    private static final List<String> wordsInQuote = List.of("eat", "sleep", "code","repeat");


    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public Object checkNull(Object obj) {
        return obj;
    }

    public Boolean isGreater(int n1, int n2) {
        return n1 > n2;
    }

    public void throwException(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Value must be non-negative. Provided: " + a);
        }
    }

    public void checkTimeout() throws InterruptedException {
        Thread.sleep(2000);
    }

    public String getGreeting() {
        return greeting;
    }

    public String getGreetingDuplicated() {
        return greetingDuplicated;
    }

    public String[] getFirstThreeLettersOfAlphabet() {
        return firstThreeLettersOfAlphabet;
    }

    public List<String> getWordsInQuote() {
        return wordsInQuote;
    }

}