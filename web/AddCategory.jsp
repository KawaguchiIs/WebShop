<%-- 
    Document   : AddCategory
    Created on : May 16, 2024, 12:40:56 AM
    Author     : DUCAT050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
        <link rel="stylesheet" href ="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
    </head>
    <body>
        <%@include file="adminHeader.jsp" %>
        <div class="table-list">   
        <form action="addCategory" method="post">
            <table class="content-table">
                <tr>
                    <td>Id</td>
                    <td>
                        <input type="text" name="id">
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>Describe</td>
                    <td>
                        <input type="text" name="describe">
                    </td>
                </tr>
                <tr>
                    <td>
                        <button class="btn-table" type="submit"><a>Add Category</a></button>
                    </td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
