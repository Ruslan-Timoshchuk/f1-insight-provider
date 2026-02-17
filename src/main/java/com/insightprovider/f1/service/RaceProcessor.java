package com.insightprovider.f1.service;

import static java.time.Duration.between;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import com.insightprovider.f1.model.RaceResult;

public class RaceProcessor {

    public static final String LOW_LINE_DELIMITER = "_";

    public List<RaceResult> buildResults(Map<String, LocalDateTime> startTimeLines,
            Map<String, LocalDateTime> endTimeLines, List<String> racerAbbreviationLines) {
        return racerAbbreviationLines.stream().map(line -> line.split(LOW_LINE_DELIMITER))
                .map(line -> new RaceResult(between(startTimeLines.get(line[0]), endTimeLines.get(line[0])), line[1],
                        line[2]))
                .toList();
    }

}