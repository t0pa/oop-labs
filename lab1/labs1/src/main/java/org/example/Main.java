package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        printName();
        // printMessage();
        // calculateSecondsInYear();
        // sumTwoNumbers();
        // checkIfPositive();
        // compareTwoNumbers();
    }

    public static void printName() {
        System.out.println("Your Name");
    }

    public static void printMessage() {
        System.out.println("This is a custom message.");
    }

    public static void calculateSecondsInYear() {
        int daysInYear = 365;
        int secondsInDay = 24 * 60 * 60; // hours * minutes * seconds
        int secondsInYear = daysInYear * secondsInDay;

        System.out.println("There are " + secondsInYear + " seconds in a year.");
    }

    public static void sumTwoNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;
        System.out.println("The sum of the two numbers is: " + sum);
    }

    public static void checkIfPositive() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number > 0) {
            System.out.println("The number is positive.");
        } else {
            System.out.println("The number is not positive.");
        }
    }

    public static void compareTwoNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        if (num1 > num2) {
            System.out.println(num1 + " is greater than " + num2);
        } else if (num2 > num1) {
            System.out.println(num2 + " is greater than " + num1);
        } else {
            System.out.println("Both numbers are equal.");
        }
    }
}
