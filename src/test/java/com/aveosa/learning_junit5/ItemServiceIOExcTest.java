package com.aveosa.learning_junit5;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemServiceIOExcTest {
    private static Logger logger = LogManager.getLogger(ItemService.class);
    ItemService is = new ItemService();

    @DisplayName("Tests IO exception for All items")
    @Test
    public void testIOExceptionForReadingAllItems() {
        assertThrows(IOException.class, () -> {
            File IOExceptionFile = new File("src/test/resources/io_exc.csv");
            is.readAllItems(IOExceptionFile);
        });
    }

    @DisplayName("Tests IO Exception for single item")
    @Test
    public void testIOExceptionForReadingSingleItems() {
        assertThrows(IOException.class, () -> {
            File IOExceptionFile = new File("src/test/resources/io_exc.csv");
            is.readSingleItem("1211", IOExceptionFile);
        });
    }

}
