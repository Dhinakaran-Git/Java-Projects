<%-- 
    Document   : addmember
    Created on : 26-Dec-2022, 8:37:52 pm
    Author     : bas200137
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Freelancer</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
        crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
              rel="stylesheet" type="text/css" />
        <link
            href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
            rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/index-styles.css" rel="stylesheet" />
        <!-- includes Bootstrap icons-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    </head>
    <body>
        <h1>AddMember</h1>
        <form method="post" action="addmember">
            <label>Name</label>
            <br/>
            <input type="text" id="name" name="name"><br/>
            <br/>
            <label>Age</label>
            <br/>
            <input type="text" id="age" name="age"><br/>
            <br/>
            <label class="me-5">Gender</label>
            <br/>
            <input type="text" id="gender" name="gender"><br/>
            <br/>
            <label class="me-4">Number</label>
            <br/>
                <input type="text" id="num" name="num">
            <button class="btn btn-primary">Register</button>
        </form>
        <h2>${status}</h2>
    </body>
</html>
