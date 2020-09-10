package webapp;

import domain.Account;
import service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "Create")
public class Create extends HttpServlet {

    AccountService service = new AccountService();

    public Account addCustomer(String name, String accountType, double balance, Set<String> owners){
        Date date = new Date();
        String accountNumber;
        boolean isActive = true;
        accountNumber = service.generateAccountNumber(name);
        Account account = new Account(name, accountType, balance, accountNumber, owners, date, isActive);
        account = service.createAccount(account);
        return account;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("customerName");
        String accountType = request.getParameter("accountType");
        double balance = Double.parseDouble(request.getParameter("initialBalance"));
        String[] owners = request.getParameter("owners").split(",");
        Set<String> accountOwners = new HashSet<String>(Arrays.asList(owners));
        Account customer = addCustomer(name, accountType, balance, accountOwners);

        request.setAttribute("name", customer.getName());
        request.setAttribute("type", customer.getAccountType());
        request.setAttribute("balance", customer.getBalance());
        request.setAttribute("number", customer.getAccountNumber());
        request.setAttribute("owners", customer.getAccountOwners());
        request.setAttribute("date", customer.getJoiningDate());
        request.setAttribute("active", customer.isActive());
        request.getRequestDispatcher("/create.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
