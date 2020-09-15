package com.construhandy.apiintegrator.web.scheduler;

import com.construhandy.apiintegrator.model.Product;
import com.construhandy.apiintegrator.web.service.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class DummyScheduler extends Scheduler {

    private static final Logger LOGGER = Logger.getLogger(DummyScheduler.class.getName());

    @Autowired
    private ExternalApiService dummyService;

    @Override
    @Scheduled(fixedRateString = "${scheduler.rate}", initialDelay = 2000)
    public void scheduleProductUpdate() {
        LOGGER.info("Running dummy scheduled event");

        List<Product> products = fetchProducts(dummyService);
        runProductUpdate(products);

        LOGGER.info("Finished dummy scheduled event");
    }
}
