package com.bo.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Setter(AccessLevel.NONE)
public class Transaction {
    private LocalDateTime operationTime;
    private Operation operation;
    private BigDecimal amount;
    private BigDecimal accountBalanceBefore;
    private BigDecimal accountBalanceAfter;
}
