package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book = new Book(1, "Вино из одуванчиков", 3, "Рэй Брэдбери");

    @Test
    public void shouldFindAuthor() {
        boolean actual = book.matches("рэй брэдбери");
        assertTrue(actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        boolean actual = book.matches("рей бредбэри");
        assertFalse(actual);
    }

    @Test
    public void shouldFindName() {
        boolean actual = book.matches("вино из одуванчиков");
        assertTrue(actual);
    }

    @Test
    public void shouldNotFindName() {
        boolean actual = book.matches("пиво из зерна");
        assertFalse(actual);
    }

}
