<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Notes</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <p>Please enter your email address to reset your password.</p>
        <form action="" method="post">
            Email Address: <input type="text" name="email" value="${email}"><br>
            <input type="hidden" name="action" value="submitreset"> 
            <input type="submit" value="Submit">
        </form>
            
        <c:if test="${message eq 'null'}"> Please enter your email.</c:if>
        <c:if test="${message eq 'success'}"> Password reset request has sent to your email</c:if>
    </body>
</html>