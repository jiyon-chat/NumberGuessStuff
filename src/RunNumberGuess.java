//Jiyon Chatterjee's Number Guess Game
import java.util.Scanner;
import java.util.ArrayList;

public class RunNumberGuess {
    public static void main(String[] args) { //makes user enter range for guess game
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the lower bound of the number guess range: ");
        int lowerBound = errorCheck(scanner);
        System.out.print("Enter the upper bound of the number guess range: ");
        int upperBound = errorCheck(scanner);
        int correct = (int) (Math.random() * (upperBound - lowerBound + 1) + lowerBound); //generates random integer within user-created range
        ArrayList<Integer> guesses = new ArrayList<Integer>(); //creates Array List to keep track of guesses
        int guessCount = 0;

        while (true) {
            System.out.print("Enter your guess please: ");
            int guess = errorCheck(scanner);
            if (guesses.contains(guess)) { //doesn't count if repeated guess
                System.out.println("You already guessed that number. Please try again.");
            } else { //adds guess to Array List and counts it
                guesses.add(guess);
                guessCount++;
                if (guess == correct) { //if user guesses right, tells them their number of guesses
                    System.out.println("Congrats pal! You guessed the correct number in " + guessCount + " tries.");
                    break;
                } else if (guess < correct) {
                    System.out.println("The number is higher.");
                } else {
                    System.out.println("The number is lower.");
                }
            }
        }
    }
    private static int errorCheck(Scanner scanner){ //error checking method
        while(!scanner.hasNextInt()){
            System.out.print("That's an invalid input. Please enter an integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}