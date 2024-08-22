<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Course</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h1>Create New Course</h1>
    <form action="<c:url value='/instructors/create-course' />" method="post">
        <input type="hidden" name="instructorId" value="${param.instructorId}">

        <label for="name">Course Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4" cols="50" required></textarea><br>

        <input type="submit" value="Create Course">
    </form>
    <a href="<c:url value='/instructors/my-courses/${param.instructorId}' />">Back to My Courses</a>
</body>
</html>
