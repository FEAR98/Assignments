
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Contact</title>
</head>
<body>

<form name="searchNameForm" method="post" action="/search">

    Name: <input type="text" name="name"/>
    <br/>
    GSM :  <input type="number" name="gsm"/>
    <br/>
    <input type="submit" value="Search Contact by Name"/>
</form>

</body>
</html>
