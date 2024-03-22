<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.auca.model.EAcademicUnit" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Form</title>
  <style>
        body {
            font-family: Arial, sans-serif;
            background: url(images/purple.jpeg) no-repeat center center fixed;
            background-size: cover;
            color: #333;
        }

         .container {
        background: url(images/purple.jpeg) no-repeat center center fixed;
            background-color: #ffffff;
            max-width: 400px;
            margin:  0 auto;
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
    max-width: 150px; /* Set a maximum width for the image */
    display: block; /* Make the image a block element for better positioning */
    margin: 0 auto; /* Center the image horizontally */
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

        .background-image {
            background-image: url('form-background-image.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center center;
        }
        .lamp-container{
    position: absolute;
    top: -20px;
    left: 22%; 
    width: 200px
}

    </style>
</head>
<body>

<div class="container">
    <img src="images/school.jpeg" class="logo" alt="School Logo">
    <h1>Search Form</h1>
    <form action="StudentBySemester" method="post">
        <input type="text" name="semester_id" placeholder="Search by Semester ID">
        <input type="submit" name="search" value="Search">
    </form>
</div>

<div class="container">
    <img src="images/school.jpeg" class="logo" alt="School Logo">
    <h1>Search Form</h1>
    <form action="StudentByDepartmentAndSemester" method="post">
        <input type="text" name="academic_unit_id" placeholder="Search by Department ID">
        <input type="text" name="semester_id" placeholder="Search by Semester ID">
        <input type="submit" name="search" value="Search">
    </form>
</div>



<div class="container">
    <img src="images/school.jpeg" class="logo" alt="School Logo">
    <h1>Search Form</h1>
    <form action="StudentByCourseAndSemester" method="post">
       <input type="text" name="course_id" placeholder="Search by ID">
        <input type="text" name="semester_id" placeholder="Search by Semester ID">
     
        <input type="submit" name="search" value="Search">
    </form>
</div>
    
<div class="container">
    <img src="images/school.jpeg" class="logo" alt="School Logo">
    <h1>Registration Form</h1>
    <form action="Registration" method="post">
     <input type="text" name="id" placeholder=" ID" required><br>
        <input type="text" name="student_id" placeholder="Student ID" required><br>
         <input type="text" name="course_id" placeholder="Course ID" required><br>
        <input type="text" name="semester_id" placeholder="Semester ID" required><br>
        <input type="text" name="academic_unit_id" placeholder="Academic Unit ID" required><br>
        <input type="submit" value="Register">
        
     
    </form>
</div>

</body>
</html>
