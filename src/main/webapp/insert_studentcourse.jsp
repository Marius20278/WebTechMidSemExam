<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.auca.model.EAcademicUnit" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Course Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url(images/purple.jpeg) no-repeat center center fixed;
            background-size: cover;
            color: #333;
        }

        .container {
            background-color: #ffffff;
            max-width: 400px;
            margin: 0 auto;
            padding: 90px;
            border: 1px solid #ccc;
            border-radius: 15px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        .container {
            background-color: #fff;
            max-width: 400px;
            margin: 70px auto 0;
            padding: 30px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(1, 0, 0, 0.2);
            text-align: left;
        }

        .logo {
            max-width: 150px;
            display: block;
            margin: 0 auto;
        }

        h1 {
            color: blue;
        }

        input[type="text"], input[type="password"], select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <img src="images/school.jpeg" class="logo" alt="School Logo">
    <h1>Student Course Form</h1>
    <form action="StudentCourse" method="post">
          <input type="text" name="ID" placeholder="ID" required><br>
        <input type="text" name="studentID" placeholder="Student ID" required><br>
        <input type="text" name="courseID" placeholder="Course ID" required><br>
        <input type="text" name="credits" placeholder="Credits" required><br>
        <input type="text" name="results" placeholder="Results" required><br>
        <input type="submit" value="Register">
    </form>
</div>
</body>
</html>
