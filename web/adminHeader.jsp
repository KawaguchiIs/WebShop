<%-- 
    Document   : adminHeader
    Created on : May 16, 2024, 11:23:28 PM
    Author     : Acer Helios
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id =header>
    <ul id="nav">
                <li><a href="home">Home</a></li>
                <li><a href="manageAccount">Manage Account</a></li>
                <li><a href="manageCategory">Manage Category</a></li>
                <li><a href="manageProduct">Manage Product</a></li>                  
                <c:if test="${sessionScope.account != null}">  
                <li><a href="logout">Logout</a></li>
                </c:if>
    </ul>
</div>
