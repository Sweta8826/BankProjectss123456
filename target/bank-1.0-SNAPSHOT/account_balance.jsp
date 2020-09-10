<%--
  Created by IntelliJ IDEA.
  User: AN20090319
  Date: 10/14/2019
  Time: 3:35 PM
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
    </style>
</head>
<body>
    <form action="/bank_Web_exploded/AccountBalance" method="post">
        <label>Enter Account Number: </label>
        <input type = "text" name="accno" required/>
        <input type = "submit" value = "get Account Balance"/>
    </form>
    <br>
    <label> <h1>${balance}</h1></label>
</body>
</html>
