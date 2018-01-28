# Java Benchmarks

This repository contains benchmark tests for comparing performance sensitive Java 
feature implementations.

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

## Licence

Licenced under Apache 2.0