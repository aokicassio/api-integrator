package com.construhandy.apiintegrator.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class Product {

    @NotNull
    @NotEmpty
    private String customId;

    @PositiveOrZero
    private double price;

    @PositiveOrZero
    private Integer currentStock;

    @NotNull
    @NotEmpty
    private String title;

    private String description;

    private String specifications;

}
