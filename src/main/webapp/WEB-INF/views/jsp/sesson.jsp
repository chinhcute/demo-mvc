<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <h1>Book Information</h1>
    <c:if test="${not empty savedBook}">
        <p>Book Name: <c:out value="${savedBook.name}" /></p>
        <p>Author: <c:out value="${savedBook.author}" /></p>
        <!-- Hiển thị các thông tin khác của sách -->
    </c:if>
</body>
</html>
