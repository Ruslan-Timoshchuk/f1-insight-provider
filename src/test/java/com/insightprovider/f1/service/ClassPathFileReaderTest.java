package com.insightprovider.f1.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class ClassPathFileReaderTest {

    private final ClassPathFileReader classPathFileReader = new ClassPathFileReader();

    @Test
    void givenInvalidFileName_whenReadFileLines_thenNullPointerException() {
        String fileName = "file";
        Throwable exception = assertThrows(FileNotFoundException.class,
                () -> classPathFileReader.readFileLines(fileName));
        assertEquals("File '" + fileName + "' not found in classpath", exception.getMessage());
    }

    @Test
    void givenNullFileName_whenReadFileLines_thenExeption() {
        assertThrows(NullPointerException.class, () -> classPathFileReader.readFileLines(null));
    }
    
}