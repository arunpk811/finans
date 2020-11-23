package com.finapps.management.finans.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
public class Borrower {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double amount;
    private Date date;
    @ManyToOne
    @Getter(AccessLevel.NONE)
    private Users user;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanReturns> listOfReturns = new ArrayList<>();

    public void setListOfReturns(List<LoanReturns> listOfReturns){
        listOfReturns.forEach(loanReturns -> loanReturns.setBorrower(this));
        this.listOfReturns = listOfReturns;
    }
}