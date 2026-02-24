package com.insightprovider.f1.service;

import static java.util.Objects.nonNull;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ClassPathFileReader {

    public List<String> readFileLines(String inputName) throws IOException {
        try (final var fileLines = getClass().getClassLoader().getResourceAsStream(inputName)) {
            if (nonNull(fileLines)) {
                return new BufferedReader(new InputStreamReader(fileLines, UTF_8)).lines().toList();
            } else {
                throw new FileNotFoundException("File '" + inputName + "' not found in classpath");
            }
        }
    }
    
}