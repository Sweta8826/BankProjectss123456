package service;

import domain.Account;

import java.util.Set;

public interface AccountInterface {

    Account createAccount(Account acct);
    Set<Account> findCustomersByType(String acctType);
    double findAccountBalance(String acctNumber);
    String processFundTransfer(String fromAcct, String toAcct, double amount);
    Set<Account> findAllCustomers();
    public String generateAccountNumber(String name);
    public Set<Account> findJointAccountCustomers();
}