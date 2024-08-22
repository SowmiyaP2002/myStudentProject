<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manage Courses</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h1>Manage Courses</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Instructor</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.instructor.name}</td>
                    <td>
                        <form action="<c:url value='/admin/delete-course/${course.id}' />" method="post">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="<c:url value='/index.jsp' />">Home</a>
</body>
</html>
