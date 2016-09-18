<%-- 
    Document   : ChangeDep
    Created on : Apr 6, 2016, 7:29:47 PM
    Author     : Binh Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Department</title>
    </head>
    <body>
        <font color="red"> Welcome, ${sessionScope.USER} </font>
        <a href="ProcessServlet?btAction=Logout">Logout</a><br>
        <h1>Department Panel</h1><br><br>
        
        <form action="ProcessServlet">

            <h3>Department Name: ${sessionScope.DEPNAME}</h3>

            <c:set var="listDep" value="${requestScope.LISTDEP}"/>

            <h4>To Department: <select name="cbDep">
                    <c:forEach var="aDep" items="${listDep}">
                        <c:if test="${not (sessionScope.DEPID eq aDep.depID)}">
                            <option>${aDep.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </h4>

            <h4>Salary <input type="text" name="txtSalary" value="${param.txtSalary}" /></h4>

            <input type="hidden" name="txtUserChosenID" value="${param.txtUserChosenID}" /> 
            <input type="submit" value="Confirm" name="btAction"/>

            <c:url var="cancelLink" value="ProcessServlet">
                <c:param name="btAction" value="Search"/>
                <c:param name="txtSearch" value="${param.lastSearchValue}"/>
            </c:url>
            <a href="${cancelLink}"><input type="button" value="Cancel" /></a><br>
            
            <c:if test="${not empty requestScope.CHANGESALARY}">
                <font color="red">${requestScope.CHANGESALARY}</font>
            </c:if>

        </form>
    </body>
</html>
