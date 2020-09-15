package com.construhandy.apiintegrator.web.service.impl;

import com.construhandy.apiintegrator.model.Product;
import com.construhandy.apiintegrator.web.MockUtils;
import com.construhandy.apiintegrator.web.service.ExternalApiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CissPoderService implements ExternalApiService {

    @Override
    public List<Product> fetchProducts() {
        //TODO Implement external customer real API calls

        List<Product> products = new ArrayList<>();
        products.add(MockUtils.getMockProduct());

        return new ArrayList<>();
    }
}
