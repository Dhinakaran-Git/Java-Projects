<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete Book</h1>
        
        <form method="POST"  modelAttribute="id" action="/spring-web/deleteBook" >
            <input type="number" name="id" placeholder="enter an Book id" />
            <input type="submit" value="Submit" />
        </form>
        
    </body>
</html>
