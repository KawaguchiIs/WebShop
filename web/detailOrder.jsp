<%-- 
    Document   : detailOrder
    Created on : May 14, 2024, 11:55:51 PM
    Author     : Acer Helios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Detail</title>
        <link rel="stylesheet" href ="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
    </head>
    <body>
        <%@include file= "header.jsp" %>
        <div class="table-list">
            <h1>Order List</h1>
            <table class="content-table">
                <thead>
                <tr>
                    <th>No</th>
                    <th>Product</th>
                    <th>quantity</th>
                    <th>price</th>
                </tr>
                </thead>
                <tbody>
                <c:set var= "i" value = "${requestScope.orderDetail}"/>
                <c:set var = "no" value = "0"/>
                <c:forEach items = "${i}" var = "o">
                    <c:set var = "no" value = "${no + 1}"/>
                    <tr>
                        <td>${no}</td>
                        <td>${o.product.name}</td>
                        <td>
                            ${o.quantity}
                        </td>
                        <td>
                            <fmt:formatNumber pattern = "###,###" value = "${o.price}"/>
                        </td>
                    </tr>
                </c:forEach> 
                </tbody>
            </table>
                
        </div>
        <div class="clear"></div>
        <%@include file= "footer.jsp" %>
    </body>
</html>

