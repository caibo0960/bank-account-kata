package com.bo.service;

import com.bo.model.Account;
import com.bo.model.Operation;
import com.bo.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class BankService {
    public static Account createAccount(String name, BigDecimal balance) {
        return Account.builder()
                .client(name)
                .balance(balance)
                .build();
    }

    public static void deposit(Account account, BigDecimal amount) throws ImpossibleOperation {
        if (amount == null
                || !(amount.compareTo(BigDecimal.ZERO) > 0)) {
            throw new ImpossibleOperation();
        }

        BigDecimal balanceBeforeOperation = account.getBalance();
        account.setBalance(account.getBalance().add(amount));
        Transaction transaction = Transaction.builder()
                .operation(Operation.DEPOSIT)
                .amount(amount)
                .operationTime(LocalDateTime.now())
                .accountBalanceBefore(balanceBeforeOperation)
                .accountBalanceAfter(account.getBalance())
                .build();
        account.getTransactions().add(transaction);
    }

    public static void withdrawal(Account account, BigDecimal amount) throws ImpossibleOperation {
        if (amount == null
                || !(amount.compareTo(BigDecimal.ZERO) > 0)
                || amount.compareTo(account.getBalance()) > 0)
            throw new ImpossibleOperation();

        BigDecimal balanceBeforeOperation = account.getBalance();
        account.setBalance(account.getBalance().subtract(amount));
        Transaction transaction = Transaction.builder()
                .operation(Operation.WITHDRAWAL)
                .amount(amount)
                .operationTime(LocalDateTime.now())
                .accountBalanceBefore(balanceBeforeOperation)
                .accountBalanceAfter(account.getBalance())
                .build();
        account.getTransactions().add(transaction);
    }

    public static List<Transaction> getOperationHistory(Account account) {
        return Collections.unmodifiableList(account.getTransactions());
    }
}
