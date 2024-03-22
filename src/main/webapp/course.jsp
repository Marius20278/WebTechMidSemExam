<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
 <style>
        /* Basic styling for tables */
        table {
            border-collapse: collapse;
            width: 40%;
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
    <h1>list of courses per department and semester</h1>
    <table border="1">
        <tr>
            <th>Departments</th>
            <th>Semester</th>
            <th>Course Name</th>  
             <th>Course Code</th> 
               <th>Course Teacher</th>
            <th>Tutor</th>
            <th>Assistant Tutor</th>
            
          
            
          
        </tr>
        <c:forEach var="course" items="${courseList}">
            <tr>
               <td>${course.academicUnit.name}</td>
                 <td>${course.semesterInfo.name}</td>
                 <td>${course.courseDefinition.name}</td>
                   <td>${course.courseDefinition.course_code}</td>
                   <td>${course.teacher.name}</td>
                <td>${course.teacher.tutor}</td>
                <td>${course.teacher.assistant_tutor}</td>
               
                 
            
             
            </tr>
        </c:forEach>
    </table>
    
      <h1>List Of Courses Per Student</h1>
    <table border="1">
        <tr>
            
             <th>Student Name</th>
            <th>Course Name</th>  
             <th>Course Code</th> 
               <th>Course Teacher</th>
            <th>Tutor</th>
            <th>Assistant Tutor</th>
           
          
            
          
        </tr>
        <c:forEach var="course" items="${courseList}">
            <tr>
               
                  <td>${course.student.firstName}</td>
                 <td>${course.courseDefinition.name}</td>
                   <td>${course.courseDefinition.course_code}</td>
                   <td>${course.teacher.name}</td>
                <td>${course.teacher.tutor}</td>
                <td>${course.teacher.assistant_tutor}</td>
           
                 
            
             
            </tr>
        </c:forEach>
    </table>
</body>
</html>
