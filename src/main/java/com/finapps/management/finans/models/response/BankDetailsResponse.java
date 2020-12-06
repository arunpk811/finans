package com.finapps.management.finans.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BankDetailsResponse {
    private String bankCode;
    private String bankName;
}
