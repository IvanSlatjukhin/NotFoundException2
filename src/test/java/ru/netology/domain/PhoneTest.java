package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    Phone phone = new Phone(3, "One Plus 6", 30_000, "BBK Electronics");

    @Test
    public void shouldFindManufacturer() {
        boolean actual = phone.matches("bbk electronics");
        assertTrue(actual);
    }

    @Test
    public void shouldNotFindManufacturer() {
        boolean actual = phone.matches("LG");
        assertFalse(actual);
    }

    @Test
    public void shouldFindName() {
        boolean actual = phone.matches("one plus 6");
        assertTrue(actual);
    }

    @Test
    public void shouldNotFindName() {
        boolean actual = phone.matches("Note A 5");
        assertFalse(actual);
    }

}
