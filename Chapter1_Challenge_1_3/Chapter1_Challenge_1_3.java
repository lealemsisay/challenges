package Chapter1_Challenge_1_3;
 
import java.util.Random;
import java.util.Scanner;

public class Chapter1_Challenge_1_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        boolean playAgain = true;
        
        while (playAgain) {
            int health = 100;
            System.out.println("🏰 Welcome to the Dungeon Game!");
            System.out.println("Your journey begins with " + health + " health.\n");

            boolean defeated = false;
            int room;
            
            // Loop through 5 rooms
            for (room = 1; room <= 5; room++) {
                System.out.println("Entering room " + room + "...");
                int event = rand.nextInt(3) + 1;  // Random number 1–3

                switch (event) {
                    case 1: // Trap
                        System.out.println("💥 A trap sprung! You lose 20 health.");
                        health -= 20;
                        System.out.println("Health is now " + health + ".");
                        break;

                    case 2: // Healing potion
                        System.out.println("🧪 You found a healing potion! +15 health.");
                        health += 15;
                        if (health > 100) {
                            System.out.println("Health exceeded 100! Capped to 100.");
                            health = 100;
                        }
                        System.out.println("Health is now " + health + ".");
                        break;

                    case 3: // Monster encounter
                        System.out.println("👹 A monster appears!");
                        int monsterNumber = rand.nextInt(5) + 1; // Random 1–5
                        int guess = 0;
                        boolean validInput = false;
                        
                        do {
                            System.out.print("Guess a number (1-5) to defeat it: ");
                            
                            // Input validation
                            if (input.hasNextInt()) {
                                guess = input.nextInt();
                                
                                if (guess >= 1 && guess <= 5) {
                                    validInput = true;
                                    
                                    if (guess != monsterNumber) {
                                        System.out.println("❌ Wrong! Try again.");
                                    } else {
                                        System.out.println("✅ You defeated the monster!");
                                    }
                                } else {
                                    System.out.println("❌ Invalid input! Please enter a number between 1 and 5.");
                                }
                            } else {
                                System.out.println("❌ Invalid input! Please enter a valid number (1-5).");
                                input.next(); // Clear the invalid input
                            }
                        } while (!validInput || guess != monsterNumber);
                        break;
                }

                // Check for defeat
                if (health <= 0) {
                    System.out.println("\n💀 You have been defeated in room " + room + "!");
                    System.out.println("🏆 The monsters won this battle!");
                    defeated = true;
                    break;
                }

                System.out.println(); // Space between rooms
            }

            // If player survived all rooms
            if (!defeated) {
                System.out.println("🎉 You cleared the dungeon! Victorious with " + health + " health!");
                System.out.println("🏆 You defeated the dungeon!");
            }

            // Ask if player wants to replay
            System.out.print("\n🔄 Would you like to play again? (yes/no): ");
            String replayResponse = input.next().toLowerCase();
            
            if (!replayResponse.equals("yes") && !replayResponse.equals("y")) {
                playAgain = false;
                System.out.println("Thanks for playing! Goodbye! 👋");
            } else {
                System.out.println("\n\nStarting new game...\n");
            }
        }

        input.close();
    }
}

 