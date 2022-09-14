package com.github.curriculeon;

import java.io.File;
import java.io.IOException;

public class MainApplication  {
    public static void main(String[] args) throws IOException {

        String projectDirectory = System.getProperty("user.dir");
        String srcMain = projectDirectory + "/src/main";
        String newFileName = srcMain + "/hello-world.txt";
        File file = new File(newFileName);
        file.createNewFile();
    }


}
