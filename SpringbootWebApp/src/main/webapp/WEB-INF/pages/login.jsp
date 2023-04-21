<%-- 
    Document   : login
    Created on : 03-Dec-2022, 8:24:46 pm
    Author     : bas200137
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>BooksWagon</title>
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <h2>Login</h2>
        <form method="post">
            <input type="text" name="username" placeholder="username"><br/>
            <br/>
            <input type="password" name="password" placeholder="password"><br/>
            <br/>
            <h1>${errormsg}</h1>
            <button class="btn btn-primary">Login</button>
        </form>
    </body>
</html>
