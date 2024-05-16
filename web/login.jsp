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
        <title>Login</title>
        <link rel="stylesheet" href ="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
    </head>
    <body style=" background: url(./assets/img/wallpaper.jpg) fixed center no-repeat;">
        <div class="login-signup">
            <h1>Login</h1>
            <h3 style="color: red;">${message}</h3>    
            <form action="login" method ="POST">
                <div class="input-box">
                    Username:<input type ="text" name ="user" placeholder="Username" required/>
                </div>
                <div class="input-box">
                Password:<input type="password" name="pass" placeholder="Password" required/>
                </div>
                <input class="btn-login" type="submit" value="Login">
            </form>
            <p>Don't have a account? <a href="SignUp.jsp">Sign up</a><p>
        </div>
    </body>
</html>
