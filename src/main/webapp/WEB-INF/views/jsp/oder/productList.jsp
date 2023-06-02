<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>.
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${productEntityList}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                   <td><a href="/addToCart/${product.id}">Add to Cart</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
