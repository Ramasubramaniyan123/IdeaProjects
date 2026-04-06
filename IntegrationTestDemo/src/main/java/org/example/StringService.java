package org.example;

public class StringService {

    public String toUpper(String input) {
        return input.toUpperCase();
    }

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public int length(String input) {
        return input.length();
    }
}
