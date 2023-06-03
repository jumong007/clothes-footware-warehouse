package com.company.dao;

import com.company.config.CustomFileReader;
import com.company.domain.TraditionalWear;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TraditionalDao implements BaseDao<TraditionalWear> {

    private final String keyboardFile = "src/main/resources/traditionalwear.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<TraditionalWear> findAll() throws IOException {
        return readTraditionalWearFile();
    }

    public List<TraditionalWear> readTraditionalWearFile() throws IOException {
        List<TraditionalWear> traditionWears = new ArrayList<>();
        List<String> strings = fileReader.readFile(keyboardFile);
        strings.forEach(s -> traditionWears.add(toTraditionalWear(s)));
        return traditionWears;
    }

    private TraditionalWear toTraditionalWear(String line) {
        String[] strings = line.split(",");
        return TraditionalWear.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .size(Double.valueOf(strings[2]))
                .owner(strings[3])
                .material(strings[4])
                .price(Double.valueOf(strings[5]))
                .quantity(Integer.valueOf(strings[6]))
                .country(strings[7])
                .length(Double.valueOf(strings[8]))
                .build();
    }
}
