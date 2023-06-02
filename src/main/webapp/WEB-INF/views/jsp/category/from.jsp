<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Input Category</title>
</head>
<body>
    <form action="saveCategory" method="post">
        <label for="name">Category Name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="description">Category Description:</label>
        <input type="text" id="description" name="description"><br>
        <input type="submit" value="Save">
    </form>
</body>
</html>
