<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cart</title>
     <style>
      <%@include file="/resources/css/cart.css" %>
        </style>
</head>
<body>
    <div class="text">
            <a class="class1" href="/products"><h2>products</h2></a>
        <h2>Cart Items:</h2>
        </div>

    <h2></h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
             <c:forEach items="${cartItems}" var="item">

                       <tr>
                           <td>${item.id}</td>
                           <td>${item.name}</td>
                           <td>${item.price}</td>
                           <td>
                               <a href="/cart/remove/${item.id}">Remove</a>
                           </td>
                       </tr>

                   </c:forEach>
        </tbody>
    </table>

    <a href="/cart/clear">Clear Cart</a>
    <a href="/cart/checkout">Thanh toán</a>
</body>
</html>
