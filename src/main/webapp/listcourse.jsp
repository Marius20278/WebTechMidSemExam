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
  <h1>List Of Courses by Department And Semester</h1>
<table border="1">
    <tr>
     
       
        <th>Course Code</th>
         <th>Course Name</th>
         <th>Teacher Name</th>
         <th>Tutor Name</th>
         <th>Assistant Tutor Name</th>
     
    </tr>
    <c:forEach var="course" items="${courseList}">
        <tr>
          
            <td>${course.courseDefinition.course_code}</td>
            <td>${course.courseDefinition.name}</td>
                 <td>${course.teacher.name}</td>
                <td>${course.teacher.tutor}</td>
                <td>${course.teacher.assistant_tutor}</td>
           
           
        </tr>
    </c:forEach>
</table>
  
  
  <h1>List Of Courses by Student</h1>
<table border="1">
    <tr>
     
       
        <th>Course Code</th>
         <th>Course Name</th>
         <th>Teacher Name</th>
         <th>Tutor Name</th>
         <th>Assistant Tutor Name</th>
     
    </tr>
    <c:forEach var="course" items="${coursesList}">
        <tr>
          
            <td>${course.courseDefinition.course_code}</td>
            <td>${course.courseDefinition.name}</td>
                 <td>${course.teacher.name}</td>
                <td>${course.teacher.tutor}</td>
                <td>${course.teacher.assistant_tutor}</td>
           
           
        </tr>
    </c:forEach>
</table>
</body>
</html>
