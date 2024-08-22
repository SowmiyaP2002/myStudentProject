<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Materials</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h1>Materials for ${course.name}</h1>
    <ul>
        <c:forEach var="material" items="${materials}">
            <li><a href="${material.url}" target="_blank">${material.title}</a></li>
        </c:forEach>
    </ul>
</body>
</html>
