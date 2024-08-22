<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Browse Courses</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h1>Browse Courses</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Course Name</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.name}</td>
                    <td>${course.description}</td>
                    <td>
                        <form action="<c:url value='/students/enroll' />" method="post">
                            <input type="hidden" name="studentId" value="${studentId}">
                            <input type="hidden" name="courseId" value="${course.id}">
                            <input type="submit" value="Enroll">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
