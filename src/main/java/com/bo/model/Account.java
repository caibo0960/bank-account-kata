package com.bo.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Account {
    private String client;
    private BigDecimal balance;
    @Builder.Default
    private List<Transaction> transactions = new ArrayList<>();
}
