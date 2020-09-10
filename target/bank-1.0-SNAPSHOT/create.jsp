<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.OutputStreamWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 14-10-2019
  Time: 01:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add New Customer</title>
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
            box-shadow: gray 5px 5px;
        }
        label{
            width: 100%;
        }

    </style>
</head>
<body>
    <center>
        <form action = "/bank_Web_exploded/Create" method="post">
            <table width="40%">
                <tr>
                    <td>
                        <label> Name : </label>
                    </td>
                    <td>
                        <input type = "text" name = "customerName" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label> Account Type : </label>
                    </td>
                    <td>
                        <label>Savings</label><input type = "radio" name = "accountType" value = "Savings" required />
                        <label>Current</label><input type = "radio" name = "accountType" value = "Current" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label> Balance : </label>
                    </td>
                    <td>
                        <input type = "number" name = "initialBalance" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label> Account Owners : </label>
                    </td>
                    <td>
                        <input type = "text" name = "owners" required>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="create">
                    </td>
                </tr>
            </table>
        </form>
        <br><br>
        <table width="40%" class="customerDetails">
            <tr>
                <td>
                    <label> Name : </label>
                </td>
                <td>
                    ${name}
                </td>
            </tr>
            <tr>
                <td>
                    <label> Account Type : </label>
                </td>
                <td>
                    ${type}
                </td>
            </tr>
            <tr>
                <td>
                    <label> Balance : </label>
                </td>
                <td>
                    ${balance}
                </td>
            </tr>
            <tr>
                <td>
                    <label> Account Owners : </label>
                </td>
                <td>
                    ${owners}
                </td>
            </tr>
            <tr>
                <td>
                    <label> Account Number : </label>
                </td>
                <td>
                    ${number}
                </td>
            </tr><tr>
            <td>
                <label> Opening Date : </label>
            </td>
            <td>
                ${date}
            </td>
        </tr><tr>
            <td>
                <label> Is Active : </label>
            </td>
            <td>
                ${active}
            </td>
        </tr>

        </table>
    </center>
</body>
</html>
