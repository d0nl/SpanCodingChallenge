## Span Coding Challenge

A command-line application that calculates the ranking table for a league.

#### Notes:

*The application has been developed to work on Windows as well as Linux and other*
*Unix-like OS's like Apples OSX.*
*Both stdin/stdout and file support has been included for extra flexibility.*
*Application may be called from batch files with full error code support for*
*decision-making purposes.*

#### Development environment

* Java 8 
* IntelliJ IDEA 2022.1.1 (Community Edition)
Build #IC-221.5591.52, built on May 10, 2022
* Windows 10 Professional
* Tested on Windows 10, Ubuntu under Docker dev-environment

#### To build the project Maven is required:
`mvn clean compile package`

#### To run unit tests:
`mvn test`

#### Example of piping a file to the program on Windows from the project folder:
`type src\test\resources\sampleinput.txt | java -jar target\SpanCodingChallenge-1.0-SNAPSHOT.jar > out.txt`

#### Example of supplying input and output files to the program on Windows from the project folder:
`java -jar target\SpanCodingChallenge-1.0-SNAPSHOT.jar src\test\resources\sampleinput.txt .\out.txt`
