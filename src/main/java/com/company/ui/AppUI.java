package com.company.ui;

import com.company.controller.FormalWearController;
import com.company.controller.ShoeController;
import com.company.controller.TraditionalWearController;
import com.company.utils.BaseUtils;

import java.util.Objects;

public class AppUI {

    private final FormalWearController formalWearController = new FormalWearController();
    private final ShoeController shoeController = new ShoeController();
    private final TraditionalWearController traditionalWearController = new TraditionalWearController();

    public void run() {
        BaseUtils.println("\n\n1 -> Formal wear");
        BaseUtils.println("2 -> Shoe");
        BaseUtils.println("3 -> Traditional wear");
        BaseUtils.println("q -> Quit");

        BaseUtils.print("-- Select operation: ");
        switch (BaseUtils.readText()) {
            case "1" -> formalWearUI();
            case "2" -> ShoeUI();
            case "3" -> traditionalWearUI();
            case "q" -> System.exit(0);
            default -> BaseUtils.println("Wrong choice!");
        }
        run();
    }

    public String baseUI() {
        BaseUtils.println("1 -> Show all");
        BaseUtils.println("2 -> Find by id");
        BaseUtils.println("3 -> Find by color");
        BaseUtils.println("4 -> Find by size");
        BaseUtils.println("5 -> Find by owner");
        BaseUtils.println("6 -> Filter by price");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("Select operation: ");
        return BaseUtils.readText();
    }

    private void formalWearUI() {
        BaseUtils.println("\n\n7 -> Find by job");
        switch (baseUI()) {
            case "1" -> showAllFormalWear();
            case "2" -> formalWearController.findByID();
            case "3" -> formalWearController.findByColor();
            case "4" -> formalWearController.filterByPrice();
            case "5" -> formalWearController.findBySize();
            case "6" -> formalWearController.findByOwner();
            case "7" -> formalWearController.findByJob();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        formalWearUI();
    }

    private String showUI() {
        BaseUtils.println("\n\n1 -> Sort by id");
        BaseUtils.println("2 -> Sort by price");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("-- Select operation: ");
        return BaseUtils.readText();
    }

    private void showAllFormalWear() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            formalWearUI();
        }
        formalWearController.showAll(operation);
        showAllFormalWear();
    }

    private void ShoeUI() {
        BaseUtils.println("\n\n5 -> Find by type");
        switch (baseUI()) {
            case "1" -> showAllShoes();
            case "2" -> shoeController.findByID();
            case "3" -> shoeController.findByColor();
            case "4" -> shoeController.filterByPrice();
            case "5" -> shoeController.findBySize();
            case "6" -> shoeController.findByOwner();
            case "7" -> shoeController.findByType();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        ShoeUI();
    }

    private void showAllShoes() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            ShoeUI();
        }
        shoeController.showAll(operation);
        showAllShoes();
    }

    private void traditionalWearUI() {
        BaseUtils.println("\n\n7 -> Find by country");
        switch (baseUI()) {
            case "1" -> showAllTraditionalWear();
            case "2" -> traditionalWearController.findByID();
            case "3" -> traditionalWearController.findByColor();
            case "4" -> traditionalWearController.filterByPrice();
            case "5" -> traditionalWearController.findBySize();
            case "6" -> traditionalWearController.findByOwner();
            case "7" -> traditionalWearController.findByCountry();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        traditionalWearUI();
    }

    private void showAllTraditionalWear() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            traditionalWearUI();
        }
        traditionalWearController.showAll(operation);
        showAllTraditionalWear();
    }
}
