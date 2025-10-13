package Chapter1_Challenge_1_1;

 public class LotteryNumberAnalyzer {
    public static void main(String[] args) {

         String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};

         double highestAverage = 0;
        String highestAverageNumber = "";

         for (String number : winningNumbers) {

             String cleaned = number.replace("-", "");

             char[] chars = cleaned.toCharArray();

             int[] digits = new int[chars.length];

            int sum = 0;

             for (int i = 0; i < chars.length; i++) {
                digits[i] = Character.getNumericValue(chars[i]);
                sum += digits[i];
            }

             double average = (double) sum / digits.length;

             System.out.println("Analyzing: " + number);
            System.out.println("Digit Sum: " + sum + ", Digit Average: " + average);
            System.out.println(); // blank line for readability

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

 
