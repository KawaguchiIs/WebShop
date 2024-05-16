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
        <title>Manage Account Page</title>
    </head>
    <body>
        <table border="1px solid black">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Username</th>
                <th>Password</th>
                <th>Role</th>
                <th>Status</th>
                <th>Lock account</th>
                
            </tr>
            <c:forEach items="${listAcc}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.full_name}</td>
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
                            <a href="updateLockA?id=${i.id}&status=0">Unlock</a>
                            
                        </c:if>
                        <c:if test="${i.isLock == 0}">
                            <a href="updateLockA?id=${i.id}&status=1">Lock</a>                            
                        </c:if>        
                    </td>
                </tr>
            </c:forEach>
        </table>
            
    </body>
</html>
