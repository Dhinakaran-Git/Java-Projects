<%-- 
    Document   : action
    Created on : 20-Dec-2022, 11:10:10 am
    Author     : bas200137
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
            <style>
                .test{
                    background-color: aqua;
                }
            </style>
        </head>
        <body class="test">
            <h1>Hello World!</h1>
            <jsp:element name="span" trim="true">
                <jsp:attribute name="style">
                    font-size: 60px;
                    color: blue;
                </jsp:attribute>
                <jsp:body>
                    Hello
                </jsp:body>
            </jsp:element>
        </body>
    </html>
</f:view>
