package com.construhandy.apiintegrator.web.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


public class ApiUtilsTest {

    @Test
    public void testGenerateBatchId(){

        LocalDate localDate = LocalDate.now();
        String year = String.valueOf(localDate.getYear());
        String month = String.format("%02d", localDate.getMonthValue());
        String day = String.valueOf(localDate.getDayOfMonth());

        String batchId = ApiUtils.generateBatchId();

        assertThat(batchId).startsWith(year + month + day + "_");
        assertThat(batchId).hasSize(15);
    }
}
