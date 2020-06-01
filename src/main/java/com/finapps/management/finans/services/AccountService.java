package com.finapps.management.finans.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finapps.management.finans.models.Account;
import com.finapps.management.finans.repositories.AccountRepository;
import com.finapps.management.finans.utils.Constants;


@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepo;
	
	public List<Account> getAccounts(){
		return accountRepo.findAll();
	}
	
	public Account create(Account account) {
		return accountRepo.save(account);
	}
	
	public Account update(Account account) {
		return accountRepo.save(account);
	}
	
	public String delete(Long id) {
		try {
			accountRepo.deleteById(id);
			return Constants.RECORD_DELETED_SUCCESSFULLY;
		} catch (Exception e) {
			return Constants.CRUD_ERROR;
		}
	}
}
