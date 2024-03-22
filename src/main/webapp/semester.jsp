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
    <h1>Semester List</h1>
    <table border="1">
        <tr>
            <th>Semester id</th>
            <th>Semester Name</th>
            <th>Start Date</th>
             <th>End Date</th>
        </tr>
        <c:forEach var="semester" items="${semesterList}">
           <tr>
                <td>${semester.id}</td>
                <td>${semester.name}</td>
                <td><fmt:parseDate var="startDateVar" value="${semester.startDate}" pattern="yyyy-MM-dd" />
    <c:out value="${startDateVar}" />
</td>
<td><fmt:parseDate var="endDateVar" value="${semester.endDate}" pattern="yyyy-MM-dd" />
    <c:out value="${endDateVar}" />
</td>
                
            </tr>
        </c:forEach>
    </table>
</body>
</html>
