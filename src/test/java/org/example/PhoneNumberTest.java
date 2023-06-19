package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class PhoneNumberTest {

    @Test
    public void test() throws IllegalArgumentException {
        PhoneNumber phoneNumber = new PhoneNumber("+1 (613)-995-0253");

        System.out.println(phoneNumber.getNumber());
    }

    @Test
    public void test9Numbers(){
        PhoneNumber phoneNumber = new PhoneNumber("2234526789");
        System.out.println(phoneNumber.getNumber());
    }

    @Test
    public void invalidWhen9Digits() {
        IllegalArgumentException expected = assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("123456789"));
        assertThat(expected).hasMessage("incorrect number of digits");
    }

    @Test
    public void cleansNumbersWithMultipleSpaces() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("223 456   7890   ").getNumber();
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void invalidIfAreaCodeStartsWith0OnValid11DigitNumber() {
        IllegalArgumentException expected = assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("1 (023) 456-7890"));
        assertThat(expected).hasMessage("area code cannot start with zero");
    }

    @Test
    public void invalidIfExchangeCodeStartsWith0OnValid11DigitNumber() {
        IllegalArgumentException expected = assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("1 (223) 056-7890"));
        assertThat(expected).hasMessage("exchange code cannot start with zero");
    }
}
