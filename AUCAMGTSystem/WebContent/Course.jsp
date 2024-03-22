<%@page import="java.util.List"%>
<%@page import="com.students.dao.SemestersDao"%>
<%@page import="com.students.dao.AcademicUnitsDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Course Management</title>
<link rel="stylesheet" href="Course.css">
<style>
    /* Add custom CSS styles here */
</style>
</head>
<body>
    <div class="container">
        <h3>Course Form</h3>
        <form action="CourseServlet" method="post" class="reg_form">
            <c:if test="${not empty message}">
                <p style="color: green;">${message}</p>
            </c:if>
            <label for="courseId">Course ID:</label>
            <input type="text" name="id" id="courseId" required>
            <label for="courseCode">Course Code:</label>
            <input type="text" name="code" id="courseCode" required>
            <label for="courseName">Course Name:</label>
            <input type="text" name="name" id="courseName" required>
            <label for="semesterId">Semester:</label>
            <select name="semesterId">
                <c:forEach var="semester" items="${semesters}">
                    <option value="${semester.semId}">${semester.name}</option>
                </c:forEach>
            </select>
            <label for="departmentId">Department:</label>
            <select name="departmentId">
                <c:forEach var="unit" items="${academicUnits}">
                    <option value="${unit.id}">${unit.name}</option>
                </c:forEach>
            </select>
            <div class="btnSet">
                <button type="submit" name="submitAction" value="create">Create</button>
                <button type="submit" name="submitAction" value="update">Edit</button>
                <button type="submit" name="submitAction" value="delete">Delete</button>
                <button type="submit" name="submitAction" value="search">Search</button>
            </div>
        </form>
    </div>
</body>
</html>
