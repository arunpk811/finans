package com.finapps.management.finans.services;

import java.util.List;

import com.finapps.management.finans.models.Borrower;
import com.finapps.management.finans.models.LoanReturns;
import com.finapps.management.finans.models.Users;
import com.finapps.management.finans.repositories.BorrowerRepository;
import com.finapps.management.finans.repositories.LoanReturnsRepository;
import com.finapps.management.finans.repositories.UserRepository;
import com.finapps.management.finans.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private LoanReturnsRepository loanReturnsRepo;

    public List<Borrower> getBorrowers(String username) {
        Users user = userRepo.findByUsername(username);
        return borrowerRepo.findAllByUser(user);
    }

    public Borrower create(Borrower borrower, String username) {
        Users user = userRepo.findByUsername(username);
        borrower.setUser(user);
        return borrowerRepo.saveAndFlush(borrower);
    }

    public Borrower update(Long id, Borrower borrower, String username) {
        Users user = userRepo.findByUsername(username);
        borrower.setUser(user);
        return borrowerRepo.saveAndFlush(borrower);
    }

    public String delete(Long id) {
        try {
            borrowerRepo.deleteById(id);
            return Constants.RECORD_DELETED_SUCCESSFULLY;
        } catch (Exception e) {
            return Constants.CRUD_ERROR;
        }
    }

    public Double getTotalAmount(String username) {
        Users user = userRepo.findByUsername(username);
        return borrowerRepo.findAllByUser(user).stream().mapToDouble(t->t.getAmount()).sum();
    }

    public List<LoanReturns> getReturnDetails(Long id, String username){
        Users user = userRepo.findByUsername(username);
        return loanReturnsRepo.findAllByBorrower(borrowerRepo.findById(id).get());
    }

    public LoanReturns addAReturn(Long borrowerId, LoanReturns loanReturns, String username){
        Users user = userRepo.findByUsername(username);
        loanReturns.setBorrower(borrowerRepo.getOne(borrowerId));
        return loanReturnsRepo.save(loanReturns);
    }

    public String removeAreturn(Long loanReturnId){
        try {
            loanReturnsRepo.deleteById(loanReturnId);
            return Constants.RECORD_DELETED_SUCCESSFULLY;
        } catch (Exception e) {
            return Constants.CRUD_ERROR;
        }
    }
}