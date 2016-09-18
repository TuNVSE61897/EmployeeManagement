<%-- 
    Document   : Login
    Created on : Apr 5, 2016, 7:02:11 PM
    Author     : Binh Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>

        <form action="ProcessServlet" method="POST">

            Username <input type="text" name="txtUsername" value="${param.txtUsername}" />
            <font color="red">${requestScope.EMPTYUSERNAME}</font><br>

            Password <input type="password" name="txtPassword" value="" />
            <font color="red">${requestScope.EMPTYPASSWORD}</font><br>

            <input type="submit" value="Login" name="btAction" />
            <input type="reset" value="Reset" />

        </form>

    </body>
</html>
