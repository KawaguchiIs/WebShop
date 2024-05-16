<%-- 
    Document   : order
    Created on : May 14, 2024, 9:13:53 PM
    Author     : Acer Helios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
        <link rel="stylesheet" href ="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
    </head>
    <body>
        <%@include file= "header.jsp" %>
        <div class="table-list" style="margin-top: 100px">
            <h1>Order List</h1>
            <form id="search-order" action="order" method ="GET">
            Từ ngày:<input type="date" name="fromdate"/>
            Đến ngày:<input type="date" name="todate"/>
            <input class="btn-table" type ="submit" value="Search"/>
            </form>
            <table class="content-table">
                <thead>
                <tr>
                    <th>No</th>
                    <th>Date</th>
                    <th>Total Money</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:set var= "i" value = "${requestScope.orders}"/>
                <c:set var = "no" value = "0"/>
                <c:forEach items = "${i}" var = "o">
                    <c:set var = "no" value = "${no + 1}"/>
                    <tr>
                        <td>${no}</td>
                        <td>${o.date}</td>
                        <td>
                            <fmt:formatNumber pattern = "###,###" value = "${o.total_money}"/>
                        </td>
                        <td style = "text-align: center">
                            <form action="orderDetail" method="GET">
                                <button class="btn-table"><a href="orderDetail?id=${o.id}">Detail</a></button>
                            </form>
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
