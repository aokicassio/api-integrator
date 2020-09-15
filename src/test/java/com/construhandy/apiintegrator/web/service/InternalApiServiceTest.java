package com.construhandy.apiintegrator.web.service;

import com.construhandy.apiintegrator.model.Product;
import com.construhandy.apiintegrator.web.MockUtils;
import com.construhandy.apiintegrator.web.api.caller.ConstruhandyApiCaller;
import com.construhandy.apiintegrator.web.service.impl.InternalApiServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class InternalApiServiceTest {

    @Mock
    private ConstruhandyApiCaller construhandyApiCaller;

    @InjectMocks
    private InternalApiService internalApiService = new InternalApiServiceImpl();

    @Test
    public void callProductUpdateApi(){
        List<Product> products = new ArrayList<>();
        products.add(MockUtils.getMockProduct());
        products.add(MockUtils.getMockProduct());

        doNothing().when(construhandyApiCaller).updateProduct(any());

        internalApiService.callProductUpdateApi(products);

        verify(construhandyApiCaller, times(products.size())).updateProduct(any());
    }

}
