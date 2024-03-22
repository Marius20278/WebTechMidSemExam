<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        /* Basic styling for tables */
        table {
            border-collapse: collapse;
            width: 70%;
        }

        th, td {
            border: 1px solid #ddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        /* Styling for section headers */
        h1 {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>List of Students per Semester</h1>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <!-- Add other student information columns as needed -->
        </tr>
        <c:forEach var="sregistration" items="${sregistrationList}">
            <tr>
                <td>${sregistration.student_id}</td>
                <td>${sregistration.student.firstName}</td>
                <!-- Add other student information as needed -->
            </tr>
        </c:forEach>
    </table>
    
       <h1>List of Students per Semester and department</h1>
   <table border="1">
    <tr>
        <th>Student ID</th>
        <th>Student Name</th>
 
   
    </tr>
    <c:forEach var="sregistration" items="${dregistrationList}">
        <tr>
            <td>${sregistration.student_id}</td>
            <td>${sregistration.student.firstName}</td>
       
        </tr>
    </c:forEach>
</table>
   
<h1>List of Students per Course and Semester</h1>
<table border="1">
    <tr>
        <th>Student ID</th>
        <th>Student Name</th>
    </tr>
    <c:forEach var="sregistration" items="${cregistrationList}">
        <tr>
            <td>${sregistration.student_id}</td>
            <td>${sregistration.student.firstName}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
