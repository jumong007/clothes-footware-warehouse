package com.company.controller;

public interface BaseController {
    void showAll(String sort);

    void findByID();

    void findByColor();
    void findBySize();
    void findByOwner();

    void filterByPrice();
}
