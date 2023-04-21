<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Member</h1>

        <form action="newMember" modelAttribute="member" method="post">
            <table>
                <tr>
                    <td>Name : </td>
                    <td><input type="text" placeholder="name" name="name" /></td>
                </tr>
                <tr>
                    <td>Age : </td>
                    <td><input type="number" placeholder="age" name="age" /></td>
                </tr>
                <tr>
                    <td>Gender : </td>
                    <td><input type="gender" placeholder="gender" name="gender" /></td>
                </tr>
                <tr>
                    <td>Number : </td>
                    <td><input type="number" placeholder="number" name="number" /></td>
                </tr>
                <tr>
                    <td colspan="1"><input type="submit" value="SUBMIT"></td>
                </tr>
            </table>
        </form>

    </body>
</html>