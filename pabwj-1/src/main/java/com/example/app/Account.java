package com.example.app;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class Account {
    @NonNull private Long id;
    @NonNull private String name;
    @NonNull private String address;
    @NonNull private BigDecimal balance;
}
