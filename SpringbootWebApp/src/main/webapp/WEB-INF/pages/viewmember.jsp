<%-- 
    Document   : login
    Created on : 03-Dec-2022, 8:24:46 pm
    Author     : bas200137
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <h2>View Member</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Member Id</th>
                    <th>Member Name</th>
                    <th>Password</th>
                    <th>Member Age</th>
                    <th>Gender</th>
                    <th>Phone Number</th>
                    <th>Role</th>
                    <th>Member Status</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${member.getMemberId()}</td>
                    <td>${member.getName()}</td>
                    <td>${member.getPassword()}</td>
                    <td>${member.getAge()}</td>
                    <td>${member.getGender()}</td>
                    <td>${member.getNumber()}</td>
                    <td>${member.getUserRole()}</td>
                    <td>${member.getMemberStatus()}</td>
                </tr>
            </tbody>
        </table>
        <button style="margin-left: 560px; margin-top: 80px"><h2><a href="/">back to home</a></h2></button>
    </body>
</html>
