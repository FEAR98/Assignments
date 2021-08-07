<%--
  Created by IntelliJ IDEA.
  User: Emre
  Date: 3.08.2021
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <title>HTTP headers</title>
</head>
<body>
<p>HTTP headers:</p>
<ol>
  <c:forEach var="nextHeader" items="${header}">
    <li><c:out value="${nextHeader.key}" /> = <c:out value="${nextHeader.value}" /></li>
  </c:forEach>
</ol>
</body>
</html>
