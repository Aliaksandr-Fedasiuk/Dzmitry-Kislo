<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Input message</title>
</head>
<body>
<form action="SendMessageServlet.do">
    <label>Text:</label>
    <input name="message" type="text"/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
