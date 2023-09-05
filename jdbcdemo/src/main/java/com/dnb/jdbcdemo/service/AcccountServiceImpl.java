package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.repo.AccountRepositoryImpl;

public class AcccountServiceImpl implements AccountService {
	private static AccountService accountservice;
	private AcccountServiceImpl(){
		
	}
	@Override
	public Account createAccount(Account account) {
		// return account;

		// TODO Auto-generated method stub
		return AccountRepositoryImpl.getInstance().createAccount(account);
	}
	@Override
	public Optional<Account> getAccountById(String accountId) {
		
		// TODO Auto-generated method stub
		
		return AccountRepositoryImpl.getInstance().getAccountById(accountId);
	}

	

	public static AccountService getInstance() {
		
		synchronized (AcccountServiceImpl.class) {
			if (accountservice == null) {
				accountservice = new AcccountServiceImpl();
			}

		
		}
		return accountservice;

	}
	@Override
	public Account deleteaccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Account> getAllAcccounts() {
		// TODO Auto-generated method stub
		return AccountRepositoryImpl.getInstance().getAllAcccounts();
	}

	

	

}
