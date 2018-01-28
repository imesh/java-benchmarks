package org.imesh.java.benchmark.file;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Java file reader benchmark main class.
 */
public class FileReaderBenchmarkMain {
    
    private static long startTime;
    private static long startTotalMem;
    private static long startFreeMem;
    private static long startTotalFreeMem;

    public static void main(String[] args) {
        String filePath = "/tmp/foo.log";
        LineReaderCallback callback = new LineReaderCallback() {
            @Override
            public void readLine(String line) {
            }
        };

        System.out.println("Warming up the JVM...");
        start();
        try {
            FileReaderUtil.readWithBufferedReader(filePath, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
        end();

        System.out.println("Read with java.io.BufferedReader:");
        start();
        try {
            FileReaderUtil.readWithBufferedReader(filePath, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
        end();

        System.out.println("Read with java.nio.file.Files:");
        start();
        try {
            FileReaderUtil.readWithFiles(filePath, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
        end();

        System.out.println("Read with java.util.Scanner:");
        start();
        try {
            FileReaderUtil.readWithScanner(filePath, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
        end();
    }

    private static void start() {
        startTime = System.currentTimeMillis();
        long maxMem = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        startTotalMem = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        startFreeMem = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        startTotalFreeMem = startFreeMem + (maxMem - startTotalMem);

        System.out.println("[START] -> " +
                "Max Memory: " + maxMem + " MB" + " | " +
                "Total Memory: " + startTotalMem + " MB" + " | " +
                "Free Memory: " + startFreeMem + " MB" + " | " +
                "Total Free Memory: " + startTotalFreeMem + " MB");
    }

    private static void end() {
        long endTime = System.currentTimeMillis();
        long endMaxMem = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        long endTotalMem = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        long endFreeMem = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        long endTotalFreeMem = endFreeMem + (endMaxMem - endTotalMem);

        System.out.println("[END]   -> " +
                "Max memory: " + endMaxMem + " MB" + " | " +
                "Total Memory: " + endTotalMem + " MB" + " | " +
                "Free Memory: " + endFreeMem + " MB" + " | " +
                "Total Free Memory: " + endTotalFreeMem + " MB" + System.lineSeparator() +
                "Memory Consumption: " + (startTotalFreeMem - endTotalFreeMem) + " MB" + " | " +
                "Execution time: " + TimeUnit.SECONDS.convert((endTime - startTime), TimeUnit.MILLISECONDS) + " seconds" +
                System.lineSeparator());
    }
}
