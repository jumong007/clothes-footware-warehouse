package com.company.service;

import com.company.dao.TraditionalDao;
import com.company.domain.TraditionalWear;
import com.company.dtos.AppErrorDTO;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class TraditionalWearService implements BaseService<TraditionalWear> {

    private final TraditionalDao dao = new TraditionalDao();

    @Override
    public ResponseEntity<DataDTO<List<TraditionalWear>>> findAll(String sort) {
        try {
            List<TraditionalWear> traditionalWears = dao.findAll();
            if (traditionalWears.isEmpty()) {
                throw new GenericNotFoundException("TraditionalWears not found!");
            }
            switch (sort) {
                case "1" -> traditionalWears.sort(Comparator.comparing(TraditionalWear::getId));
                case "2" -> traditionalWears.sort(Comparator.comparing(TraditionalWear::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(traditionalWears));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<TraditionalWear>> findByID(Long id) {
        try {
            TraditionalWear traditionalWear = dao.findAll().stream().filter(traditionalWear1 ->
                    traditionalWear1.getId().equals(id)).findFirst().orElse(null);
            if (traditionalWear == null) {
                throw new GenericNotFoundException("TraditionalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(traditionalWear), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<TraditionalWear>>> findByColor(String color) {
        try {
            List<TraditionalWear> traditionalWears = dao.findAll().stream().filter(traditionalWear ->
                    traditionalWear.getColor().equals(color)).toList();
            if (traditionalWears.isEmpty()) {
                throw new GenericNotFoundException("TraditionalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(traditionalWears), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<TraditionalWear>>> findBySize(Double size) {
        try {
            List<TraditionalWear> traditionalWears = dao.findAll().stream().filter(traditionalWear ->
                    traditionalWear.getSize().equals(size)).toList();
            if (traditionalWears.isEmpty()) {
                throw new GenericNotFoundException("TraditionalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(traditionalWears), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<TraditionalWear>>> findByOwner(String owner) {
        try {
            List<TraditionalWear> traditionalWears = dao.findAll().stream().filter(traditionalWear ->
                    traditionalWear.getOwner().equals(owner)).toList();
            if (traditionalWears.isEmpty()) {
                throw new GenericNotFoundException("TraditionalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(traditionalWears), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<TraditionalWear>>> filterByPrice(Double min, Double max) {
        try {
            List<TraditionalWear> traditionalWears = dao.findAll().stream().filter(traditionalWear ->
                    traditionalWear.getPrice() >= min && traditionalWear.getPrice() <= max).toList();
            if (traditionalWears.isEmpty()) {
                throw new GenericNotFoundException("TraditionalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(traditionalWears), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<TraditionalWear>>> findByCountry(String country) {
        try {
            List<TraditionalWear> traditionalWears = dao.findAll().stream().filter(traditionalWear ->
                    traditionalWear.getCountry().equals(country)).toList();
            if (traditionalWears.isEmpty()) {
                throw new GenericNotFoundException("TraditionalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(traditionalWears), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
