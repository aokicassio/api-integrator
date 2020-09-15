package com.construhandy.apiintegrator.web.service.impl;

import com.construhandy.apiintegrator.model.Product;
import com.construhandy.apiintegrator.web.api.caller.ConstruhandyApiCaller;
import com.construhandy.apiintegrator.web.service.InternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.construhandy.apiintegrator.business.SystemMessages.FAILED_UPDATE;
import static com.construhandy.apiintegrator.business.SystemMessages.VALIDATION_ERROR;

@Service
public class InternalApiServiceImpl implements InternalApiService {

    private static final Logger LOGGER = Logger.getLogger(InternalApiServiceImpl.class.getName());

    @Autowired
    private ConstruhandyApiCaller construhandyApiCaller;

    @Override
    public void callProductUpdateApi(List<Product> products) {
        for (Product product : products) {
            try {
                construhandyApiCaller.updateProduct(product);
            } catch (ConstraintViolationException e) {
                LOGGER.log(Level.WARNING, String.format (FAILED_UPDATE, product.getTitle(), product.getCustomId())
                        .concat(String.format (VALIDATION_ERROR, e.getMessage())));
            }
        }
    }
}
