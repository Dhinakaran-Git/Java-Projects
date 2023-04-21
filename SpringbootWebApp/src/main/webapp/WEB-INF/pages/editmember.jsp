<%-- 
    Document   : addmember
    Created on : 03-Dec-2022, 6:26:29 pm
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
        <h1>Update Member</h1>
        <form method="post" action="/member/api/updatemember" modelattribute="memberRequest">
            <label>Username</label>
            <br/>
            <input type="hidden" name="id" value="${member.getMemberId()}"><br/>
            <input type="text" name="name" value="${member.getName()}"><br/>
            <br />
            <label>Password</label>
            <br/>
            <input type="text" name="password" value="${member.getPassword()}"><br/>
            <br/>
            <label>Age</label>
            <br/>
            <input type="text" name="age" value="${member.getAge()}"><br/>
            <br/>
            <label class="me-5">Gender</label>
            <br/>
            <input type="text" name="gender" value="${member.getGender()}"><br/>
            <br/>
            <label class="me-4">Number</label>
            <br/>
            <input type="text" name="num" value="${member.getNumber()}"><br />
            <br/>
            <label class="me-4">User Role</label>
            <br/>
            <select class="px-5 py-1" name="userRole">
                <option>MEMBER</option>
                <option>ADMIN</option>
            </select>
            <button class="btn btn-primary">Update</button>
        </form>
</body>
</html>
