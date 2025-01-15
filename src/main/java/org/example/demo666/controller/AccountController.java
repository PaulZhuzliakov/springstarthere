package org.example.demo666.controller;

import org.example.demo666.dto.TransferRequest;
import org.example.demo666.model.Account;
import org.example.demo666.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest transferRequest) {
        transferService.transferMoney(
                transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(),
                transferRequest.getAmount()
        );
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return transferService.getAccounts();
    }
}
