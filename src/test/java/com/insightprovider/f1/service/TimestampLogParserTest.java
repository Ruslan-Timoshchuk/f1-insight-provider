package com.insightprovider.f1.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TimestampLogParserTest {

    private final TimestampLogParser timestampLogParser = new TimestampLogParser();

    @Test
    void givenNullTimeLines_whenParse_thenNullPointerException() {
        assertThrows(NullPointerException.class, () -> timestampLogParser.parse(null));
    }

    @Test
    void givenEmptyTimeLines_whenParse_thenEmptyResult() {
        assertEquals(Map.of(), timestampLogParser.parse(List.of()));
    }
    
}