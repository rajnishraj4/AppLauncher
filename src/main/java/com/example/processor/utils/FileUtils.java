package com.example.processor.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void createDirectory()
    {

    }

    public static void replace(String filePath, String str1, String str2) {
        String originalFileContent = "";
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String currentReadingLine = reader.readLine();

            while (currentReadingLine != null) {
                originalFileContent += currentReadingLine + System.lineSeparator();
                currentReadingLine = reader.readLine();
            }

            String modifiedFileContent = originalFileContent.replaceAll(str1, str2);
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(modifiedFileContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}