<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Registration Form</title>
    <style>
        body {
         background: url(images/purple.jpeg) no-repeat center center fixed;
          background-size: cover;
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
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
        .logo {
    max-width: 150px; /* Set a maximum width for the image */
    display: block; /* Make the image a block element for better positioning */
    margin: 0 auto; /* Center the image horizontally */
}

        h1 {
            color: blue;
        }

        input[type="text"], input[type="password"] {
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
          .menu {
            background-color: purple;
            color: #fff;
            padding: 20px;
             margin: 10px 0;
            text-align: center;
             
        }

        /* Style for menu links */
        .menu a {
            text-decoration: none;
            color: #fff;
            padding: 10px;
            transition: font-size 0.3s;
        }

        /* Hover effect for menu links */
        .menu a:hover {
            background-color: blue;
             font-size: 18px;
        }
    </style>
</head>
<body>
   <div class="menu">
    <a href="insert_teacher.jsp">Teacher </a> 
    <a href="insert_academic.jsp">Academic </a> 
    <a href="insert_semester.jsp">Semester </a> 
      <a href="insert_department.jsp">Department </a> 
       <a href="insert_course.jsp">Course </a> 
        <a href="insert_studentcourse.jsp">StudentCourse </a> 
      <a href="insert_registration.jsp">Registration </a> 
        <a href="cdefinition.jsp">CourseDefinition</a> 
</div>
<div class="container">
 <img src="images/school.jpeg" class="logo" alt="School Logo">
    <h1>Student Details Form</h1>
    <form action="Student" method="post">
 
    <input type="text" name="regNo" placeholder="regNo" required><br>
        <input type="text" name="firstName" placeholder="firstName" required><br>
        <input type="text" name="dateOfBirth" placeholder="dateOfBirth" required><br>
        <input type="submit" value="Register">
    </form>
</div>
</body>
</html>
