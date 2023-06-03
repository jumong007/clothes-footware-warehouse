package com.company.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shoe extends BaseDomain {
    private Double width;
    private Double length;
    private String type;

    @Builder(builderMethodName = "childBuilder")
    public Shoe(Long id, String color, Double size, String owner,
                String material, Double price, Integer quantity, Double width, Double length, String type) {
        super(id, color, size, owner, material, price, quantity);
        this.width = width;
        this.length = length;
        this.type = type;
    }
}
