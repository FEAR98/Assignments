<%@ page language="java"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>-RNG-</title>
</head>
<body>

<div style="text-align: center;">
    <span style="color: coral; font-size: xx-large; ">  Random Number Generator  </span>
</div>
<H3 ALIGN="CENTER">
    Random number from 0 to 100 :
    <span style="color: red">
        <%= (int) (Math.random() * 100) %>

    </span>

</H3>
<div style="text-align: center;">
    <a href="hello-servlet">Change the Specifications</a>
</div>
</body>
</html>