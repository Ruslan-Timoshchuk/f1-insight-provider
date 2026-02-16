package com.insightprovider.f1.service;

import static java.util.Objects.requireNonNull;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ClassPathFileReader {

    public List<String> readFileLines(String inputName) throws IOException {
        try (var lines = requireNonNull(getClass().getClassLoader().getResourceAsStream(inputName),
                "File '" + inputName + "' not found in classpath")) {
            return new BufferedReader(new InputStreamReader(lines, UTF_8)).lines().toList();
        }
    }

}