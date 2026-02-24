package com.insightprovider.f1.service;

import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

class ClassPathFileReaderTest {

    public static final String VALID_FILE_NAME = "driver_abbreviations.txt";
    private final ClassPathFileReader classPathFileReader = new ClassPathFileReader();

    @Test
    void givenInvalidFileName_whenReadFileLines_thenFileNotFoundException() {
        String fileName = "file";
        FileNotFoundException exception = assertThrows(FileNotFoundException.class,
                () -> classPathFileReader.readFileLines(fileName));
        assertEquals("File '" + fileName + "' not found in classpath", exception.getMessage());
    }

    @Test
    void givenNullFileName_whenReadFileLines_thenNullPointerException() {
        assertThrows(NullPointerException.class, () -> classPathFileReader.readFileLines(null));
    }
    
    @Test
    void givenValidFileName_whenReadFileLines_thenExpectedLines() throws IOException {
       var expected = List.of(
               "PGS_Pierre Gasly_SCUDERIA TORO ROSSO HONDA",
               "KRF_Kimi Raikkonen_FERRARI",
               "LSW_Lance Stroll_WILLIAMS MERCEDES");
        assertEquals(expected, classPathFileReader.readFileLines(VALID_FILE_NAME));
     
    }
    
}