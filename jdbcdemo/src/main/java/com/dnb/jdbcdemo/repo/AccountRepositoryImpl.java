package com.dnb.jdbcdemo.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.utils.DBUtils;

public class AccountRepositoryImpl implements AccountRepository {
	private AccountRepositoryImpl() {

	}

	private static AccountRepository accountRepository;

	public static AccountRepository getInstance() {
		synchronized (AccountRepositoryImpl.class) {
			if (accountRepository == null) {
				accountRepository = new AccountRepositoryImpl();
			}
		}
		return accountRepository;

	}

	public Account createAccount(Account account) {
		Optional<Connection> connection = DBUtils.getConnection();
		String createAccountStatement = "insert into account"
				+ "(accountId,accountHolderName,accountType,balance,contactNumber,address,accountCreateDate,dob,AccountStatus)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatment = null;
		try {
			if (connection.isPresent()) {
				preparedStatment = connection.get().prepareStatement(createAccountStatement);
				preparedStatment.setString(1, account.getAccountId());
				preparedStatment.setString(2, account.getAccountHolderName());
				preparedStatment.setString(3, account.getAccountType());
				preparedStatment.setFloat(4, account.getBalance());
				preparedStatment.setString(5, account.getContactNumber());
				preparedStatment.setString(6, account.getAddress());
				preparedStatment.setDate(7, Date.valueOf(account.getAccountCreateDate()));
				preparedStatment.setDate(8, Date.valueOf(account.getDob()));
				preparedStatment.setBoolean(9, account.getAccountStatus());
				int result = preparedStatment.executeUpdate();
				if (result > 0) {
					return account;

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (connection.isPresent()) {
				DBUtils.closeConnection(connection.get());
			}
		}

		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatment = null;
		ResultSet rs = null;
		String query = "Select * from account where accountId=?";

		if (connection.isPresent()) {
			try {
				preparedStatment = connection.get().prepareStatement(query);
				preparedStatment.setString(1, accountId);
				rs = preparedStatment.executeQuery();
				if (rs.next()) {
					Account account = new Account();
					account.setAccountId(rs.getString("accountId"));
					account.setAccountHolderName(rs.getString("accountHolderName"));
					account.setAccountType(rs.getString("accountType"));
					account.setBalance(rs.getFloat("balance"));
					account.setContactNumber(rs.getString("contactNumber"));
					account.setAddress(rs.getString("address"));
					account.setDob(rs.getDate("dob").toLocalDate());
					account.setAccountCreateDate(rs.getDate("accountCreatedate").toLocalDate());
					account.setAccountStatus(rs.getBoolean("AccountStatus"));
					return Optional.of(account);

				}

			}

			catch (SQLException e) {
				e.printStackTrace();

			} finally {
				if (connection.isPresent()) {
					DBUtils.closeConnection(connection.get());
				}
			}

		} 
		else {
			return null;
		}
		return Optional.empty();

	}

	@Override
	public Account deleteaccount(Account account) {
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatment = null;
		if(connection.isPresent()) {
			
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAcccounts() {
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatment = null;
		ResultSet rs = null;
		String query = "Select * from account";
		List<Account> accounts = new ArrayList<>();

		if (connection.isPresent()) {
			try {
				preparedStatment = connection.get().prepareStatement(query);
				//preparedStatment.setString(1, accountId);
				rs = preparedStatment.executeQuery();
				while(rs.next()) {
					Account account = new Account();
					account.setAccountId(rs.getString("accountId"));
					account.setAccountHolderName(rs.getString("accountHolderName"));
					account.setAccountType(rs.getString("accountType"));
					account.setBalance(rs.getFloat("balance"));
					account.setContactNumber(rs.getString("contactNumber"));
					account.setAddress(rs.getString("address"));
					account.setDob(rs.getDate("dob").toLocalDate());
					account.setAccountCreateDate(rs.getDate("accountCreatedate").toLocalDate());
					account.setAccountStatus(rs.getBoolean("AccountStatus"));
					accounts.add(account);
					

				}
				return accounts;

			}

			catch (SQLException e) {
				e.printStackTrace();

			} finally {
				if (connection.isPresent()) {
					DBUtils.closeConnection(connection.get());
				}
			}

		} 
		else {
			return null;
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}
}
