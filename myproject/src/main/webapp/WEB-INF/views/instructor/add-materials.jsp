<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Materials</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h1>Add Materials to ${course.name}</h1>
    <form action="<c:url value='/instructors/add-materials/${course.id}' />" method="post">
        <label for="material">Material:</label>
        <input type="text" id="material" name="materials" required><br>

        <input type="submit" value="Add Material">
    </form>
    <a href="<c:url value='/instructors/my-courses/${course.instructor.id}' />">Back to My Courses</a>
</body>
</html>
