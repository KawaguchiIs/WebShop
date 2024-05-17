<%-- 
    Document   : ManageCategory
    Created on : May 15, 2024, 3:27:06 PM
    Author     : DUCAT050
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Category</title>
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
                <th>Describe</th>
                <th>Function</th>
                
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCate}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.name}</td>
                    <td>${i.describe}</td>
                    <td>
                        <button class="btn-table"><a href="updateCategory?cid=${i.id}">Update</a></button>
                        <button class="btn-table"><a href="deleteCategory?cid=${i.id}">Delete</a></button>                          
                               
                    </td>
                </tr>
            </c:forEach>
            <tbody>
        </table>
            <button class="btn-table"><a href="addCategory">Add Category</a></button>
        </div>
    </body>
</html>
