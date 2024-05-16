<%-- 
    Document   : SignUp
    Created on : May 11, 2024, 1:45:40 PM
    Author     : DUCAT050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        
        <title>Sign Up Page</title>
    </head>
    <body>
        <h2>Login Form</h2>
        <p class ="text-danger">${message}</p>
        <form action="signUp" method="post">
            Name: <input type="text" name="fullname"><br>
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            Repeat password: <input type="password" name="repass"><br>
            <input type="submit" value="Sign up">
        </form>
        
<!--        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Sign Up Form</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="signup" method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <label for="fullname" class="text">Fullname:</label><br>
                                        <input class="form-control" name="fullname" type="text">
                                    </div>
                                    <div class="form-group">
                                        <label for="username" class="text">Username:</label><br>
                                        <input class="form-control" name="username" type="text">
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="text">Password:</label><br>
                                        <input class="form-control" name="password" type="password">
                                    </div>
                                    <div class="form-group">
                                        <label for="repass" class="text">Repeat password:</label><br>
                                        <input class="form-control" name="re-password" type="password">
                                    </div>
                                    <input class="btn btn-lg btn-success btn-block" type="submit" value="Sign up">
                                </fieldset>
                            </form>
                          <hr/>
                        
                        </div>
                    </div>
                </div>
            </div>
        </div>-->
    </body>
</html>
