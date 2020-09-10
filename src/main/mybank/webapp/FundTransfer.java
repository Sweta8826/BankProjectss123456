package webapp;

import service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FundTransfer")
public class FundTransfer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService service = new AccountService();
        response.setContentType("text/html");
        String sender = request.getParameter("sno");
        String receiver = request.getParameter("rno");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String confirmation = service.processFundTransfer(sender, receiver, amount);
        request.setAttribute("confirmation", confirmation);
        request.getRequestDispatcher("/fund_transfer.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
