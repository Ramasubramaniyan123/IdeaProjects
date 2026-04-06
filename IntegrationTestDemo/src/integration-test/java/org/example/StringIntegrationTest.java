package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringIntegrationIT {

    @Test
    void testFullStringProcessingFlow() {
        StringService service = new StringService();
        StringProcessor processor = new StringProcessor(service);

        String result = processor.process("hello");

        assertEquals("OLLEH:5", result);
    }
}
