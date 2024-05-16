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
        <title>Update Category Page</title>
    </head>
    <body>
        <h1>Update category</h1>
        <form action="updatecategory" method="post">
            <table>
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
                        <button type="submit">Update Category</button>
                    </td>
                </tr>
            </table>
        </form>

    </body>
</html>
