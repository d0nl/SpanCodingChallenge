## Span Coding Challenge

A command-line application that calculates the ranking table for a league.

* Java 8 
* IntelliJ IDEA 2022.1.1 (Community Edition)
* Build #IC-221.5591.52, built on May 10, 2022

#### To build the project Maven is required:
`mvn clean compile package`

#### To run unit tests:
`mvn test`

#### Example of piping a file to the program on Windows from the project folder:
`type src\test\resources\sampleinput.txt | java -jar target\SpanCodingChallenge-1.0-SNAPSHOT.jar > out.txt`

#### Example of supplying input and output files to the program on Windows from the project folder:
`java -jar target\SpanCodingChallenge-1.0-SNAPSHOT.jar src\test\resources\sampleinput.txt .\out.txt`
