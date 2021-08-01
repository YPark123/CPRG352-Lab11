<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Notes</title>
    </head>
    <body>
        <h1>Enter a new password</h1>
        <form action="" method="post">
            <input type="text" name="password"><br>
            <input type="hidden" name="action" value="resetpassword">
            <input type="submit" value="Submit">
        </form>
        
        <c:if test="${message eq 'success'}"> Your password is successfully updated <br>
            <a href="login">login page</a></c:if>
        <c:if test="${message eq 'error'}">Sorry, something went wrong.</c:if>
    </body>
</html>