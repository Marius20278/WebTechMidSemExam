
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Semester  Form</title>
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

        h1 {
            color: #333;
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
            background-color: #000;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        /* Style for menu links */
        .menu a {
            text-decoration: none;
            color: #fff;
            padding: 10px;
        }

        /* Hover effect for menu links */
        .menu a:hover {
            background-color: #333;
        }
    </style>
</head>
<body>
  
<div class="container">

    <h1>Semester Details Form</h1>
    <form action="CDefinition" method="post">
 
    <input type="text" name="id" placeholder="id" required><br>
        <input type="text" name="name" placeholder="name" required><br>
<label for="startDate">Start Date:</label>
<input type="date" name="startDate" id="startDate" placeholder="startDate" required><br>

<label for="endDate">End Date:</label>
<input type="date" name="endDate" id="endDate" placeholder="endDate" required><br>

        <input type="submit" value="Register">
    </form>
</div>
</body>
</html>
