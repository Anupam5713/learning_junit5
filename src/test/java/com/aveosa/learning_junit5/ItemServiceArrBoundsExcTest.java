package com.aveosa.learning_junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemServiceArrBoundsExcTest {
    ItemService is = new ItemService();
    File input_arr_bound_exc = new File("src/test/resources/items_arr_bound_ex.csv");

    @DisplayName("Testing array index out of bounds exception with all items")
    @Test
    public void testArrayOutBoundsForAllItems() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            is.readAllItems(input_arr_bound_exc);
        });
    }

    @DisplayName("Testing array index out of bounds exception with single item")
    @Test
    public void testArrayOutBoundsForSingleItem() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            is.readSingleItem("1213", input_arr_bound_exc);
        });
    }

}
