package com.insightprovider.f1.formatter;

import static java.lang.System.lineSeparator;
import static java.util.Comparator.comparing;
import static java.time.LocalTime.ofNanoOfDay;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import com.insightprovider.f1.model.RaceResult;

public class ReportFormatter {

	public static final String HYPHEN_DELIMITER = "-";
	public static final String ROW_PATTERN_TEMPLATE = "%%02d. %%-%ds | %%-%ds | %%s";
	public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("mm:ss.SSS");

	public String build(List<RaceResult> raceResults, int bestRacersNumber) {
		StringBuilder result = new StringBuilder();
		int maxNameLength = getMaxFieldLength(raceResults, RaceResult::getFullName);
		int maxTeamLength = getMaxFieldLength(raceResults, RaceResult::getTeam);
		AtomicInteger number = new AtomicInteger();		
        String pattern = String.format(ROW_PATTERN_TEMPLATE, maxNameLength, maxTeamLength);
		raceResults.stream().sorted(comparing(RaceResult::getLapTime)).forEach(s -> {
			if ((number.get() == bestRacersNumber)) {
				result.append(HYPHEN_DELIMITER.repeat(maxNameLength + maxTeamLength + 19)).append(lineSeparator());
			}
			result.append(String.format(pattern, number.incrementAndGet(), s.getFullName(), s.getTeam(),
					formatToTime(s.getLapTime()))).append(lineSeparator());
		});
		return result.toString();
	}

	private int getMaxFieldLength(List<RaceResult> racers, Function<RaceResult, String> function) {
		return racers.stream().map(function).mapToInt(String::length).max().orElse(0);
	}

	private String formatToTime(Duration duration) {
		return ofNanoOfDay(duration.toNanos()).format(TIME_FORMATTER);
	}
	
}