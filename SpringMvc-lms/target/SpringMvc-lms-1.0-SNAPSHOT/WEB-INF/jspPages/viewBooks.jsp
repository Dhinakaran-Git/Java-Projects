<%@taglib uri="jakarta.tags.core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Books List</h1>
            <table border="2" cellpadding="5" cellspacing="5" >
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Isbn</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                <div>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>
                        <c:out value="${book.getId()}"/>
                        </td>
                        <td>
                        <c:out value="${book.getTitle()}"/>
                        </td>
                        <td>
                        <c:out value="${book.getIsbn()}"/>
                        </td>
                        <td>
                        <c:out value="${book.getPrice()}"/>
                        </td>
                        </tr>
                    </c:forEach>
                </div>
                </tbody>
            </table>
                    <a href="/spring-web/">Click to Main Menu</a>

        </div>
    </body>
</html>
