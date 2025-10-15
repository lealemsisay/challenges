 # Chapter 1 Challenge 4: : Robust File Config Reader
   A Java application that demonstrates robust exception handling while reading configuration files. This program safely handles various file I/O errors and validates configuration data with comprehensive error reporting.
***

## Project Details
- **Project Name**: Chapter1_Challenge_1_4
- **Java Class**: `Chapter1_Challenge_1_4.java`
- **Package**: `Chapter1_Challenge_1_4`
- **Technology**: Java Console Application

***

##  Mission Objective
   Create a robust configuration file reader that handles multiple exception scenarios including missing files, invalid formats, and version compatibility while ensuring the program never crashes.

***

## How the Analysis Works
 The program reads a config.txt file containing:
1. **First line**    Configuration version number (must be ≥ 2)
2. **Second line**    File path to validate existence
 
***

##  How to Run

### Prerequisites
- Java JDK 8 or later
- Command line terminal

### Steps to Run
*Ensure you are in the parent directory that contains the `Chapter1_Challenge_1_4` package folder.*

1. **Compile the Java file:**
   ```bash
   javac Chapter1_Challenge_1_1/Chapter1_Challenge_1_4.java
2.**Run the compiled application:**

   ```Bash
java Chapter1_Challenge_1_4.Chapter1_Challenge_1_4