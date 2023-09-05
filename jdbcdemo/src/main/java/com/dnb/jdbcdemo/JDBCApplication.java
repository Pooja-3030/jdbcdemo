package com.dnb.jdbcdemo;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.service.AcccountServiceImpl;

public class JDBCApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello to Git");
		Account account = new Account();
        account.setAccountId("123456789");
        account.setAccountHolderName("pooja");
        account.setAccountType("Savings");
        account.setBalance(102);
        account.setContactNumber("94414");
        
        account.setAddress("Opposite dnb office ");
        account.setAccountCreateDate(LocalDate.now());
        account.setDob(LocalDate.of(2002, 05, 06));
        account.setAccountStatus(true);
        //System.out.println(AcccountServiceImpl.getInstance().createAccount(account));
        
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        while(true) {
        switch(option) {
        	case 1:
        		System.out.println(AcccountServiceImpl.getInstance().createAccount(account));
        	case 2:
        		String id = sc.next();
        		System.out.println(AcccountServiceImpl.getInstance().getAccountById(id));
        	case 3:
        		System.out.println(AcccountServiceImpl.getInstance().getAllAcccounts());
        		
        	case 4:
        		System.out.println("We are exiting from the connection");
        		System.exit(0);
        		
        }
        }

	}

}
