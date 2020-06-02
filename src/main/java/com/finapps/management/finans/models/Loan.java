package com.finapps.management.finans.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Loan {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String description;
    private Double amount;
    @ManyToOne
    @Getter(AccessLevel.NONE)
    private Users user;
}