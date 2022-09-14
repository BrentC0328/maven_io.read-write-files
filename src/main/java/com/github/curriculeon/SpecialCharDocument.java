package com.github.curriculeon;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author leon on 18/11/2018.
 */
public class SpecialCharDocument extends Document {
    public SpecialCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
        if (!isSpecialCharacters(contentToBeWritten)){
            throw new IllegalArgumentException();
        }
        super.write(contentToBeWritten);
    }

    private Boolean isSpecialCharacters(String s) {
        String specialCharacters = "!@#$%^&*()-=_+";
        String[] specialArray = specialCharacters.split("");

        List<String> specialList = Arrays.asList(specialArray);

        String[] inputCharacters = s.split("");

        for (String character : inputCharacters){
            if (!specialList.contains(character)){
                return false;
            }
        }
        return true;
    }
}
