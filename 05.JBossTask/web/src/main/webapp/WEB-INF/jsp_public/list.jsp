<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 30.11.14
  Time: 19.21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>BookList</title>
</head>
<body>
<c:forEach items="${books}" var="book">
  <c:out value="${book.title}"/>
  <c:out value="${book.published}"/><br/>
</c:forEach>
</body>
</html>
