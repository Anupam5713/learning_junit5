package com.aveosa.learning_junit5;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class ItemServiceCSVValidTest {
    ItemService is = new ItemService();

    @DisplayName("Tests whether the CSV file is valid while reading all items")
    @Test
    public void testCsvValidationExcAll() {
        assertThrows(CsvValidationException.class, () -> {
            File InvalidCsvFile = new File("src/test/resources/items_invalid_CSV.csv");
            is.readAllItems(InvalidCsvFile);
        });
    }

    @DisplayName("Tests whether the CSV file is valid while reading a single item")
    @Test
    public void testCsvValidationExcOne() {
        assertThrows(CsvValidationException.class, () -> {
            File InvalidCsvFile = new File("src/test/resources/items_invalid_CSV.csv");
            is.readSingleItem("1212", InvalidCsvFile);
        });
    }

}

