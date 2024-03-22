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
    <h1>Academic List</h1>
    <table border="1">
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>ParentId</th>
            <th>academicUnitType</th>
           
        </tr>
        <c:forEach var="academic" items="${academicList}">
            <tr>
                <td>${academic.code}</td>
                <td>${academic.name}</td>
                <td>${academic.parentId}</td>
                <td>${academic.academicUnitType}</td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>
