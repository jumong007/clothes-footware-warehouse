package com.company.controller;

import com.company.domain.Shoe;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.ShoeService;
import com.company.utils.BaseUtils;

import java.util.List;

public class ShoeController implements BaseController {

    private final ShoeService service = new ShoeService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Shoe>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Shoe>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Shoe>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findBySize() {
        BaseUtils.print("Enter size: ");
        ResponseEntity<DataDTO<List<Shoe>>> responseEntity = service.findBySize(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByOwner() {
        BaseUtils.print("Enter owner: ");
        ResponseEntity<DataDTO<List<Shoe>>> responseEntity = service.findByOwner(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Shoe>>> responseEntity = service.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByType() {
        BaseUtils.print("Enter type: ");
        ResponseEntity<DataDTO<List<Shoe>>> responseEntity = service.findByType(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
