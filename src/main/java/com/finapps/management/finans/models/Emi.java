package com.finapps.management.finans.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
public class Emi {
    @Id
    @GeneratedValue
    private Long id;
    private Double amount;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    private Loan loan;
}
