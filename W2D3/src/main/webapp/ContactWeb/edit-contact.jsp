<%--
  Created by IntelliJ IDEA.
  User: Emre
  Date: 4.08.2021
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Contact</title>
</head>
<body>

<form name="editForm" method="post" action="/edit">

    Name: <input type="text" name="name"/>
    <br/>
    GSM :  <input type="number" name="gsm"/>
    <br/>
    <input type="submit" value="Edit Contact"/>
</form>
</body>
</html>