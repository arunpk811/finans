package com.finapps.management.finans.models.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDetailsRequest {
    private Long id;
    private Long accountNumber;
    private String bank;
    private double balance;
    private String type;
    private Boolean isActive;
}
