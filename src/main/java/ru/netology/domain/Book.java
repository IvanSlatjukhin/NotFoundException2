package ru.netology.domain;

import ru.netology.domain.Product;

public class Book extends Product {
    private String author;

    public Book() {
    }

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || getAuthor().equalsIgnoreCase(search);
    }
}