package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    private List<Guess> guesses = new ArrayList<Guess>();

    public static void main(String[] args) {
        Game app = new Game();
        app.run();
    }

    public Guess parseGuess(String str) {
        String[] numbers = str.split(" ");
        if (numbers.length < 3) {
            System.out.println("Too few numbers for a guess");
            return null;
        }
        if (numbers.length > 3) {
            System.out.println("Too many numbers for a guess");
            return null;
        }
        int a, b, c;
        try {
            a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);
            c = Integer.parseInt(numbers[2]);
        } catch (Exception e) {
            System.out.println("Complete gibberish");
            return null;
        }
        return new Guess(a, b, c);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        printInstructions();

        boolean done = false;
        // Start of the loop
        while (!done) {
            System.out.println("Enter 'Answer' or 'Previous' or 3 numbers seperated by spaces: ");
            String choice = scanner.nextLine();

            switch (choice.toLowerCase()) {

                case "answer":
                    System.out.println("Please enter your rules of the game: ");
                    String input = scanner.nextLine();
                    System.out.println("Your choice was: " + input);
                    System.out.println("The rule is: Each number must be larger than the one before it");
                    done = true;
                    break;

                case "previous":
                    System.out.println("Previous guesses: ");
                    for (Guess guess : guesses) {
                        System.out.println(guess);
                    }
                    break;

                case "?":
                case "help":
                    printInstructions();
                    break;

                default:
                    Guess guess = parseGuess(choice);
                    if (guess != null) {
                        guesses.add(guess);
                        System.out.println(guess);
                    } else {
                        System.out.println("An invalid option");
                    }

            }
        }
    }

    // Game introduction and rules
    public void printInstructions() {
        System.out.println("We’ve chosen a rule that some sequences of three numbers obey — and some do not. Your job is to guess what the rule is");
        System.out.println("For example the sequence 2,4,8 obeys the rule");
        System.out.println("Now it’s your turn. Enter a number sequence in the boxes below, and we’ll tell you whether it satisfies the rule or not. ");
        System.out.println("Enter Answer to guess the rules for the sequence");
        System.out.println("Enter Previous to print out all previous guesses");
    }
}


