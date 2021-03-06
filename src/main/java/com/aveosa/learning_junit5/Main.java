package com.aveosa.learning_junit5;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.exceptions.CsvValidationException;

public class Main {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger(Main.class);
        ItemService is = new ItemService();
        File input_file = new File(
                "C:\\Users\\Anpande\\eclipse-workspace\\item.lookup\\src\\main\\resources\\items_original.csv");
        try {
            System.out.println(is.readAllItems(input_file));
            System.out.println(is.readSingleItem("1211", input_file));
            System.out.println(is.readSingleItem("1212", input_file));
            System.out.println(is.readSingleItem("1213", input_file));
            System.out.println(is.readSingleItem("1214", input_file));

        } catch (CsvValidationException e) {
            logger.error("CsvValidationException thrown for testing purpose");
        } catch (IOException e) {
            logger.error("IOException thrown for testing purpose");
        }

    }
}
