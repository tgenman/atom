package com.dmitrybondarev.bullsandcows.view;

public interface View {

    void printWelcomeMessage();

    void printWordLength(int lengthAnswer);

    String askGuess(int lengthAnswer);

    void printBullsAndCows(int bulls, int cows, int attempts);

    void printWin();

    void printLose(String answer);

    boolean wouldNewGame();
}
