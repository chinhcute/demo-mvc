<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Categories</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty categories}">
                <c:forEach items="${categories}" var="category">
                    <tr>
                        <td>${category.id}</td>
                        <td>${category.name}</td>
                        <td>${category.description}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty categories}">
                <tr>
                    <td colspan="3">No categories found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</body>
</html>
