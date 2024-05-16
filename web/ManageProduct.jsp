<%-- 
    Document   : ManageProduct
    Created on : May 15, 2024, 4:39:34 PM
    Author     : DUCAT050
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Product Page</title>
    </head>
    <body>
        <body>
        <table border="1px solid black">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Release Date</th>
                <th>Describe</th>
                <th>Image</th>
                <th>Category</th>
                <th>Function</th>
                
            </tr>
            <c:forEach items="${listP}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.name}</td>
                    <td>${i.quantity}</td>
                    <td>${i.price}</td>
                    <td>${i.releaseDate}</td>
                    <td>${i.describe}</td>
                    <td>${i.image}</td>
                    <td>${i.category.name}</td>
                    <td>
                        <a href="updateproduct?pid=${i.id}">Update</a>
                        <a href="deleteproduct?pid=${i.id}">Delete</a>                                   
                    </td>
                </tr>
            </c:forEach>
        </table>
            <a href="#">Add Category</a>
    </body>
    
</html>
