package org.example.demo666.controller;

import org.example.demo666.model.Payment;
import org.example.demo666.proxy.PaymentsProxyRestTemplate;
import org.example.demo666.proxy.PaymentsProxyWebClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class PaymentsController {
    private final PaymentsProxyRestTemplate paymentsProxyRestTemplate;
    private final PaymentsProxyWebClient paymentsProxyWebClient;

    public PaymentsController(PaymentsProxyRestTemplate paymentsProxyRestTemplate, PaymentsProxyWebClient paymentsProxyWebClient) {
        this.paymentsProxyRestTemplate = paymentsProxyRestTemplate;
        this.paymentsProxyWebClient = paymentsProxyWebClient;
    }

    @PostMapping("/payments-rest-template")
    public Payment createPayment(
            @RequestBody Payment payment) {
        return paymentsProxyRestTemplate.createPayment(payment);
    }

    @PostMapping("/payments-web-client")
    public Mono<Payment> createPayment2(
            @RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return paymentsProxyWebClient.createPayment(requestId, payment);
    }


}
