<%-- 
    Document   : SignUp
    Created on : May 11, 2024, 1:45:40 PM
    Author     : DUCAT050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Sign Up</title>
        <link rel="stylesheet" href ="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
    </head>
    <body style=" background: url(./assets/img/wallpaper.jpg) fixed center no-repeat;
          display: flex;
          justify-content: center;
          align-items: center;
          min-height: 100vh;">
        <div class="login-signup">
        <h2>Sign up</h2>
        <p style="color:red;">${message}</p>
        <form action="signUp" method="post">
            <div class="input-box">
            Fullname: <input type="text" name="fullname" placeholder="Full name" required/>
            </div>
            <div class="input-box">
            Username: <input type="text" name="username" placeholder="Username" required/>
            </div>
            <div class="input-box">
            Password: <input type="password" name="password" placeholder="Password" required>
            </div>
            <div class="input-box">
            Re-pass : <input type="password" name="repass" placeholder="Repeat password" required>
            </div>
            <input class="btn-login" type="submit" value="Sign up">
        </form>
        <p>You already have a account! <a href="login.jsp">Login</a><p>
        </div>
    </body>
</html>
