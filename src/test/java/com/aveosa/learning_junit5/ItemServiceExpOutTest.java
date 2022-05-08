package com.aveosa.learning_junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.opencsv.exceptions.CsvValidationException;

public class ItemServiceExpOutTest {
    ItemService is = new ItemService();
    File actual_input_file = new File(
            "src\\test\\resources\\items.csv");

    @DisplayName("tests reading all the items from CSV")
    @Test
    public void testReadAllItems() throws CsvValidationException, IOException {
        List<ItemModel> actual;
        actual = is.readAllItems(actual_input_file);
        List<ItemModel> expected = new ArrayList<ItemModel>(
                Arrays.asList(new ItemModel(1211, "jeans", "type of trouser", 300),
                        new ItemModel(1212, "cargo", "type of trouser", 500),
                        new ItemModel(1213, "saree", "traditional womens' wear", 600),
                        new ItemModel(1214, "frock", "girls' gown", 800)));
        assertEquals(expected, actual);
    }

    @DisplayName("tests reading single item item1 from CSV")
    @Test
    public void testReadSingleItem1() throws CsvValidationException, IOException {
        ItemModel actual;
        actual = is.readSingleItem("1211", actual_input_file);
        ItemModel expected = new ItemModel(1211, "jeans", "type of trouser", 300);
        assertEquals(expected, actual);

    }

    @DisplayName("tests reading single item item2 from CSV")
    @Test
    public void testReadSingleItem2() throws CsvValidationException, IOException {
        ItemModel actual;
        actual = is.readSingleItem("1212", actual_input_file);
        ItemModel expected = new ItemModel(1212, "cargo", "type of trouser", 500);
        assertEquals(expected, actual);
    }

    @DisplayName("tests reading single item item3 from CSV")
    @Test
    public void testReadSingleItem3() throws CsvValidationException, IOException {
        ItemModel actual;
        actual = is.readSingleItem("1213", actual_input_file);
        ItemModel expected = new ItemModel(1213, "saree", "traditional womens' wear", 600);
        assertEquals(expected, actual);
    }

    @DisplayName("tests reading single item item4 from CSV")
    @Test
    public void testReadSingleItem4() throws CsvValidationException, IOException {
        ItemModel actual;
        actual = is.readSingleItem("1214", actual_input_file);
        ItemModel expected = new ItemModel(1214, "frock", "girls' gown", 800);
        assertEquals(expected, actual);
    }

    @DisplayName("tests whether empty input results in empty output")
    @Test
    public void testEmptyOutput() throws CsvValidationException, IOException {
        File empty_file = new File(
                "src\\test\\resources\\null_items.csv");
        List<ItemModel> actual;
        actual = is.readAllItems(empty_file);
        List<ItemModel> expected = new ArrayList<ItemModel>();
        assertEquals(expected, actual);
    }

    @DisplayName("tests whether input item is found in the given list in case of single item search")
    @Test
    public void testInputFound() throws CsvValidationException, IOException {
        ItemModel expected = new ItemModel();
        File input_unava = new File(
                "src\\test\\resources\\item_not_found.csv");
        assertEquals(is.readSingleItem("1211", input_unava), expected);
    }
}

