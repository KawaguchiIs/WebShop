<%-- 
    Document   : UpdateProduct
    Created on : May 16, 2024, 8:46:11 AM
    Author     : DUCAT050
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product Page</title>
    </head>
    <body>
        <h1>Update category</h1>
        <form action="updateproduct" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input value = "${proObj.id}" type="text" name="id" readonly></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input value = "${proObj.name}" type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td><input value = "${proObj.quantity}" type="text" name="quantity"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input value = "${proObj.price}" type="text" name="price"></td>
                </tr>
                <tr>
                    <td>Release Date</td>
                    <td><input value = "${proObj.releaseDate}" type="text" name="releaseDate"></td>
                </tr>
                <tr>
                    <td>Describe</td>
                    <td><input value = "${proObj.describe}" type="text" name="describe"></td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td><input value = "${proObj.image}" type="text" name="image"></td>
                </tr>
<!--                <tr>
                    <td>Cid</td>
                    <td><input value = "${proObj.category.id}" type="text" name="cid"></td>
                </tr>-->
                <tr>
                    <td>Cid select</td>
                    <td>
                        <select name="category" aria-label="Default select example">
                            <c:forEach items="${listCate}" var="j">
                                <option ${proObj.category.id == j.id?"selected":""} value="${j.id}">${j.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="submit">Update Product</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
