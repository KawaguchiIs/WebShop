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
        <title>Manage Category Page</title>
    </head>
    <body>
        <table border="1px solid black">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Describe</th>
                <th>Function</th>
                
            </tr>
            <c:forEach items="${listCate}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.name}</td>
                    <td>${i.describe}</td>
                    <td>
                        <a href="updatecategory?cid=${i.id}">Update</a>
                        <a href="deletecategory?cid=${i.id}">Delete</a>                            
                               
                    </td>
                </tr>
            </c:forEach>
        </table>
            <a href="AddCategory.jsp">Add Category</a>
    </body>
</html>
