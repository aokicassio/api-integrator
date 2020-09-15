package com.construhandy.apiintegrator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableScheduling
public class ApiIntegratorApplication {

	@Value("${api.construhandy.url}")
	private String contruhandyUrl;

    @Value("${api.contruhandy.bearertoken}")
    private String bearerToken;

	@Bean
	public WebClient webClient(){
		return WebClient
				.builder()
				.baseUrl(contruhandyUrl)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(authHeader(bearerToken))
				.build();
	}

    private ExchangeFilterFunction authHeader(String token) {
        return (request, next) -> next.exchange(ClientRequest.from(request).headers((headers) -> {
            headers.setBearerAuth(token);
        }).build());
    }

	public static void main(String[] args) {
		SpringApplication.run(ApiIntegratorApplication.class, args);
	}

}
