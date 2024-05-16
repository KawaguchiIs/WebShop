<%-- 
    Document   : myCart
    Created on : May 13, 2024, 3:59:19 PM
    Author     : Acer Helios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cart</title>
        <link rel="stylesheet" href ="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
    </head>
    <body>
        <%@include file= "header.jsp" %>
        
        <div class="table-list">
            <h1>Shopping Cart</h1>
            <table class="content-table">
                <thead>
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total Money</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:set var= "i" value = "${requestScope.cart}"/>
                <c:set var = "no" value = "0"/>
                <c:forEach items = "${i.items}" var = "x">
                    <c:set var = "no" value = "${no + 1}"/>
                    <tr>
                        <td>${no}</td>
                        <td>${x.product.name}</td>
                        <td style = "text-align: center">
                            <button class="btn-table"><a href="process?num=-1&id=${x.product.id}">-</a></button>
                            ${x.quantity}
                            <button class="btn-table"><a href="process?num=1&id=${x.product.id}">+</a></button>
                        </td>
                        <td>
                            <fmt:formatNumber pattern = "###,###" value = "${x.price}"/>
                        </td>
                        <td>
                            <fmt:formatNumber pattern = "###,###" value = "${(x.price)*(x.quantity)}"/>
                        </td>
                        <td style = "text-align: center">
                            <form action="process" method="POST">
                                <input type="hidden" name="id" value="${x.product.id}">
                                <input class="btn-table" type="submit" value="return item">
                            </form>
                        </td>
                    </tr>
                </c:forEach>  
                </tbody>
            </table>
                <h3>Total Money:
                <fmt:formatNumber pattern = "###,###" value = "${i.totalMoney}"/>
                VNĐ
                </h3>
                </hr>
                <form action="checkOut" method="POST">
                    <input class="btn-table" type="submit" value="check out"/>
                </form>
                </hr>
                <button class="btn-table"><a href="home">click me to continue shopping</a></button>
        </div>
        
        <div class="clear"></div>
        <%@include file="footer.jsp" %>
    </body>
</html>
