package com.company.controller;

import com.company.domain.FormalWear;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.FormalWearService;
import com.company.utils.BaseUtils;

import java.util.List;

public class FormalWearController implements BaseController {

    private final FormalWearService service = new FormalWearService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<FormalWear>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<FormalWear>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<FormalWear>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findBySize() {
        BaseUtils.print("Enter size: ");
        ResponseEntity<DataDTO<List<FormalWear>>> responseEntity = service.findBySize(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByOwner() {
        BaseUtils.print("Enter owner: ");
        ResponseEntity<DataDTO<List<FormalWear>>> responseEntity = service.findByOwner(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<FormalWear>>> responseEntity = service.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByJob() {
        BaseUtils.print("Enter job: ");
        ResponseEntity<DataDTO<List<FormalWear>>> responseEntity = service.findByJob(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
