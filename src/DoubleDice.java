import java.util.Scanner;
public class DoubleDice {
    public static void main(String[] args) {
        Die die1 = new Die();
        Die die2 = new Die();
        Scanner scnr = new Scanner(System.in);
        double input, money;
        money = 100.00;
        input = getInput(scnr, money); // Calls getInput method in this class to get and validate double
        
        while (!(Math.abs(input - 0) < 0.0001)) { // Check if input is not 0

            if (input < 0 || ((input - money) > 0.0001)) { //Check if input is negative or greater than balance 
                System.out.println("Bet is an invalid amount. Please try again.");
                System.out.println();
                input = getInput(scnr, money); // Ask for input again
            }
            else {
                die1.roll();
                die2.roll();
                System.out.println("You rolled a " + die1.toString() + " and " + die2.toString()); // Calls toString override to get dice roll value in a word
                if (die1.equals(die1.die, die2.die)) { // Uses equals method to compare dice rolls
                    System.out.printf("You win $%.2f\n", input);
                    money += input; // Adds the bet amount if winner
                }
                else {
                    System.out.printf("You lose $%.2f\n", input);
                    money -= input; // Removes the bet amount if loser
                }
                if ((Math.abs(money - 0) < 0.0001)) { //Check if the player is out of money
                    System.out.println();
                    System.out.println("You are out of money!");
                    System.out.println("Better luck next time");
                    break; // Exits the loop
                }
                System.out.println();
                input = getInput(scnr, money); // Ask for new bet amount
            } 
        }

        if ((Math.abs(input - 0) < 0.0001)) { // Only runs if the user input is 0 and not out of money
            System.out.println();
            if (money < 100.0) { // Check if balance is less than the starting amount
                System.out.println("At least you're not leaving empty handed!");
            }
            else if ((Math.abs(money - 100) < 0.0001)) { // Check if you still have 100 dollars
                System.out.println("Could have been worse!");
            }
            else { // Check if you made money
                System.out.println("See you around, winner!");
            }      
        }
        scnr.close();
    }

    public static double getInput(Scanner scnr, double money) { // Method to ask for user input and check if the value is actually a number
        boolean isDouble = false;
        double input = 0;
        while (!isDouble) { // Loops asking for input until a number is given
            System.out.printf("You have $%.2f\n", money);
            System.out.print("How much would you like to bet (Enter 0 to quit)? ");
            String numAsString = scnr.next();
            try {
                input = Double.parseDouble(numAsString); // Attempts to parse the string as a double
                isDouble = true; // Exits loop if exception is not thrown
            }
            catch(Exception e) { // Catches exception if the string can not be parsed as a double
                System.out.println("Error not a number. Please try again.");
                System.out.println();
            }
        }
        return input; // Returns input once a number is given
    }
}
