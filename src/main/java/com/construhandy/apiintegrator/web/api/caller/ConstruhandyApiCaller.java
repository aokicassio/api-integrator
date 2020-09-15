package com.construhandy.apiintegrator.web.api.caller;

import com.construhandy.apiintegrator.model.Product;
import com.construhandy.apiintegrator.web.utils.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.construhandy.apiintegrator.business.SystemMessages.FAILED_UPDATE;
import static com.construhandy.apiintegrator.business.SystemMessages.UPDATED_PRODUCT;

@Component
@Validated
public class ConstruhandyApiCaller {
    private static final Logger LOGGER = Logger.getLogger(ConstruhandyApiCaller.class.getName());


    @Autowired
    private WebClient webClient;

    public void updateProduct(@Valid Product product){
        String uri = ApiUtils.getUpdateProductUri(product.getCustomId());
        try {
            webClient.put()
                    .uri(uri)
                    .body(Mono.just(product), Product.class)
                    .retrieve()
                    .bodyToMono(Product.class)
                    .block();
            String message =  String.format(UPDATED_PRODUCT, product.getTitle(), product.getCustomId());
            LOGGER.log(Level.INFO, message);
        } catch (WebClientResponseException e){
            LOGGER.log(Level.WARNING, String.format (FAILED_UPDATE, product.getTitle(), product.getCustomId())
                    .concat(String.format ("=> Status code: %s %s", e.getStatusCode().value(), e.getStatusText())));
        } catch (Exception e){
            LOGGER.log(Level.WARNING, String.format (FAILED_UPDATE, product.getTitle(), product.getCustomId()));
        }
    }
}
