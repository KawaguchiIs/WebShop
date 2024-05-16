<%-- 
    Document   : login
    Created on : May 14, 2024, 12:13:31 PM
    Author     : Acer Helios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <h3>${message}</h3>    
        <form action="login" method ="POST">
            Username:<input type ="text" name ="user"/>
            Password:<input type="password" name="pass"/>
            <input type="submit" value="Login">
        </form>
        <a href="SignUp.jsp">Sign up</a>
    </body>
</html>
