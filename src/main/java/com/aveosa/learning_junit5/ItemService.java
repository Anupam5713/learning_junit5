package com.aveosa.learning_junit5;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class ItemService {
    List<ItemModel> imlist = new ArrayList<ItemModel>();
    private static Logger logger = LogManager.getLogger(ItemService.class);
    private static final String BAD = null;
    private static final String AWFUL = "awful";
    private ForbiddenValidator lineDoesNotHaveBadString = new ForbiddenValidator(BAD);
    private ForbiddenValidator lineDoesNotHaveAwfulString = new ForbiddenValidator(AWFUL);

    public List<ItemModel> readAllItems(File file) throws IOException, CsvValidationException {
        Reader reader;
        try {
            reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
            CSVReader csvReader = new CSVReaderBuilder(reader).withLineValidator(lineDoesNotHaveAwfulString)
                    .withLineValidator(lineDoesNotHaveBadString).withSkipLines(1).build();

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                ItemModel im = new ItemModel();
                logger.info("reading the next record in csv file");
                im.setId(Long.parseLong(nextRecord[0]));
                im.setItem_name(nextRecord[1]);
                im.setItem_desc(nextRecord[2]);
                im.setItem_price(Long.parseLong(nextRecord[3]));
                imlist.add(im);
            }
        } catch (CsvValidationException e) {
            logger.error(e.getMessage());
            throw e;
        } catch (IOException e) {
            logger.error("error when I/O failed or interrupted");
            throw e;
        }

        return imlist;

    }

    public ItemModel readSingleItem(String ItemId, File file) throws IOException, CsvValidationException {
        ItemModel im = new ItemModel();
        Reader reader;
        try {
            reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
            CSVReader csvReader = new CSVReaderBuilder(reader).withLineValidator(lineDoesNotHaveAwfulString)
                    .withLineValidator(lineDoesNotHaveBadString).withSkipLines(1).build();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                if ((nextRecord[0]).equals(ItemId)) {
                    logger.info("reading the required record in csv file with the given item id");
                    break;
                }
            }
            if (nextRecord != null) {
                im.setId(Long.parseLong(nextRecord[0]));
                im.setItem_name(nextRecord[1]);
                im.setItem_desc(nextRecord[2]);
                im.setItem_price(Long.parseLong(nextRecord[3]));
            }
        } catch (CsvValidationException e) {
            logger.error(e.getMessage());
            throw e;
        } catch (IOException e) {
            logger.error("error when I/O failed or interrupted while reading a single item");
            throw e;
        }
        return im;
    }
}
