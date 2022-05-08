package com.aveosa.learning_junit5;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemServiceNumForExcTest {
    private static Logger logger = LogManager.getLogger(ItemService.class);
    ItemService is = new ItemService();

    @DisplayName("Tests number format exception")
    @Test
    public void testNumberForEx() {
        File num_for_ex_file = new File("src\\test\\resources\\items_num_for_ex.csv");
        assertThrows(NumberFormatException.class, () -> {
            is.readAllItems(num_for_ex_file);
        });
        assertThrows(NumberFormatException.class, () -> {
            is.readSingleItem("1213", num_for_ex_file);
        });
    }
}
