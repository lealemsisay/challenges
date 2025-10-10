# Chapter 1 Challenge: The Cryptic Message Decoder

##  Project Overview
A Java application that decrypts secret messages hidden within integers using mathematical operations. This program demonstrates core Java concepts including variables, operators, input validation, and exception handling.It also take input from user.

## 📋 Project Details
- **Project Name**: Chapter1_Challenge_1_1
- **Java Class**: Chapter1_Challenge_1_1.java
- **Package**: Chapter1_Challenge_1_1
- **Technology**: Java Console Application

## Mission Objective
You are a secret agent who intercepted a cryptic message. The message is an integer, but the real information is hidden within it through a series of mathematical operations.

##  How the Decoding Works
For an input like `13579`, the program:
1. **Extracts** first digit (1) and last digit (9)
2. **Calculates** product of first and last digits (1 × 9 = 9)
3. **Extracts** second digit (3) and second-last digit (7)
4. **Calculates** sum of second and second-last digits (3 + 7 = 10)
5. **Combines** results as strings: "9" + "10" = **"910"**

##  How to Run

### Prerequisites
- Java JDK 8 or later
- Command line terminal

### Steps to Run
1. **Compile the Java file:**
   ```bash
   javac Chapter1_Challenge_1_1.java
