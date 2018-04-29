<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <p>Username: </p>
    <c:forEach items="${requestScope.users}" var="user">
        <${pageContext.request.contextPath}<br>
    </c:forEach>
    <p>${requestScope.user.name}</p>
</div>
</body>
</html>
