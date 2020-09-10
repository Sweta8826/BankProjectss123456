package webapp;

import service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountBalance")
public class AccountBalance extends HttpServlet {

    AccountService service = new AccountService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String account_number = request.getParameter("accno");
        account_number = account_number.trim();
        if(!account_number.equals("")) {
            double balance = service.findAccountBalance(account_number);
            if(balance >= 0)
                request.setAttribute("balance", "" + balance);
            else
                request.setAttribute("balance", "Account Doesn't exist, Please check the account number.");
            request.getRequestDispatcher("/account_balance.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("balance", "Please Enter the account number");
            request.getRequestDispatcher("/account_balance.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
