package com.company.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TraditionalWear extends BaseDomain {
    private String country;
    private Double length;

    @Builder(builderMethodName = "childBuilder")
    public TraditionalWear(Long id, String color, Double size, String owner,
                           String material, Double price, Integer quantity, String country, Double length) {
        super(id, color, size, owner, material, price, quantity);
        this.country = country;
        this.length = length;
    }
}
