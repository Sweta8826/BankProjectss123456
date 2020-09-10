package dao;

import java.sql.*;
import java.util.*;
import domain.Account;

public class AccountDao {

    private Connection conn_inst = new Connection();

    public Account create(Account acct)
    {
        if(!ifAccountExist(acct.getAccountNumber())) {
            java.sql.Connection conn = conn_inst.getConnection();
            try {
                Statement stmt = conn.createStatement();
                String query = "INSERT INTO ACCOUNT VALUES ('" + acct.getAccountNumber() + "','" + acct.getName() + "'," + acct.getBalance() + ",'" + acct.getAccountType() + "','" + acct.getAccountOwners().toString() + "', CURRENT_DATE , TRUE);";
                stmt.execute(query);
            } catch (SQLException sql) {
                sql.printStackTrace();
            } finally {
                conn_inst.closeConnection(conn);
            }
        }
        else
            acct = null;
        return acct;
    }

    public Set<Account> readAllCustomers()
    {
        ResultSet result;
        java.sql.Connection conn = conn_inst.getConnection();
        Set<Account> customer = new HashSet<>();
        try {
            Statement stmt = conn.createStatement();
            String query = "select * from ACCOUNT;";
            result = stmt.executeQuery(query);
            while(result.next()){
                Account temp = new Account();
                temp.setAccountNumber(result.getString(1));
                temp.setName(result.getString(2));
                temp.setBalance(result.getDouble(3));
                temp.setAccountType(result.getString(4));
                String[] owners = result.getString(5).split(",");
                temp.setAccountOwners(new HashSet<>(Arrays.asList(owners)));
                temp.setJoiningDate(result.getDate(6));
                temp.setActive(result.getBoolean(7));
                customer.add(temp);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }
        finally {
            conn_inst.closeConnection(conn);
        }
        return customer;
    }

    public Set<Account> readCustomerByJointAccount()
    {
        return null;
    }

    public double getBalance(String acctNumber)
    {
        double balance = -1;
        java.sql.Connection conn = conn_inst.getConnection();
        String query = "select BALANCE from ACCOUNT where ACCNO = '"+acctNumber+"';";
        try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            resultSet.next();
            balance = resultSet.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            conn_inst.closeConnection(conn);
//        }
        return balance;
    }

    public int getSize()
    {
        int size = 0;
        java.sql.Connection conn = conn_inst.getConnection();
        String query = "select count(*) from ACCOUNT";
        try{
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(query);
            if(set.next())
                size = set.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conn_inst.closeConnection(conn);
        }
        return size;
    }

    public boolean ifAccountExist(String account_number)
    {
        java.sql.Connection conn = conn_inst.getConnection();
        Statement stmt ;
        ResultSet resultSet;
        String query = "select ACTIVE from ACCOUNT where ACCNO = '"+account_number+"';";
        boolean available = false;
        try {
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
            if(resultSet.next())
                available = true;
        }catch (SQLException sql){ sql.printStackTrace(); }
        finally {
            conn_inst.closeConnection(conn);
        }
        return  available;
    }

    public int updateAccountBalance(String account_number, double new_balance)
    {
        java.sql.Connection conn = conn_inst.getConnection();
        String query = "update ACCOUNT set BALANCE = "+new_balance+" where ACCNO = '"+account_number+"';";
        int code = 0;
        if(ifAccountExist(account_number)){
            try{
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            finally {
//                conn_inst.closeConnection(conn);
//            }
        }
        else
            code = 4;
        return code;
    }

}
