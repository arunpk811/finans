package com.finapps.management.finans.services;

import java.util.List;

import com.finapps.management.finans.models.Borrower;
import com.finapps.management.finans.models.Users;
import com.finapps.management.finans.repositories.BorrowerRepository;
import com.finapps.management.finans.repositories.UserRepository;
import com.finapps.management.finans.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {
    @Autowired
    BorrowerRepository borrowerRepo;
    @Autowired
    UserRepository userRepo;

    public List<Borrower> getBorrowers(String username) {
        Users user = userRepo.findByUsername(username);
        return borrowerRepo.findAllByUser(user);
    }

    public Borrower create(Borrower borrower, String username) {
        Users user = userRepo.findByUsername(username);
        borrower.setUser(user);
        return borrowerRepo.save(borrower);
    }

    public Borrower update(Borrower borrower, String username) {
        Users user = userRepo.findByUsername(username);
        borrower.setUser(user);
        return borrowerRepo.save(borrower);
    }

    public String delete(Long id) {
        try {
            borrowerRepo.deleteById(id);
            return Constants.RECORD_DELETED_SUCCESSFULLY;
        } catch (Exception e) {
            return Constants.CRUD_ERROR;
        }
    }
}