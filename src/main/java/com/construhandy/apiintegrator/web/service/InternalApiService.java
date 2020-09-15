package com.construhandy.apiintegrator.web.service;

import com.construhandy.apiintegrator.model.Product;

import java.util.List;

public interface InternalApiService {

    void callProductUpdateApi(List<Product> products);

}
