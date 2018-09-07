package com.dmitrybondarev.bullsandcows.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckerTest {

    @Test
    public void testCheckWinThenWin() {
//      Input values
        String answer = "heat";
        String guess = "heat";

//      Test class
        Checker checker = new Checker(answer);

//      Actual values
        boolean result = checker.checkWin(guess);

//      assert
        assertTrue(result);
    }

    @Test
    public void testCheckWinThenNotWin() {
//      Input values
        String answer = "heat";
        String guess = "heal";

//      Test class
        Checker checker = new Checker(answer);

//      Actual values
        boolean result = checker.checkWin(guess);

//      assert
        assertFalse(result);
    }

    @Test
    public void test1() {
//      Input values
        String answer = "heat";
        String guess = "coin";

//      Expected calues
        int expectedBulls = 0;
        int expectedCows = 0;

//      Test class
        Checker checker = new Checker(answer);

//      Actual values
        int actualBulls = checker.getBulls(guess);
        int actualCows = checker.getCows(guess);

//      assert
        assertEquals(expectedBulls, actualBulls);
        assertEquals(expectedCows, actualCows);
    }

    @Test
    public void test2() {
//      Input values
        String answer = "heat";
        String guess = "eats";

//      Expected calues
        int expectedBulls = 0;
        int expectedCows = 3;

//      Test class
        Checker checker = new Checker(answer);

//      Actual values
        int actualBulls = checker.getBulls(guess);
        int actualCows = checker.getCows(guess);

//      assert
        assertEquals(expectedBulls, actualBulls);
        assertEquals(expectedCows, actualCows);
    }

    @Test
    public void test3() {
//      Input values
        String answer = "heat";
        String guess = "teal";

//      Expected calues
        int expectedBulls = 2;
        int expectedCows = 1;

//      Test class
        Checker checker = new Checker(answer);

//      Actual values
        int actualBulls = checker.getBulls(guess);
        int actualCows = checker.getCows(guess);

//      assert
        assertEquals(expectedBulls, actualBulls);
        assertEquals(expectedCows, actualCows);
    }

    @Test
    public void test4() {
//      Input values
        String answer = "abcd";
        String guess = "saax";

//      Expected calues
        int expectedBulls = 0;
        int expectedCows = 1;

//      Test class
        Checker checker = new Checker(answer);

//      Actual values
        int actualBulls = checker.getBulls(guess);
        int actualCows = checker.getCows(guess);

//      assert
        assertEquals(expectedBulls, actualBulls);
        assertEquals(expectedCows, actualCows);
    }
}