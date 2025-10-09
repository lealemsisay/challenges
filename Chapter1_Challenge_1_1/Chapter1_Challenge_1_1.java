package Chapter1_Challenge_1_1;
 
import java.util.Scanner;
import java.util.InputMismatchException;

public class Chapter1_Challenge_1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;
        
        System.out.println("Welcome to Secret Agent Cryptic Message Decoder!");
        System.out.println("==================================================");
        
        while (continueProgram) {
            int number = 0;
            boolean validInput = false;
            
             while (!validInput) {
                try {
                    System.out.print("\nEnter a positive integer (at least 2 digits): ");
                    number = scanner.nextInt();
                    
                     if (number <= 0) {
                        System.out.println(" Error: Please enter a POSITIVE integer (greater than 0).");
                        continue;
                    }
                    
                     if (number < 10) {
                        System.out.println("Error: Please enter a number with at least 2 digits.");
                        continue;
                    }
                    
                    validInput = true;
                    
                } catch (InputMismatchException e) {
                    System.out.println(" Error: That's not a valid number! Please enter digits only.");
                    scanner.next(); // Clear invalid input
                }
            }
            
            // Decode the number
            try {
                // Get last digit
                int lastDigit = number % 10;
                
                // Count digits
                int numDigits = (int) Math.log10(number) + 1;
                
                // Get first digit  
                int divisor = (int) Math.pow(10, numDigits - 1);
                int firstDigit = number / divisor;
                
                // Get second digit
                int numberWithoutFirst = number % divisor;
                int secondDigit = numberWithoutFirst / (divisor / 10);
                
                // Get second-last digit
                int numberWithoutLast = number / 10;
                int secondLastDigit = numberWithoutLast % 10;
                
                // Calculate results
                int product = firstDigit * lastDigit;
                int sum = secondDigit + secondLastDigit;
                
                // Combine as final code
                String result = product + "" + sum;
                
                System.out.println("\nDECODING RESULTS:");
                System.out.println("====================");
                System.out.println("Original message: " + number);
                System.out.println("First digit: " + firstDigit);
                System.out.println("Last digit: " + lastDigit);
                System.out.println("Product (first × last): " + product);
                System.out.println("Second digit: " + secondDigit);
                System.out.println("Second-last digit: " + secondLastDigit);
                System.out.println("Sum (second + second-last): " + sum);
                System.out.println("Final decoded code: " + result);
                
            } catch (Exception e) {
                System.out.println(" Error during decoding: " + e.getMessage());
            }
            
            // Ask if user wants to continue
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    System.out.println("\n--- What would you like to do? ---");
                    System.out.println("1. Continue decoding another number");
                    System.out.println("2. Leave the program");
                    System.out.print("Enter your choice (1 or 2): ");
                    
                    int choice = scanner.nextInt();
                    
                    if (choice == 1) {
                        validChoice = true;
                        System.out.println("\n Continuing with new number...");
                    } else if (choice == 2) {
                        validChoice = true;
                        continueProgram = false;
                        System.out.println("\nThank you for using Secret Agent Decoder!");
                        System.out.println("Mission completed! 🎉");
                    } else {
                        System.out.println(" Please enter 1 or 2 only.");
                    }
                    
                } catch (InputMismatchException e) {
                    System.out.println(" Error: Please enter 1 or 2 only.");
                    scanner.next(); // Clear invalid input
                }
            }
        }
        
        scanner.close();
        System.out.println("🔒 Scanner closed. Program ended safely.");
    }
}


