package org.example.demo666.service;

import org.example.demo666.exception.NotEnoughMoneyException;
import org.example.demo666.model.PaymentDetails;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        boolean dice = new Random().nextBoolean();
        if (dice) {
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setAmount(new Random().nextInt(100));
            return paymentDetails;
        }
        else {
            throw new NotEnoughMoneyException();
        }
    }

}
