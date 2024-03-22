<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.auca.model.DepartmentModel" %>
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
    <h1>Department Details</h1>
    
    <table border="1">
        <tr>
            <th>Department Name</th>
            <th>Department ID</th>
            <th>Academic Unit Name</th>
            <th>Academic Unit Type</th>
        </tr>
        
        <c:forEach var="department" items="${departmentList}" >
            <tr>
                <td>${department.departmentName}</td>
                <td>${department.ID}</td>
                <td>${department.academicUnit.name}</td>
                <td>${department.academicUnit.academicUnitType}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
