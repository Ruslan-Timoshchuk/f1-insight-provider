package com.insightprovider.f1.service;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TimestampLogParserTest {

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    private final TimestampLogParser timestampLogParser = new TimestampLogParser();

    @Test
    void givenNullTimeLines_whenParse_thenNullPointerException() {
        assertThrows(NullPointerException.class, () -> timestampLogParser.parse(null));
    }

    @Test
    void givenEmptyTimeLines_whenParse_thenEmptyResult() {
        assertEquals(Map.of(), timestampLogParser.parse(List.of()));
    }
    
    @Test
    void givenTimeLines_whenParse_thenResult() {
        List<String> actual = List.of(
                "PGS2018-05-24_12:08:36.586", 
                "KRF2018-05-24_12:04:13.889",
                "LSW2018-05-24_12:07:26.834");
        Map<String, LocalDateTime> expected = Map.of(
                "PGS", LocalDateTime.of(2018, 5, 24, 12, 8, 36, 586_000_000),
                "KRF", LocalDateTime.of(2018, 5, 24, 12, 4, 13, 889_000_000),
                "LSW", LocalDateTime.of(2018, 5, 24, 12, 7, 26, 834_000_000)
        );
        assertEquals(expected, timestampLogParser.parse(actual));
    }
    
}