<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manage Users</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h1>Manage Users</h1>

    <h2>Students</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>
                        <form action="<c:url value='/admin/delete-user/${student.id}' />" method="post">
                            <input type="hidden" name="userType" value="student">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Instructors</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Instructor ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="instructor" items="${instructors}">
                <tr>
                    <td>${instructor.id}</td>
                    <td>${instructor.name}</td>
                    <td>
                        <form action="<c:url value='/admin/delete-user/${instructor.id}' />" method="post">
                            <input type="hidden" name="userType" value="instructor">
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
