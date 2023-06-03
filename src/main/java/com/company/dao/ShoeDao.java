package com.company.dao;

import com.company.config.CustomFileReader;
import com.company.domain.Shoe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoeDao implements BaseDao<Shoe> {

    private final String shoeFile = "src/main/resources/shoe.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Shoe> findAll() throws IOException {
        return readShoeFile();
    }

    public List<Shoe> readShoeFile() throws IOException {
        List<Shoe> shoes = new ArrayList<>();
        List<String> strings = fileReader.readFile(shoeFile);
        strings.forEach(s -> shoes.add(toShoe(s)));
        return shoes;
    }

    private Shoe toShoe(String line) {
        String[] strings = line.split(",");
        return Shoe.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .size(Double.valueOf(strings[2]))
                .owner(strings[3])
                .material(strings[4])
                .price(Double.valueOf(strings[5]))
                .quantity(Integer.valueOf(strings[6]))
                .width(Double.valueOf(strings[7]))
                .length(Double.valueOf(strings[8]))
                .type(strings[9])
                .build();
    }
}
