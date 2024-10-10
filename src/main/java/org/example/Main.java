package org.example;

import java.util.Scanner;

public class Main {

    // Method 1: Asks the user for a password and shows a secret message if correct
    public static void checkPassword() {
        Scanner scanner = new Scanner(System.in);
        String secretPassword = "secret123";
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (password.equals(secretPassword)) {
            System.out.println("Access granted! Here is the secret message: The cake is a lie.");
        } else {
            System.out.println("Access denied!");
        }
    }

    // Method 2: Asks for three numbers and prints their sum
    public static void sumThreeNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        int sum = num1 + num2 + num3;
        System.out.println("The sum of the numbers is: " + sum);
    }

    // Method 3: Reads numbers from the user and prints their sum until 0 is entered
    public static void sumUntilZero() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int num;

        do {
            System.out.print("Enter a number (0 to stop): ");
            num = scanner.nextInt();
            sum += num;
        } while (num != 0);

        System.out.println("The sum of the entered numbers is: " + sum);
    }

    // Method 4: Asks for first and last numbers, prints all numbers between them
    public static void printNumbersBetween() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter the last number: ");
        int last = scanner.nextInt();

        while (first <= last) {
            System.out.print(first + " ");
            first++;
        }
        System.out.println();
    }

    // Method 5: Calculates sum of 20+21+...+2n where n is entered by the user
    public static void calculateSumOfPowers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number n: ");
        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i <= n; i++) {
            sum += (int)Math.pow(2, i);
        }

        System.out.println("The sum of powers of 2 up to 2^" + n + " is: " + sum);
    }

    // Method 6: Prints a text a specified number of times
    public static void printText(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("In the beginning there were the swamp, the hoe and Java.");
        }
    }

    // Method 7: Draws a half pyramid shape with stars
    public static void drawStarsPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Method 8: Draws an inverted half pyramid
    public static void drawInvertedPyramid(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Method 9: Draws a half pyramid with numbers
    public static void drawNumbersPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // Method 10: Guess number game
    public static void guessNumberGame() {
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = (int) (Math.random() * 101);  // Generate a random number between 0 and 100
        int guess;
        int attempts = 0;

        do {
            System.out.print("Guess the number (0-100): ");
            guess = scanner.nextInt();
            attempts++;

            if (guess > numberToGuess) {
                System.out.println("The number is lower.");
            } else if (guess < numberToGuess) {
                System.out.println("The number is greater.");
            } else {
                System.out.println("Congratulations, your guess is correct!");
            }

            System.out.println("Number of attempts: " + attempts);
        } while (guess != numberToGuess);
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Call methods to test each functionality
        checkPassword();  // Method 1
        sumThreeNumbers();  // Method 2
        sumUntilZero();  // Method 3
        printNumbersBetween();  // Method 4
        calculateSumOfPowers();  // Method 5

        // Method 6: Print text a specific number of times
        System.out.print("How many times should the text be printed? ");
        int times = scanner.nextInt();
        printText(times);

        // Method 7: Draw stars pyramid
        System.out.print("Enter the number of rows for the star pyramid: ");
        int rows = scanner.nextInt();
        drawStarsPyramid(rows);

        // Method 8: Draw inverted pyramid
        System.out.print("Enter the number of rows for the inverted pyramid: ");
        rows = scanner.nextInt();
        drawInvertedPyramid(rows);

        // Method 9: Draw numbers pyramid
        System.out.print("Enter the number of rows for the numbers pyramid: ");
        rows = scanner.nextInt();
        drawNumbersPyramid(rows);

        // Method 10: Guess number game
        guessNumberGame();
    }
}
