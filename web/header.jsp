<%-- 
    Document   : header
    Created on : Apr 26, 2024, 4:56:12 PM
    Author     : Acer Helios
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <div id="header">
            <ul id="nav">
                <c:set var="cate" value = "${requestScope.data}"/>
                <c:set var="cid" value = "${requestScope.cid}" />
                <li><a href="home">Home</a></li>
                <c:if test="${sessionScope.account != null}">     
                <li><a href="order">Order</a></li>
                </c:if>
                <li>
                    <a href="">
                        Category 
                        <i class="nav-arrow-down ti-angle-down"></i>
                    </a>
                    <ul class="subnav">
              
                        <li><a class="${cid==0?"active":""}" href="homeFilter?cid=${0}">ALL</a></li>
                        <c:forEach items="${cate}" var="c">
                        <li><a class="${c.id==cid?"active":""}" href="homeFilter?cid=${c.id}">${c.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <c:if test="${sessionScope.account == null}">     
                <li><a href="login">Login</a></li>
                </c:if>
                <c:if test="${sessionScope.account != null}">  
                <li><a href="logout">Logout</a></li>
                </c:if>
            </ul>

            <!-- search button -->
            <div class="search-btn">
                <form id="search-form" action="homeFilter" method="get">
                <div class="search-container">
                    <input type="text" placeholder="Search" id = "search-product" name ="key">
                    <button class="search-icon ti-search" onclick="this.form.submit()"></button>
                </div>
                </form>
                <div class="cart">
                <a href="show">
                    <i class="ti-shopping-cart"></i>
                    My Cart</a>
            </div>
            </div>
      
        </div>
    </div>
