package com.dmitrybondarev.bullsandcows.view;

import java.util.Scanner;

public class CommandLine implements View {

    private Scanner scanner = new Scanner(System.in);

    public void printWelcomeMessage() {
        System.out.println("Welcome to the game of BULLS and COWS.");
        System.out.println("The objective in this game is for you to guess word.");
        System.out.println("The computer responds with how close your guess is to the target.");
        System.out.println("BULLS = # number of right letters in the right position.");
        System.out.println("COWS = # number of right letters in the wrong position.");
        System.out.println();
    }

    public void printWordLength(int lengthAnswer) {
        System.out.println("Word length = " + lengthAnswer);
        System.out.println("Lucky game");
    }

    @Override
    public void printBullsAndCows(int bulls, int cows, int attempts) {
        System.out.println("Dont guess. Bulls = " + bulls + "; Cows = " + cows + "; Attempts = " + attempts + ";");
    }

    @Override
    public String askGuess(int lengthAnswer) {
        System.out.println("Write your guess");
        String guess = "";
        boolean asking = true;
        while (asking) {
            guess = scanner.nextLine();
            if (guess.length() == lengthAnswer) {
                break;
            } else {
                System.out.println("Invalid guess. Length isnt right. Please, try again");
            }
        }
        return guess;
    }

    @Override
    public void printWin() {
        System.out.println("================");
        System.out.println("You are Win");
    }

    @Override
    public void printLose(String answer) {
        System.out.println("================");
        System.out.println("You are Lose. Answer = " + answer);
    }

    @Override
    public boolean wouldNewGame() {
        System.out.println("Would you like start new game? yes/no");
        String input = "";
        boolean result = false;
        boolean asking = true;

        while (asking) {
            input = scanner.nextLine();
            switch (input) {
                case "yes":
                    result = true;
                    asking = false;
                    break;
                case "no":
                    result = false;
                    asking = false;
                    break;
                default:
                    System.out.println("Invalid answer. Please, try again");
            }
        }
        return result;
    }
}
