package service;

import dao.AccountDao;
import domain.Account;
import java.text.SimpleDateFormat;
import java.util.*;

public class AccountService implements AccountInterface {

    private AccountDao acc = new AccountDao();

    @Override
    public Account createAccount(Account acct) {
        double minBalance = 500d;
        if(acct.getBalance() >= minBalance)
            acct = acc.create(acct);
        else
            acct = null;
        return acct;
    }

    @Override
    public Set<Account> findCustomersByType(String acctType) {
        return null;
    }

    @Override
    public String generateAccountNumber(String name){
        String number;
        int num  = acc.getSize();
        num++;
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMMYYYY");
        String date = sdf.format(new Date());
        number = name.substring(0,2)+date+num;
        number = number.toUpperCase();
        return number;
    }

    @Override
    public Set<Account> findJointAccountCustomers() {
        Set<Account> set_of_accounts;
        set_of_accounts = acc.readCustomerByJointAccount();
        return set_of_accounts;
    }

    @Override
    public double findAccountBalance(String acctNumber) {
        double balance;
        balance = acc.getBalance(acctNumber);
        return balance;
    }

    @Override
    public String processFundTransfer(String fromAccount, String toAccount, double amount) {
        String result ;
        int code;
        if (amount > 0)
            if(acc.ifAccountExist(fromAccount))
                if(acc.ifAccountExist(toAccount)){
                    double bal = acc.getBalance(fromAccount);
                    if(bal >= amount){
                        code = acc.updateAccountBalance(fromAccount, bal - amount);
                        if(code == 0)
                            code = acc.updateAccountBalance(toAccount, acc.getBalance(toAccount) + amount);
                    }
                    else
                        code = 3;
                }
                else
                    code = 2;
            else
                code = 1;
        else
             code = -1;

        result = result(code);
        return result;
    }

    @Override
    public Set<Account> findAllCustomers() {
        return acc.readAllCustomers();
    }

    private String result(int code)
    {
        String result ;
        if(code == -1)
            result = "Amount can't be 'Zero' or 'Negative'.";
        else if(code == 1)
            result = "Sender's Account not found";
        else if(code == 2)
            result = "Receiver's Account not found";
        else if(code == 3)
            result = "Insufficient amount";
        else if(code == 4)
            result = "Update failed";
        else
            result = "Transaction successful";
        return result;
    }

}