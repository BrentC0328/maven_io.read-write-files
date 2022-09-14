package com.github.curriculeon;


import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.io.FileReader;


/**
 * @author leon on 16/11/2018.
 */
public class Document implements DocumentInterface {

    private final FileWriter fileWriter;
    private final File file;
    private FileReader FileReader;


    public Document(String fileName) throws IOException {
        this(new File(fileName));
    }

    public Document(File file) throws IOException {
        this.file = file;
        this.fileWriter = new FileWriter(file);
    }

    @Override
    public void write(String contentToBeWritten) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(contentToBeWritten);
            bw.close();
        } catch (Exception exception) {
            return;
        }
    }

    @Override
    public void write(Integer lineNumber, String valueToBeWritten) {
        List<String> list = toList();
        list.set(lineNumber, valueToBeWritten);
        String contentToWrite = "";
        for (int i = 0; i < list.size(); i++) {
            String currentString = list.get(i);
            contentToWrite += currentString + "\n";
        }
        overWrite(contentToWrite);


    }


    @Override
    public String read(Integer lineNumber) {
        return toList().get(lineNumber);
    }

    @Override
    public String read() {
        String lineCopy = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String count;

            while ((count = br.readLine()) != null) {
                System.out.println(count);
                lineCopy = lineCopy + count + "\n";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String finishLine = lineCopy.replaceAll("\\R$", "");

        return finishLine;
    }

    @Override
    public void replaceAll(String stringToReplace, String replacementString) {
//        String originalContent = read();
//        String newContent = originalContent.replaceAll(stringToReplace, replacementString);
//        overWrite(newContent);

        overWrite(read().replaceAll(stringToReplace, replacementString));

    }

    @Override
    public void overWrite(String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            bw.write(content);
            bw.close();
        } catch (Exception exception) {
            return;
        }

    }

    public List<String> toList() {
        String[] readed = read().split("\n");
        return Arrays.asList(readed);
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return file.getParentFile() +
                "/" +
                file.getName() +
                "{" +
                read() +
                "}";
    }
}
