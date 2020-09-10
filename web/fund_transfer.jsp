<%--
  Created by IntelliJ IDEA.
  User: AN20090319
  Date: 10/14/2019
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-color: #e0e0e0;
        }
        label{
            display: inline-block;
            width: 20%;
        }
    </style>
</head>
<body>
    <form action = "/bank_Web_exploded/FundTransfer" method = "post">
        <fieldset>
            <legend>Fund Transfer</legend>
            <label>Sender's Account Number</label><input type="text" name = "sno" required /><br><br>
            <label>Amount</label><input type = "number" name = "amount" required /><br><br>
            <label>Receiver's Account Number</label><input type="text" name = "rno" required /><br><br>
            <input type = "submit" value = Transfer>
        </fieldset>
    </form>
    <br>
    <h1>${confirmation}</h1>
</body>
</html>
