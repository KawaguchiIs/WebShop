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
        <title>Add Category Page</title>
    </head>
    <body>
        <h1>Add Category</h1>
        <form action="addcategory" method="post">
            <table>
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
                        <button type="submit">Add Category</button>
                    </td>
                </tr>
            </table>
        </form>

    </body>
</html>
