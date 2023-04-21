<%-- 
    Document   : userhistory
    Created on : 06-Feb-2023, 4:13:23 pm
    Author     : bas200137
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

        <h2>Member Transactions</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>              
                    <th>Book Copies Id</th>                  
                    <th>Book Name</th>              
                    <th>Is returned</th>             
                    <th>Is Damaged</th>                
                    <th>Out Date</th>    
                    <th>In Date</th>
                </tr>
            </thead>
            <c:forEach items="${history}" var="issuedBook">
                <tr>
                    <td>${issuedBook.getIssueBookId()}</td>
                    <td>${issuedBook.getBookcopies().getBookCopiesId()}</td>
                    <td>${issuedBook.getBookcopies().getBook().getTitle()}</td>
                    <td>${issuedBook.isReturned() == true ?  'yes' : 'no' }</td> 
                    <td>${issuedBook.getBookcopies().getBookStatus() == "Available" ? 'yes' : 'no' }</td> 
                    <td>${issuedBook.getOutDate()}</td>
                    <td>${issuedBook.getInDate() == null ? '-' : issuedBook.getInDate()}</td>
                </tr>
            </c:forEach>
        </table>
        <button style="margin-left: 560px; margin-top: 80px"><h2><a href="/">back to home</a></h2></button>
    </body>
</html>