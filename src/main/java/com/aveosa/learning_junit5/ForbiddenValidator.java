package com.aveosa.learning_junit5;

import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.validators.LineValidator;

public class ForbiddenValidator implements LineValidator {
    public String forbidden_string;
    public String message;

    public ForbiddenValidator(String forbidden_string) {
        this.forbidden_string = forbidden_string;
        this.message = "the line should not contain " + forbidden_string;

    }


    @Override
    public boolean isValid(String line) {
        if (line == null || forbidden_string == null)
            return true;
        return !line.contains(forbidden_string);
    }

    @Override
    public void validate(String line) throws CsvValidationException {
        if (!isValid(line))
            throw new CsvValidationException(message);
    }

}
