package org.example.demo666.proxy;

import org.example.demo666.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentsProxyRestTemplate {

    private final RestTemplate restTemplate;

    @Value("${name.service.url}")
    private String serviceUrl;

    public PaymentsProxyRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(Payment payment) {
        String uri = serviceUrl + "/payment-test";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", UUID.randomUUID().toString());
        HttpEntity<Payment> paymentHttpEntity = new HttpEntity<>(payment, httpHeaders);
        ResponseEntity<Payment> response = restTemplate.postForEntity(uri, paymentHttpEntity, Payment.class);
        return response.getBody();
    }
}
