<%-- 
    Document   : addmember
    Created on : 03-Dec-2022, 6:26:29 pm
    Author     : bas200137
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <h1>Add Book</h1>
        <form method="post" action="/book/api/newbook" modelattribute="bookrequest">
            <label>Name</label>
            <br/>
            <input type="text" id="name" name="name"><br/>
            <br/>
            <label>Authors <button type="button" class="btn btn-success rounded-3" onclick="addAuthorField()">AddAuthor</button></label>
            <br/>
            <div id="authors" name="authors"></div>
            <br/>
            <label>Isbn No</label>
            <br />
            <input type="text" id="isbn" name="isbn"/><br/>
            <br />
            <button class="btn btn-primary">AddBook</button>
        </form>
        <h2>${status}</h2>
        <script>
            function addAuthorField() {
                const holder = document.getElementById("authors");
                const authorElement = document.createElement("input");
                authorElement.setAttribute("name", "authors");
                holder.appendChild(authorElement);
                authorElement.focus();
            }
        </script>
    </body>
</html>
