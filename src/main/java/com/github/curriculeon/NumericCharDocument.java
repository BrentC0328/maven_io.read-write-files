package com.github.curriculeon;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author leon on 16/11/2018.
 */
public class NumericCharDocument extends Document {
    public NumericCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
        if (!isNumeric(contentToBeWritten)) {
            throw new IllegalArgumentException();
        }
        super.write(contentToBeWritten);
    }

    private Boolean isNumeric(String s) {
        String numbers = "0123456789";
        String[] numbersArray = numbers.split("");

        List<String> numbersList = Arrays.asList(numbersArray);

        String[] inputCharacters = s.split("");

        for (String character : inputCharacters) {
            if (!numbersList.contains(character)) {
                return false;
            }
        }
        return true;


    }
}
