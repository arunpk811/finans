package com.finapps.management.finans.services;

import java.util.*;

import com.finapps.management.finans.models.AccountType;
import com.finapps.management.finans.models.Banks;
import com.finapps.management.finans.models.Users;
import com.finapps.management.finans.models.requests.AccountDetailsRequest;
import com.finapps.management.finans.models.response.BankDetailsResponse;
import com.finapps.management.finans.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finapps.management.finans.models.Account;
import com.finapps.management.finans.repositories.AccountRepository;
import com.finapps.management.finans.utils.Constants;


@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private UserRepository userRepo;
	
	public List<Account> getAccounts(String username){
		Users user = userRepo.findByUsername(username);
		return accountRepo.findAllByUser(user);
	}

	public List<Account> getActiveAccounts(String username){
		Users user = userRepo.findByUsername(username);
		return accountRepo.findAllByUserAndIsActive(user, 1);
	}
	
	public Account create(AccountDetailsRequest request, String username) {
		Users user = userRepo.findByUsername(username);
		Account account = Account.builder()
				.accountNumber(request.getAccountNumber())
				.bank(Banks.valueOf(request.getBank()))
				.balance(request.getBalance())
				.type(AccountType.valueOf(request.getType()))
				.isActive(request.getIsActive()?1:0)
				.user(user)
				.build();
		return accountRepo.saveAndFlush(account);
	}
	
	public Account update(Long id, AccountDetailsRequest request, String username) {
		Users user = userRepo.findByUsername(username);
		Account account = Account.builder()
				.id(request.getId())
				.accountNumber(request.getAccountNumber())
				.bank(Banks.valueOf(request.getBank()))
				.balance(request.getBalance())
				.type(AccountType.valueOf(request.getType()))
				.isActive(request.getIsActive()?1:0)
				.user(user)
				.build();
		return accountRepo.saveAndFlush(account);
	}
	
	public String delete(Long id, String username) {
		try {
			Users user = userRepo.findByUsername(username);
			accountRepo.deleteById(id);
			return Constants.RECORD_DELETED_SUCCESSFULLY;
		} catch (Exception e) {
			return Constants.CRUD_ERROR;
		}
	}

	public List<BankDetailsResponse> getBanks(String username) throws Exception {
		Users user = userRepo.findByUsername(username);
		if(user==null) throw new Exception("User not found");
		List<BankDetailsResponse> banksList = new ArrayList<>();
		for(Banks bank: Banks.values()){
			banksList.add(new BankDetailsResponse(bank.name(), bank.getBankName()));
		}
		return banksList;
	}

	public List<AccountType> getAccountTypes(String username) throws Exception {
		Users user = userRepo.findByUsername(username);
		if(user==null) throw new Exception("User not found");
		return Arrays.asList(AccountType.values());
	}
}
