package org.imesh.java.benchmark.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Generate a sample log file.
 */
public class LogFileGeneratorMain {
    
    public static void main(String[] args) {
        String filePath = "/tmp/foo.log";
        int lines = 1024*100;

        Logger logger = Logger.getLogger(LogFileGeneratorMain.class.getName());
        FileHandler fileHandler = null;

        try {
            // Append to the same file
            fileHandler = new FileHandler(filePath, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Avoid printing to STDOUT
        logger.setUseParentHandlers(false);
        // Add file handler
        logger.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);

        System.out.println("Generating " + lines + " log lines to file " + filePath + " ...");
        for (int i = 0; i < lines; i++) {
            try {
                logger.info(String.valueOf(Math.random()));
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        long fileSize = 0;
        try {
            fileSize = Files.size(Paths.get(filePath))/(1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Log file generated successfully, file size: " + fileSize + " MB");
    }
}
