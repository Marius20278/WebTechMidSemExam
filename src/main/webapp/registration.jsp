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
   
    
     <h1> Student registration table</h1>
     
     <table border="1">
        <tr>
        
       		 <th> ID</th>
       		  <th>Student ID</th>
       		    <th>Course ID</th>
             <th>Departments</th>
             <th>Semester Name</th>
             <th>Semester start date</th>
              <th>Semester end date</th>
              
        </tr>
        <c:forEach var="registration" items="${registrationList}">
            <tr>
               <td>${registration.id}</td>
               <td>${registration.student_id}</td> 
                          <td>${registration.course_id}</td>
                    <td>${registration.academicUnit.name}</td>
                 <td>${registration.semester.name}</td>
				  <td>${registration.semester.startDate}</td>
                  <td>${registration.semester.endDate}</td>
                 
       
            </tr>
        </c:forEach>
    </table>
</body>
</html>
