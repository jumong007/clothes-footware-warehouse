package com.company.dao;

import com.company.config.CustomFileReader;
import com.company.domain.FormalWear;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 01/06/23 23:21
 * clothes-footware-warehouse
 */

public class FormalWearDao implements BaseDao<FormalWear> {

    private final String formalWearFile = "src/main/resources/formalwear.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<FormalWear> findAll() throws IOException {
        return readFormalWearFile();
    }

    public List<FormalWear> readFormalWearFile() throws IOException {
        List<FormalWear> formalWears = new ArrayList<>();
        List<String> strings = fileReader.readFile(formalWearFile);
        strings.forEach(s -> formalWears.add(toFormalWear(s)));
        return formalWears;
    }

    private FormalWear toFormalWear(String line) {
        String[] strings = line.split(",");
        return FormalWear.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .size(Double.valueOf(strings[2]))
                .owner(strings[3])
                .material(strings[4])
                .price(Double.valueOf(strings[5]))
                .quantity(Integer.valueOf(strings[6]))
                .company(strings[7])
                .job(strings[8])
                .build();
    }
}
