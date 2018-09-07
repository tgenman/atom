package com.dmitrybondarev.bullsandcows.model;

import java.util.List;
import java.util.Random;

public class WordsBase {

    private final Random random = new Random();

    private List<String> words;

    public WordsBase(List<String> words) {
        this.words = words;
    }

    public String getRandomWord() {
        int lengthList = words.size();
        int index = random.nextInt(lengthList + 1);
        return words.get(index);
    }
}
