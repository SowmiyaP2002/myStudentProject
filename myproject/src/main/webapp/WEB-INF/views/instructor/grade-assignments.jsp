<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Grade Assignments</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h1>Grade Assignments for ${course.name}</h1>
    <form action="<c:url value='/instructors/grade-assignments/${course.id}' />" method="post">
        <!-- Example static data, replace with dynamic content if available -->
        <c:forEach var="student" items="${course.students}">
            <div>
                <label for="student_${student.id}">${student.name}:</label>
                <input type="hidden" name="studentIds" value="${student.id}">
                <input type="number" name="grades" min="0" max="100" required>
            </div>
        </c:forEach>
        <input type="submit" value="Submit Grades">
    </form>
    <a href="<c:url value='/instructors/my-courses/${course.instructor.id}' />">Back to My Courses</a>
</body>
</html>
