package com.construhandy.apiintegrator.web;

import com.construhandy.apiintegrator.model.Product;

import java.util.Random;

public class MockUtils {

    private static Random rand = new Random();

    public static Product getMockProduct(){
        Product product = new Product();

        // Non mandatory
        product.setCustomId("Reg01");
        product.setDescription("Registro de gaveta");
        product.setSpecifications("xyz_" + rand.nextInt(9999));

        // Mandatory
        product.setTitle("Registro");
        product.setPrice(44.55);

        // Non mandatory but erases field if not sent
        product.setCurrentStock(10);

        return product;
    }
}
