<%-- 
    Document   : login
    Created on : 25-Jan-2023, 12:34:53 pm
    Author     : bas200137
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Login</h2>
        <form method="post" action="login">
            <input type="text" name="username" placeholder="username"><br/>
            <br/>
            <input type="password" name="password" placeholder="password"><br/>
            <br/>
<!--            <h1>${errormsg}</h1>-->
            <button class="btn btn-primary">Login</button>
        </form>
    </body>
</html>
