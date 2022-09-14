package com.github.curriculeon;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author leon on 16/11/2018.
 */
public class AlphaCharDocument extends Document {
    public AlphaCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
        if (!isAlpha(contentToBeWritten)){
            throw new IllegalArgumentException();
        }
        super.write(contentToBeWritten);
    }

    private Boolean isAlpha(String s) {
        String specialCharacters = " abcdefghijklmnopqrstuvwxyz";
        String[] specialArray = specialCharacters.split("");

        List<String> specialList = Arrays.asList(specialArray);

        String[] inputCharacters = s.split("");

        for (String character : inputCharacters){
            if (!specialList.contains(character.toLowerCase(Locale.ROOT))){
                return false;
            }
        }
        return true;
    }
}
