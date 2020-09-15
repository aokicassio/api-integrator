package com.construhandy.apiintegrator.web.scheduler;

import com.construhandy.apiintegrator.model.Product;
import com.construhandy.apiintegrator.web.service.ExternalApiService;
import com.construhandy.apiintegrator.web.service.InternalApiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class Scheduler {

    @Autowired
    protected InternalApiService internalApiService;

    protected abstract void scheduleProductUpdate();

    protected List<Product> fetchProducts(ExternalApiService service){
        return service.fetchProducts();
    }

    protected void runProductUpdate(List<Product> products) {
        internalApiService.callProductUpdateApi(products);
    }
}
