package com.aveosa.learning_junit5;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemServiceNullPointerExcTest {

    File input_file = new File("src/test/resources/items.csv");

    @SuppressWarnings("null")
    @DisplayName("tests the null pointer exception")
    @Test
    public void testNullPointerEx() {
        ItemService is = null;
        assertThrows(NullPointerException.class, () -> {
            is.readAllItems(input_file);
        });
    }


}
