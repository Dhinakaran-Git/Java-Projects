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
        <h1>Servlet ViewProfileServlet at <%= request.getContextPath() %></h1>
        <h1>Session id at : <%= session.getId() %></h1 >
        <form action="logout">
            <input type="submit" value="logout" />
        </form>
    </body>
</html>
