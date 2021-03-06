package com.finapps.management.finans.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

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
    private LoanRepository loanRepo;
    @Autowired
    private UserRepository userRepo;

    public List<Loan> getLoans(String username) {
        Users user = userRepo.findByUsername(username);
        return loanRepo.findAllByUser(user);
    }

    public Loan create(Loan loan, String username) {
        Users user = userRepo.findByUsername(username);
        loan.setUser(user);
        return loanRepo.save(loan);
    }

    public Loan update(Long id, Loan loan, String username) {
        Users user = userRepo.findByUsername(username);
        loan.setUser(user);
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

    public Double getTotalDebt(String username){
        Users user = userRepo.findByUsername(username);
        return loanRepo.findAllByUser(user).stream().mapToDouble(loan -> loan.getAmount()).sum();
    }
}