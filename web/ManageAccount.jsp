<%-- 
    Document   : ManageAccount
    Created on : May 13, 2024, 5:35:34 PM
    Author     : DUCAT050
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Account</title>
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
                <th>Username</th>
                <th>Password</th>
                <th>Role</th>
                <th>Status</th>
                <th>Lock account</th>
                
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listAcc}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.name}</td>
                    <td>${i.username}</td>
                    <td>${i.password}</td>
                    <td>
                        <c:if test="${i.isAdmin == 1}">Admin</c:if>
                        <c:if test="${i.isAdmin == 0}">Member</c:if> 
                    </td>
                    <td>
                        <c:if test="${i.isLock == 1}">Lock</c:if>
                        <c:if test="${i.isLock == 0}">Open</c:if> 
                    </td>

                    <td>
                        <c:if test="${i.isLock == 1}">
                            <button class="btn-table"><a href="updateLockA?id=${i.id}&status=0">Unlock</a></button>
                            
                        </c:if>
                        <c:if test="${i.isLock == 0}">
                            <button class="btn-table"><a href="updateLockA?id=${i.id}&status=1">Lock</a></button>                            
                        </c:if>        
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>        
    </body>

</html>
