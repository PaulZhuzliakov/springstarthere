package org.example.demo666.service;

import org.example.demo666.model.Account;
import org.example.demo666.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public void transferMoney(long idSender,
                              long idReceiver,
                              BigDecimal amount) {
        Account sender = accountRepository.getAccountById(idSender);
        Account receiver = accountRepository.getAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

        throw new RuntimeException("Oh no! Something went wrong!");
    }


    public List<Account> getAccounts() {
        return accountRepository.getAllAccounts();
    }
}
