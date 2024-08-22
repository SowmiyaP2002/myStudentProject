<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management System</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <header>
        <h1>Welcome to the Student Management System</h1>
    </header>
    
    <nav>
        <ul>
            <li><a href="<c:url value='/students/browse-courses' />">Browse Courses</a></li>
            <li><a href="<c:url value='/students/profile/1' />">My Profile</a></li>
            <li><a href="<c:url value='/instructors/create-course' />">Create a Course</a></li>
            <li><a href="<c:url value='/admin/manage-users' />">Manage Users</a></li>
            <li><a href="<c:url value='/admin/manage-courses' />">Manage Courses</a></li>
        </ul>
    </nav>

    <main>
        <h2>Features</h2>
        <p>Use the links in the navigation bar to access different features of the Student Management System.</p>
    </main>

    <footer>
        <p>&copy; 2024 Student Management System. All rights reserved.</p>
    </footer>
</body>
</html>
