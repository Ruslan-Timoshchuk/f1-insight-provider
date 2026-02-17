package com.insightprovider.f1.service;

import static java.util.stream.Collectors.toMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class RacerTimestampParser {

    public static final int ABBREVIATION_LENGTH = 3;
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    public Map<String, LocalDateTime> parse(List<String> timeLines) {
        return timeLines.stream().collect(toMap(line -> line.substring(0, ABBREVIATION_LENGTH),
                line -> LocalDateTime.parse(line.substring(ABBREVIATION_LENGTH), TIME_FORMATTER)));
    }

}