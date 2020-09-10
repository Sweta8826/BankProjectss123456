<%@ page import="service.AccountService" %>
<%@ page import="domain.Account" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: AN20090319
  Date: 10/14/2019
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    AccountService service = new AccountService();
    Set<Account> customers = service.findAllCustomers();
%>

<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-color: #e0e0e0;
        }
        td {
            width: 50%;
            padding: 5px;
        }
        table {
            border: 2px solid black;
            box-shadow: gray 5px 5px 3px;
            margin: 5px;
        }
        label{
            width: 100%;
        }
        .customerDetails{
            float: left;
            border-radius: 10px;
        }

    </style>
</head>
<body >
    <br>
    <div class = "result">
        <span id = "result">
            <%
                for (Account customer : customers) {
                    String name = customer.getName();
                    String accno = customer.getAccountNumber();
                    String type = customer.getAccountType();
                    boolean isActive = customer.isActive();
                    double balance = customer.getBalance();
                    Date date = customer.getJoiningDate();
                    String owners = customer.getAccountOwners().toString();

                    String tabs = " <table width=\"32%\" class=\"customerDetails\">\n" +
                            "            <tr>\n" +
                            "                <td>\n" +
                            "                    <label> Name : </label>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                            name+"\n" +
                            "                </td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td>\n" +
                            "                    <label> Account Type : </label>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                            type+"\n" +
                            "                </td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td>\n" +
                            "                    <label> Balance : </label>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                            balance+"\n" +
                            "                </td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td>\n" +
                            "                    <label> Account Owners : </label>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                            owners+"\n" +
                            "                </td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td>\n" +
                            "                    <label> Account Number : </label>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                            accno+"\n" +
                            "                </td>\n" +
                            "            </tr><tr>\n" +
                            "            <td>\n" +
                            "                <label> Opening Date : </label>\n" +
                            "            </td>\n" +
                            "            <td>\n" +
                            date+"\n" +
                            "            </td>\n" +
                            "        </tr><tr>\n" +
                            "            <td>\n" +
                            "                <label> Is Active : </label>\n" +
                            "            </td>\n" +
                            "            <td>\n" +
                            isActive+"\n" +
                            "            </td>\n" +
                            "        </tr>\n" +
                            "\n" +
                            "        </table>";
                    response.getWriter().println(tabs);
                }
            %>
        </span>
    </div>
</body>
</html>
