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

  <h1>List of Students Per Course and Semester</h1>

    
    <table border="1">
        <tr>
            <th>ID</th>
              <th>Semester</th>
              <th>Course ID</th>
               <th>Credits</th>
                 <th>Results</th>
            <th>Student ID</th>
               
          
        </tr>
        <c:forEach var="studentCourse" items="${studentCourseList}">
            <tr>
                <td>${studentCourse.ID}</td>
                  <td>${studentCourse.course.semester}</td>
                 <td>${studentCourse.courseID}</td>
                  <td>${studentCourse.credits}</td>
                    <td>${studentCourse.results}</td>
                <td>${studentCourse.registration.student_id}</td>
                
              
            </tr>
        </c:forEach>
    </table>
    
    
    <h1>List of Courses Per Students</h1>
   
    
    <table border="1">
        <tr>
            <th>ID</th>
              <th>Student ID</th>       
              <th>Course ID</th>
               <th>Credits</th>
                 <th>Results</th>
          
               
          
        </tr>
        <c:forEach var="studentCourse" items="${studentCourseList}">
            <tr>
                <td>${studentCourse.ID}</td>
                  <td>${studentCourse.registration.student_id}</td>
                 <td>${studentCourse.courseID}</td>
                  <td>${studentCourse.credits}</td>
                    <td>${studentCourse.results}</td>
              
                
              
            </tr>
        </c:forEach>
    </table>
</body>
</html>
