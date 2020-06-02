package com.finapps.management.finans.services;

import java.util.List;

import com.finapps.management.finans.models.Loan;
import com.finapps.management.finans.models.Users;
import com.finapps.management.finans.repositories.LoanRepository;
import com.finapps.management.finans.repositories.UserRepository;
import com.finapps.management.finans.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepo;
    @Autowired
    UserRepository userRepo;

    public List<Loan> getLoans(Long userId) {
        Users user = userRepo.findById(userId).get();
        return loanRepo.findAllByUser(user);
    }

    public Loan create(Loan loan) {
        return loanRepo.save(loan);
    }

    public Loan update(Loan loan) {
        return loanRepo.save(loan);
    }

    public String delete(Long id) {
        try {
            loanRepo.deleteById(id);
            return Constants.RECORD_DELETED_SUCCESSFULLY;
        } catch (Exception e) {
            return Constants.CRUD_ERROR;
        }
    }
}