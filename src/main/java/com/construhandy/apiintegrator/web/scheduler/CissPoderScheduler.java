package com.construhandy.apiintegrator.web.scheduler;

import com.construhandy.apiintegrator.model.Product;
import com.construhandy.apiintegrator.web.service.ExternalApiService;
import com.construhandy.apiintegrator.web.utils.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CissPoderScheduler extends Scheduler {

    private static final Logger LOGGER = Logger.getLogger(CissPoderScheduler.class.getName());

    @Autowired
    private ExternalApiService cissPoderService;

    @Override
    @Scheduled(fixedRateString = "${scheduler.rate}", initialDelay = 2000)
    protected void scheduleProductUpdate() {
        String batchId = ApiUtils.generateBatchId();

        LOGGER.log(Level.INFO, "------------------------------------------------------------------------------");
        LOGGER.log(Level.INFO, String.format("%s: Starting scheduled Product Update", batchId));

        List<Product> products = fetchProducts(cissPoderService);
        runProductUpdate(products);

        LOGGER.log(Level.INFO, String.format("%s: Finished scheduled Product Update", batchId));
    }
}
