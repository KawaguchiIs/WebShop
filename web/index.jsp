<%-- 
    Document   : index
    Created on : Apr 26, 2024, 4:55:04 PM
    Author     : Acer Helios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href ="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
    </head>
    <body>        
        <%@include file= "header.jsp" %>

    <!-- content -->
    <div id="content">
            <!-- tab-left -->
            <div id="tab-left">     
            <h3>Category Name</h3>
            <hr style = "border-top: 1px solid #000"/>
            <c:set var = "chid" value="${requestScope.chid}" />
            <form id ="search-category-name" action="homeFilter">
                <input type="checkbox" id="check0" name="check-name" class="tab-category"
                    ${chid[0]?"checked":""}
                    value ="0" onclick="setCheck(this)"/>ALL<br>
                <c:forEach begin="0" end="${cate.size()-1}" var="i" >
                <input type="checkbox" id="check-number" name="check-name" class="tab-category"
                    ${cate.get(i).getId()== cid?"checked":""}
                    value ="${cate.get(i).getId()}"
                    ${chid[i+1]?"checked":""} onclick="setCheck(this)" />
                ${cate.get(i).getName()}
                <br/>
                </c:forEach>
            </form>
            <h3>Category Price</h3>
            <hr style = "border-top: 1px solid #000"/>
            <c:set  var = "priceList" value = "${requestScope.priceList}" />
            <c:set  var = "price" value = "${requestScope.price}" />
            <form id ="search-category-price" action="homeFilter">
                <input type="checkbox" id="check-price0" name="price" class="tab-category"
                    ${price[0]?"checked":""}
                    value = "0" onclick = "setCheck1(this)"/>ALL<br/>
                <c:forEach  begin = "0" end = "${4}" var ="i">
                <input type="checkbox" id ="check-price1" name="price" class="tab-category"
                    ${price[i+1]?"checked":""}
                    value ="${i+1}" onclick="setCheck1(this)"/>${priceList[i]}
                <br/>
                </c:forEach>
                
            </form>
        </div>
        <!-- tab-right -->
        <div id="tab-right">
            <c:if test="${sessionScope.account != null}">        
                <h4 style="color :#555 ; margin:20px 50px">Hello ${sessionScope.account.name} </h4>
            </c:if>
            <form name="buy" action="" method="POST">
            <c:set var = "news" value="${requestScope.news}" />
            <c:if test="${news!=null}">
            <h3>Đầu truyện mới</h3>
            <ul class="item">
                <c:forEach items = "${news}" var = "p">
                    <c:set var = "id" value= "${p.id}"/>
                <li>
                    <a href="#">
                    <img src="${p.image}" alt="item">
                    <p>${p.name}</p>
                    <fmt:formatNumber pattern="###,###" value="${p.price}"/> VNĐ
                    </br>
                    <p>Quantity: ${p.quantity} vol</p>
                    </a>
                    </br>
                    <input type="submit" class="buy-item" name="num"  value="Add to Cart" onclick="buy_item('${id}')"/>
                </li>
               </c:forEach>
            </ul>
            
            <div class="clear"></div>
            <hr style="margin-top: 50px"/>
            </c:if>
      
            <c:set var = "olds" value="${requestScope.olds}" />
            <c:if test="${olds!=null}">    
            <h3>Đầu truyện cũ</h3>
            <ul class="item">
                <c:forEach items = "${olds}" var = "p">
                    <c:set var = "id" value= "${p.id}"/>
                <li>
                    <a href="#">
                    <img src="${p.image}" alt="item">
                     <p>${p.id}</p>
                    <p>${p.name}</p>
                    <fmt:formatNumber pattern="###,###" value="${p.price}"/> VNĐ
                    </br>
                    <p>Quantity: ${p.quantity} vol</p>
                    </a>
                    
                    </br>
                    <input type="submit" class="buy-item" name="num" value="Add to Cart" onclick="buy_item('${id}')"/>
                </li>
               </c:forEach>
            </ul>
            </c:if>
            
            
            <c:set var = "olds" value="${requestScope.products}" />
            <c:if test="${products!=null}"> 
            <h3>Đầu truyện bạn cần tìm</h3>
            <ul class="item">
                <c:forEach items = "${products}" var = "p">
                    <c:set var = "id" value= "${p.id}"/>
                <li>
                    <a href="#">
                    <img src="${p.image}" alt="item">
                    <p>${p.name}</p>
                    <fmt:formatNumber pattern="###,###" value="${p.price}"/> VNĐ
                    </br>
                    <p>Quantity: ${p.quantity} vol</p>
                    </a>
                    </br>
                    <input type="submit" class="buy-item" name ="num" value="Add to Cart" onclick="buy_item('${id}')"/>
                </li>
               </c:forEach>
            </ul>
            </c:if>
            </form>
            
        </div>
        </div>

        <div class="clear"></div>
        <%@include file="footer.jsp" %>
        
    <script>
        function setCheck(obj){
            var marks = document.getElementsByName('check-name');
            if((obj.id=="check0") && (marks[0].checked == true)){
                for (var i = 1; i < marks.length; i++)
                    marks[i].checked = false;
            }else{
                for (var i =1;  i < marks.length; i++){
                    if(marks[i].checked == true){
                        marks[0].checked = false;
                        break;
                    }
                }
            }
            document.getElementById("search-category-name").submit();
        }
    </script>
    
        <script>
        function setCheck1(obj){
            var marks = document.getElementsByName('price');
            if((obj.id=="check-price0") && (marks[0].checked == true)){
                for (var i = 1; i < marks.length; i++)
                    marks[i].checked = false;
            }else{
                for (var i =1;  i < marks.length; i++){
                    if(marks[i].checked == true){
                        marks[0].checked = false;
                        break;
                    }
                }
            }
            document.getElementById("search-category-price").submit();
        }
    </script>
    
    <script>
        function buy_item(id){
            document.buy.action = "buy?id=" +id +"&num=" +1;
            document.buy.submit();
        }
    </script>
    </body>
</html>
