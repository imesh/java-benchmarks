# Java Benchmarks

This repository contains benchmark tests for comparing performance sensitive Java 
feature implementations.

## Benchmarks

- Reading large files

  Main class: org.imesh.java.benchmark.file.FileReaderBenchmarkMain

## Getting Started

1. Clone this repository:
   
   ````bash
   git clone https://github.com/imesh/java-benchmarks
   ````
   
2. Build using Maven:
   
   ````bash
   cd java-benchmarks
   mvn clean install
   ````
   
3. Execute required benchmark test:
   
   ````bash
   java -cp target/java-benchmarks-1.0-SNAPSHOT.jar org.imesh.java.benchmark.file.FileReaderBenchmarkMain
   ````
   
   Sample output:
   
   ````bash
   Warming up the JVM...
   [START] -> Max Memory: 1820 MB | Total Memory: 123 MB | Free Memory: 121 MB | Total Free Memory: 1818 MB
   [END]   -> Max memory: 1820 MB | Total Memory: 134 MB | Free Memory: 87 MB | Total Free Memory: 1773 MB
   Memory Consumption: 45 MB | Execution time: 2 seconds
   
   Read with java.io.BufferedReader:
   [START] -> Max Memory: 1820 MB | Total Memory: 134 MB | Free Memory: 87 MB | Total Free Memory: 1773 MB
   [END]   -> Max memory: 1820 MB | Total Memory: 145 MB | Free Memory: 118 MB | Total Free Memory: 1793 MB
   Memory Consumption: -20 MB | Execution time: 2 seconds
   
   Read with java.nio.file.Files:
   [START] -> Max Memory: 1820 MB | Total Memory: 145 MB | Free Memory: 118 MB | Total Free Memory: 1793 MB
   [END]   -> Max memory: 1820 MB | Total Memory: 148 MB | Free Memory: 98 MB | Total Free Memory: 1770 MB
   Memory Consumption: 23 MB | Execution time: 2 seconds
   
   Read with java.util.Scanner:
   [START] -> Max Memory: 1820 MB | Total Memory: 148 MB | Free Memory: 98 MB | Total Free Memory: 1770 MB
   [END]   -> Max memory: 1820 MB | Total Memory: 308 MB | Free Memory: 249 MB | Total Free Memory: 1761 MB
   Memory Consumption: 9 MB | Execution time: 21 seconds
   ````

## License

Licensed under Apache 2.0