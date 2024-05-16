<%-- 
    Document   : UpdateCategory
    Created on : May 16, 2024, 1:32:48 AM
    Author     : DUCAT050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Category</title>
        <link rel="stylesheet" href ="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
    </head>
    <body>
        <%@include file="adminHeader.jsp" %>
        <div class="table-list">
        <h1>Update Category</h1>
        <form action="updateCategory" method="post">
            <table class="content-table">
                <tr>
                    <td>Id</td>
                    <td>
                        <input value = "${cateObj.id}" type="text" name="id" readonly>
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <input value = "${cateObj.name}" type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>Describe</td>
                    <td>
                        <input value = "${cateObj.describe}" type="text" name="describe">
                    </td>
                </tr>
                <tr>
                    <td>
                        <button class="btn-table" type="submit"><a>Update Category</a></button>
                    </td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
