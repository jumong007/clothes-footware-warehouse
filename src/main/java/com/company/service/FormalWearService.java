package com.company.service;

import com.company.dao.FormalWearDao;
import com.company.domain.FormalWear;
import com.company.dtos.AppErrorDTO;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class FormalWearService implements BaseService<FormalWear> {

    private final FormalWearDao dao = new FormalWearDao();

    @Override
    public ResponseEntity<DataDTO<List<FormalWear>>> findAll(String sort) {
        try {
            List<FormalWear> formalWears = dao.findAll();
            if (formalWears.isEmpty()) {
                throw new GenericNotFoundException("FormalWears not found!");
            }
            switch (sort) {
                case "1" -> formalWears.sort(Comparator.comparing(FormalWear::getId));
                case "2" -> formalWears.sort(Comparator.comparing(FormalWear::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(formalWears));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<FormalWear>> findByID(Long id) {
        try {
            FormalWear formalWear = dao.findAll().stream().filter(formalWear1 ->
                    formalWear1.getId().equals(id)).findFirst().orElse(null);
            if (formalWear == null) {
                throw new GenericNotFoundException("FormalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(formalWear), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<FormalWear>>> findByColor(String color) {
        try {
            List<FormalWear> formalWears = dao.findAll().stream().filter(formalWear ->
                    formalWear.getColor().equals(color)).toList();
            if (formalWears.isEmpty()) {
                throw new GenericNotFoundException("FormalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(formalWears), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<FormalWear>>> findBySize(Double size) {
        try {
            List<FormalWear> formalWears = dao.findAll().stream().filter(formalWear ->
                    formalWear.getSize().equals(size)).toList();
            if (formalWears.isEmpty()) {
                throw new GenericNotFoundException("FormalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(formalWears), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<FormalWear>>> findByOwner(String owner) {
        try {
            List<FormalWear> formalWears = dao.findAll().stream().filter(formalWear ->
                    formalWear.getOwner().equals(owner)).toList();
            if (formalWears.isEmpty()) {
                throw new GenericNotFoundException("FormalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(formalWears), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<FormalWear>>> filterByPrice(Double min, Double max) {
        try {
            List<FormalWear> formalWears = dao.findAll().stream().filter(formalWear ->
                    formalWear.getPrice() >= min && formalWear.getPrice() <= max).toList();
            if (formalWears.isEmpty()) {
                throw new GenericNotFoundException("FormalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(formalWears), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<FormalWear>>> findByJob(String job) {
        try {
            List<FormalWear> formalWears = dao.findAll().stream().filter(formalWear ->
                    formalWear.getJob().equals(job)).toList();
            if (formalWears.isEmpty()) {
                throw new GenericNotFoundException("FormalWear not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(formalWears), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
