package com.company.service;

import com.company.dao.ShoeDao;
import com.company.domain.Shoe;
import com.company.dtos.AppErrorDTO;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class ShoeService implements BaseService<Shoe> {

    private final ShoeDao dao = new ShoeDao();

    @Override
    public ResponseEntity<DataDTO<List<Shoe>>> findAll(String sort) {
        try {
            List<Shoe> shoes = dao.findAll();
            if (shoes.isEmpty()) {
                throw new GenericNotFoundException("Shoes not found!");
            }
            switch (sort) {
                case "1" -> shoes.sort(Comparator.comparing(Shoe::getId));
                case "2" -> shoes.sort(Comparator.comparing(Shoe::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(shoes));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Shoe>> findByID(Long id) {
        try {
            Shoe shoe = dao.findAll().stream().filter(shoe1 ->
                    shoe1.getId().equals(id)).findFirst().orElse(null);
            if (shoe == null) {
                throw new GenericNotFoundException("Shoe not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(shoe), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Shoe>>> findByColor(String color) {
        try {
            List<Shoe> shoes = dao.findAll().stream().filter(shoe ->
                    shoe.getColor().equals(color)).toList();
            if (shoes.isEmpty()) {
                throw new GenericNotFoundException("Shoe not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(shoes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Shoe>>> findBySize(Double size) {
        try {
            List<Shoe> shoes = dao.findAll().stream().filter(shoe ->
                    shoe.getSize().equals(size)).toList();
            if (shoes.isEmpty()) {
                throw new GenericNotFoundException("Shoe not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(shoes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Shoe>>> findByOwner(String owner) {
        try {
            List<Shoe> shoes = dao.findAll().stream().filter(shoe ->
                    shoe.getOwner().equals(owner)).toList();
            if (shoes.isEmpty()) {
                throw new GenericNotFoundException("Shoe not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(shoes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Shoe>>> filterByPrice(Double min, Double max) {
        try {
            List<Shoe> shoes = dao.findAll().stream().filter(shoe ->
                    shoe.getPrice() >= min && shoe.getPrice() <= max).toList();
            if (shoes.isEmpty()) {
                throw new GenericNotFoundException("Shoe not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(shoes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Shoe>>> findByType(String type) {
        try {
            List<Shoe> shoes = dao.findAll().stream().filter(shoe ->
                    shoe.getType().equals(type)).toList();
            if (shoes.isEmpty()) {
                throw new GenericNotFoundException("Shoe not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(shoes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
