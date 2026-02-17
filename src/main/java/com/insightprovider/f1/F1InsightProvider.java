package com.insightprovider.f1;

import java.io.IOException;
import com.insightprovider.f1.formatter.ReportFormatter;
import com.insightprovider.f1.service.ClassPathFileReader;
import com.insightprovider.f1.service.RaceProcessor;
import com.insightprovider.f1.service.TimestampLogParser;

public class F1InsightProvider {

    public static void main(String[] args) throws IOException {
        final var fileReader = new ClassPathFileReader();
        final var timestampLogParser = new TimestampLogParser();
        final var startTimeLines = timestampLogParser.parse(fileReader.readFileLines("start_times.log"));
        final var endTimeLines = timestampLogParser.parse(fileReader.readFileLines("finish_times.log"));
        final var driverAbbreviationLines = fileReader.readFileLines("driver_abbreviations.txt");
        final var raceProcessor = new RaceProcessor();
        final var results = raceProcessor.buildResults(startTimeLines, endTimeLines, driverAbbreviationLines);
        final var formatter = new ReportFormatter();
        System.out.println(formatter.build(results, 15));
    }

}