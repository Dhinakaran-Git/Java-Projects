<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Book</h1>


        <form action="newBook" modelAttribute="book" method="POST">
            <table>
                <tr>
                    <td>Title : </td>
                    <td><input type="text" placeholder="name" name="title" /></td>
                </tr>
                <tr>
                    <td>Isbn : </td>
                    <td><input type="text" placeholder="isbn" name="isbn" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" placeholder="price" name="price" /></td>
                </tr>
                <tr>
                <p>Authors <button type="button" class="btn btn-success rounded-3" onclick="addAuthorField()">AddAuthor</button></p>
                <div id="authors" name="authors"></div>
                <script>
                    let count = 1;
                    function addAuthorField() {
                        const holder = document.getElementById("authors");
                        const authorElement = document.createElement("input");
                        authorElement.setAttribute("name", "authors");
                        authorElement.setAttribute("placeholder", "enter the " + count++ + " author name");
                        holder.appendChild(authorElement);
                        authorElement.focus();
                    }
                </script>
                </tr>
                <tr>
                <label>Copies </label>
                <select name="bookCopies" >
                    <option value="" >--Select--</option>
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                </select>
                </tr>
                <tr>
                    <td colspan="1"><input type="submit" value="SUBMIT"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
