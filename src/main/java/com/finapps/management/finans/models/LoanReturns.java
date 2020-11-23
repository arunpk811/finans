package com.finapps.management.finans.models;

import com.finapps.management.finans.models.Borrower;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoanReturns {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private double amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(AccessLevel.NONE)
    private Borrower borrower;
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return id != null && id.equals(((LoanReturns) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
