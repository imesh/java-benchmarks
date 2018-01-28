package org.imesh.java.benchmark.file;

/**
 * Line reader callback to be invoked when a line of a file is read.
 */
public interface LineReaderCallback {
    
    void readLine(String line);
}
