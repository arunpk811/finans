package com.finapps.management.finans.models;

public enum Banks {
    SCB("Standard Chartered Bank"),
    CUB("City Union Bank"),
    KOTAK("Kotak Mahindra Bank"),
    SIB("South Indian Bank"),
    ICICI("ICICI Bank"),
    HDFC("HDFC Bank");

    private String bankName;

    public String getBankName() {
        return bankName;
    }

    Banks(String fullName) {
        this.bankName = fullName;
    }

    public Banks getBanks(){
        return this;
    }
}
