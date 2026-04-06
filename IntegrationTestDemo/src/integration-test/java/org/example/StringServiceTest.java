package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringServiceTest {

    private final StringService service = new StringService();

    @Test
    void testToUpper() {
        assertEquals("HELLO", service.toUpper("hello"));
    }

    @Test
    void testReverse() {
        assertEquals("olleh", service.reverse("hello"));
    }

    @Test
    void testLength() {
        assertEquals(5, service.length("hello"));
    }
}
