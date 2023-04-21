<%-- 
    Document   : collectbook
    Created on : 06-Feb-2023, 12:15:39 pm
    Author     : bas200137
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
        <h1>Collect Book</h1>
        <form method="post" action="/book/api/tocollectbook" modelattribute="request">
            <br/>
            <label>Member Id</label><br/>
            <input type="number" name="memberId" /><br/>
            <br/>
            <label>Book Id</label><br/>
            <input type="number" name="bookId" /><br/>
            <br/>
            <button class="btn btn-primary">Collect Book</button>
        </form>
    </body>
</html>
