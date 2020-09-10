<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 14-10-2019
  Time: 12:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <style>
        .navigation{
            float : left;
            height : 100%;
            width : 15%;
            border : 2px solid black;
            margin : 3px;
            text-align : center;
        }
        .content{
            margin : 3px;
            float : left;
            height : 100%;
            width : 80%;
            border : 2px solid black;
            vertical-align : middle;
        }
        .container{
            width : 100%;
            height : 100%;
        }
        object{
            width : 100%;
            height : 100%;
        }
        .navList{
            width : 100%;
            height : 16%;
        }
        button{
            width: 100%;
            height: 100%;
            background-color: #e0e0e0;
        }
    </style>
    <script>
        var buttons = [
            "create.jsp",
            "account_balance.jsp",
            "find_all_customers.jsp",
            "fund_transfer.jsp",
            "find_joint_account.jsp",
            "find_by_type.jsp"
        ];
        function changePage(page){
            document.getElementById('content').data = page;
            var len = buttons.length;
            for(var i = 0; i<len; i++)
                document.getElementById(buttons[i]).style.backgroundColor = "#e0e0e0";
            document.getElementById(page).style.backgroundColor = "#757575";
        }
    </script>
</head>
<body>
<div class = "container">
    <table class = "navigation">
        <tr class = "navList"> <td><button onClick = 'changePage("create.jsp")' id = "create.jsp"> Create Account </button> </td></tr>
        <tr class = "navList"> <td><button onClick = 'changePage("account_balance.jsp")' id = "account_balance.jsp"> Check Account balance </button></td></tr >
        <tr class = "navList"> <td><button onClick = 'changePage("find_all_customers.jsp")' id = "find_all_customers.jsp"> Find All Customers </button></td></tr>
        <tr class = "navList"> <td><button onClick = 'changePage("fund_transfer.jsp")' id = "fund_transfer.jsp"> Fund Transfer </button></td></tr>
        <tr class = "navList"> <td><button onClick = 'changePage("find_joint_account.jsp")' id = "find_joint_account.jsp"> Find Joint Account Customers </button></td></tr>
        <tr class = "navList"> <td><button onClick = 'changePage("find_by_type.jsp")' id = "find_by_type.jsp"> Find Accounts By Type </button></td></tr>
    </table>
    <div class = "content">
        <object id = "content" data="" type="text/html">
            Error: Embedded data could not be displayed.
        </object>
    </div>
</div>
</body>
</html>

