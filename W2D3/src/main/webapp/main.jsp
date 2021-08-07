<%--
  Created by IntelliJ IDEA.
  User: Emre
  Date: 4.08.2021
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>JSP Static Include Example</title>
</head>

<body>
The current date and time are
<%@ include file="header.jsp"%>
</body>

<body>
This is a page<br/>
<jsp:include page="footer.jsp" />
</body>

</html>
