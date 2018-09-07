package com.dmitrybondarev.bullsandcows.controller;

import com.dmitrybondarev.bullsandcows.model.Checker;
import com.dmitrybondarev.bullsandcows.model.WordsBase;
import com.dmitrybondarev.bullsandcows.view.CommandLine;
import com.dmitrybondarev.bullsandcows.view.View;

import java.io.IOException;

public class GameController {

    private WordsBase wordsBase;

    private View view;

    private final String resourceName = "dictionary.txt";

    private final int startAttempts = 10;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GameController.class);

    public void startGame() {
        setDependencies();
        view.printWelcomeMessage();

        boolean wantStartNewGame = true;
        while (wantStartNewGame) {
            String answer = wordsBase.getRandomWord();
            Checker checker = new Checker(answer);
            int remainAttempts = startAttempts;
            view.printWordLength(answer.length());

            while (true) {
                String guess = view.askGuess(answer.length());

                if (checker.checkWin(guess)) {
                    view.printWin();
                    break;
                } else {
                    remainAttempts--;
                    int bulls = checker.getBulls(guess);
                    int cows = checker.getCows(guess);
                    view.printBullsAndCows(bulls, cows, remainAttempts);
                }

                if (remainAttempts == 0) {
                    view.printLose(answer);
                    break;
                }
            }
            wantStartNewGame = view.wouldNewGame();
        }
    }

    private void setDependencies() {
        try {
            this.wordsBase = new WordsBase(ResourceReader.readFromResource(resourceName));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        this.view = new CommandLine();
    }

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
