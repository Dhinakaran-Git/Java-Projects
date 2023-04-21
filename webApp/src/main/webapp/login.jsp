<%-- 
    Document   : login.jsp
    Created on : 15-Dec-2022, 4:28:17 pm
    Author     : bas200135
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="j_security_check">
            <input type ="text" name="j_username" id="j_username"/>
            <input type ="password" name="j_password" id="j_password"/>
            <input type ="submit" value="Login"/>
        </form>
    </body>
</html>
