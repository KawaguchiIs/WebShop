<%-- 
    Document   : ManageProduct
    Created on : May 15, 2024, 4:39:34 PM
    Author     : DUCAT050
--%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Product</title>
                <link rel="stylesheet" href ="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
    </head>
    <body>
        <%@include file="adminHeader.jsp" %>
        <div class="table-list">
        <table class="content-table">
            <thead>
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
            </thead>
            <tbody>
            <c:forEach items="${listP}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.name}</td>
                    <td>${i.quantity}</td>
                    <td><fmt:formatNumber pattern="###,###" value="${i.price}"/></td>
                    <td>${i.releaseDate}</td>
                    <td>${i.describe}</td>
                    <td><img src="${i.image}" alt="alt" style="width: 30%"/></td>
                    <td>${i.category.name}</td>
                    <td>
                        <button class="btn-table"><a href="updateProduct?pid=${i.id}">Update</a></button>
                        <button class="btn-table"><a href="deleteProduct?pid=${i.id}">Delete</a></button>                                   
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </body>
    
</html>
