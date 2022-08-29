package ru.netology.domain;

import ru.netology.domain.Product;

public class Phone extends Product {
    private String manufacturer;

    public Phone() {
    }

    public Phone(int id, String name, int cost, String manufacturer) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || getManufacturer().equalsIgnoreCase(search);
    }

}