<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Member</h1>

        <form method="PUT" action="update/${member.getMember_id()}">
            <table>
                <tr>
                    <td>Name : </td>
                    <td><input type="text" id="name" name="name" value="${member.getName()}"></td>
                </tr>
                <tr>
                    <td>Age : </td>
                    <td><input type="text" id="age" name="age" value="${member.getAge()}"></td>
                </tr>
                <tr>
                    <td>Gender : </td>
                    <td><input type="text" id="gender" name="gender" value="${member.getGender()}"></td>
                </tr>
                <tr>
                    <td>Number : </td>
                    <td><input type="text" id="num" name="num" value="${member.getPhone_Number()}"></td>
                </tr>
                <tr>
                    <td>Member Status : </td>
                    <td><input type="text" id="status" name="status" value="${member.getMemberStatus()}"></td>
                </tr>
                <tr>
                    <td colspan="1"><input type="submit" value="UPDATE"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
