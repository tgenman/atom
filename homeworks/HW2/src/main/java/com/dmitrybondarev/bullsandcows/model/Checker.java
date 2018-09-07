package com.dmitrybondarev.bullsandcows.model;

import java.util.ArrayList;
import java.util.List;

public class Checker {

    private final String answer;

    public Checker(String answer) {
        this.answer = answer;
    }

    public boolean checkWin(String guess) {
        if (this.getBulls(guess) == answer.length())
            return true;
        return false;
    }

    public int getBulls(String guess) {
        int result = 0;
        char[] answerChars = answer.toCharArray();
        char[] guessChars = guess.toCharArray();
        for (int i = 0; i < answerChars.length; i++) {
            if (answerChars[i] == guessChars[i]) result++;
        }
        return result;
    }

    public int getCows(String guess) {
        int result = 0;
        String[] answerSplit = answer.split("(?!^)");
        String[] guessSplit = guess.split("(?!^)");

        List<String> answerList = new ArrayList<>();
        for (String str: answerSplit) {
            answerList.add(str);
        }

        for (int i = 0; i < guessSplit.length; i++) {
            if (answerList.contains(guessSplit[i])) {
                if (!answerSplit[i].equals(guessSplit[i])) {
                    answerList.remove(guessSplit[i]);
                    result++;
                }
            }
        }
        return result;
    }
}
