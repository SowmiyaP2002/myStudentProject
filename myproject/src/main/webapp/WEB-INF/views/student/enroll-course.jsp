<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Enroll in Course</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h1>Enroll in Course</h1>
    <form action="<c:url value='/students/enroll' />" method="post">
        <input type="hidden" name="studentId" value="${studentId}">
        <label for="courseId">Course:</label>
        <select id="courseId" name="courseId">
            <c:forEach var="course" items="${courses}">
                <option value="${course.id}">${course.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Enroll">
    </form>
</body>
</html>
