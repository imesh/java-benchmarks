package org.imesh.java.benchmark.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * File reader utility.
 */
public class FileReaderUtil {

    /**
     * Reade files with java.nio.file.Files
     * @param filePath
     * @param callback
     * @throws IOException
     */
    public static void readWithFiles(String filePath, LineReaderCallback callback) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filePath));
        lines.forEach(line -> callback.readLine(line));
    }

    /**
     * Read files with java.io.BufferedReader
     * @param filePath
     * @param callback
     * @throws IOException
     */
    public static void readWithBufferedReader(String filePath, LineReaderCallback callback) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            callback.readLine(line);
        }
    }

    /**
     * Read files with java.util.Scanner
     * @param filePath
     * @param callback
     * @throws FileNotFoundException
     */
    public static void readWithScanner(String filePath, LineReaderCallback callback) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));
        while (sc.hasNextLine()) {
            callback.readLine(sc.nextLine());
        }
    }
}
