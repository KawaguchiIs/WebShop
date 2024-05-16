<%-- 
    Document   : Admin
    Created on : May 11, 2024, 3:26:47 PM
    Author     : DUCAT050
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Admin Home Page</h1>
    <c:if test="${sessionScope.acc == null}">
        
        <a class="nav-link" href="Login.jsp">Login</a>
    </c:if>
    <c:if test="${sessionScope.acc != null}">
        <a class="nav-link" href="#">Hello ${sessionScope.acc.full_name}</a>
        <br>
        <a class="nav-link" href="logout">Logout</a>
    </c:if>
        <br>
        <a class="nav-link" href="manageaccount">Manage Account</a>
        <br>
        <a class="nav-link" href="managecategory">Manage Category</a>
        <br>
        <a class="nav-link" href="manageproduct">Manage Product</a>
    </body>
</html>
