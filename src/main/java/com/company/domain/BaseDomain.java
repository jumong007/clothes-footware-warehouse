package com.company.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDomain {
    protected Long id;
    protected String color;
    protected Double size;
    protected String owner;
    protected String material;
    protected Double price;
    protected Integer quantity;
}
