package com.company.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormalWear extends BaseDomain {
    private String company;
    private String job;

    @Builder(builderMethodName = "childBuilder")
    public FormalWear(Long id, String color, Double size, String owner,
                      String material, Double price, Integer quantity, String company, String job) {
        super(id, color, size, owner, material, price, quantity);
        this.company = company;
        this.job = job;
    }
}
