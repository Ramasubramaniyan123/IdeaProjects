package org.example;

public class StringProcessor {

    private final StringService service;

    public StringProcessor(StringService service) {
        this.service = service;
    }

    public String process(String input) {
        String upper = service.toUpper(input);
        String reversed = service.reverse(upper);
        return reversed + ":" + service.length(input);
    }
}
