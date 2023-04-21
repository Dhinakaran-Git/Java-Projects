<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>IssueBook Details</h1>
        <form method="POST"  modelAttribute="id" action="/spring-web/issueBookMember" >            
            <input type="text" placeholder="enter the member id" name="memberId" /> <br/><br/>
            <input type="text" placeholder="enter the isbn" name="bookId" /><br/><br/>
            <input type="submit" value="IssueBook" />            
        </form>
    </body>
</html>
