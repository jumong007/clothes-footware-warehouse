package com.company.controller;

import com.company.domain.TraditionalWear;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.TraditionalWearService;
import com.company.utils.BaseUtils;

import java.util.List;

public class TraditionalWearController implements BaseController {

    private final TraditionalWearService service = new TraditionalWearService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<TraditionalWear>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<TraditionalWear>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<TraditionalWear>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findBySize() {
        BaseUtils.print("Enter size: ");
        ResponseEntity<DataDTO<List<TraditionalWear>>> responseEntity = service.findBySize(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByOwner() {
        BaseUtils.print("Enter owner: ");
        ResponseEntity<DataDTO<List<TraditionalWear>>> responseEntity = service.findByOwner(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<TraditionalWear>>> responseEntity = service.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByCountry() {
        BaseUtils.print("Enter country: ");
        ResponseEntity<DataDTO<List<TraditionalWear>>> responseEntity = service.findByCountry(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
