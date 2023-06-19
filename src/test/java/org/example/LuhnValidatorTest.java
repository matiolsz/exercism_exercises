package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LuhnValidatorTest {
    LuhnValidator luhnValidator = new LuhnValidator();

    @Test
    public void testValidNumberWithAnOddNumberOfSpaces() {
        assertTrue(luhnValidator.isValid("234 567 891 234"));
    }


    @Test
    public void testSimpleValidSINReversedRemainsValid() {
        assertTrue(luhnValidator.isValid("059"));
    }

    @Test
    public void testValidCanadianSINValid() {
        assertTrue(luhnValidator.isValid("055 444 285"));
    }
}
