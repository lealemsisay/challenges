package Chapter1_Challenge_1_1;

 public class LotteryNumberAnalyzer {
    public static void main(String[] args) {

        // Step 1: Create the array of winning numbers
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};

        // Variables to remember which number has the highest average
        double highestAverage = 0;
        String highestAverageNumber = "";

        // Step 2: Use a for-each loop to go through each number
        for (String number : winningNumbers) {

            // Remove the dashes (-) to make one long string
            String cleaned = number.replace("-", "");

            // Turn the string into an array of characters
            char[] chars = cleaned.toCharArray();

            // Create an array of integers to hold each digit
            int[] digits = new int[chars.length];

            int sum = 0;

            // Step 3: Use a for loop to convert each character to a number and find the sum
            for (int i = 0; i < chars.length; i++) {
                digits[i] = Character.getNumericValue(chars[i]);
                sum += digits[i];
            }

            // Step 4: Calculate the average
            double average = (double) sum / digits.length;

            // Print the analysis for this number
            System.out.println("Analyzing: " + number);
            System.out.println("Digit Sum: " + sum + ", Digit Average: " + average);
            System.out.println(); // blank line for readability

            // Step 5: Check if this number has the highest average so far
            if (average > highestAverage) {
                highestAverage = average;
                highestAverageNumber = number;
            }
        }

        // Step 6: After checking all, print the final winner
        System.out.println("The winning number with the highest average is: " 
                           + highestAverageNumber + " with an average of " + highestAverage);
    }
}

 