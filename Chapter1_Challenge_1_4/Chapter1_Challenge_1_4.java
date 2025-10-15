package Chapter1_Challenge_1_4;

 
import java.io.*;
import java.util.Scanner;

public class Chapter1_Challenge_1_4 {
    
    public static void main(String[] args) {
        readConfigFile();
    }
    
    public static void readConfigFile() {
        // Try-with-resources automatically handles closing and null checks
        try (Scanner fileScanner = new Scanner(new File("config.txt"))) {
            
            // Read first line - config version
            String versionLine = fileScanner.nextLine();
            int configVersion = Integer.parseInt(versionLine);
            
            // Check if version is valid
            if (configVersion < 2) {
                throw new Exception("Config version too old!");
            }
            
            // Read second line - file path
            String filePath = fileScanner.nextLine();
            
            // Check if the file at that path exists
            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                throw new IOException("File at path '" + filePath + "' does not exist!");
            }
            
            System.out.println("Config successfully loaded!");
            System.out.println("Version: " + configVersion);
            System.out.println("Target file exists: " + filePath);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Configuration file 'config.txt' not found!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: First line must be a valid integer number!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // This must always execute
            System.out.println("Config read attempt finished.");
        }
    }
}