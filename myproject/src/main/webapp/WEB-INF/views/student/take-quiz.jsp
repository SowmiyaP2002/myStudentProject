<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Take Quiz</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h1>Quiz for ${course.name}</h1>
    <form action="<c:url value='/students/submit-quiz' />" method="post">
        <!-- Assuming the quiz object and questions are properly populated -->
        <c:forEach var="question" items="${quiz.questions}">
            <div>
                <p>${question.text}</p>
                <c:forEach var="option" items="${question.options}">
                    <input type="radio" name="question_${question.id}" value="${option.id}"> ${option.text} <br>
                </c:forEach>
            </div>
        </c:forEach>
        <input type="submit" value="Submit Quiz">
    </form>
</body>
</html>
