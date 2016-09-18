<%-- 
    Document   : Employee
    Created on : Apr 5, 2016, 9:02:15 PM
    Author     : Tu Nguyen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
    </head>
    <body>

        <font color="red"> Welcome, ${sessionScope.USER} </font>
        <a href="ProcessServlet?btAction=Logout">Logout</a>
        <br>
        <h1>Employee Profile</h1><br><br>

        <c:set var="account" value="${requestScope.PROFILE}"/>
        <c:set var="dep" value="${sessionScope.DEPNAME}"/>


        <form action="ProcessServlet">

            <table border="0" >
                <tbody>
                    <tr>
                        <td>EmployeeID</td>
                        <td>${account.employeeID}</td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>${account.name}</td>
                    </tr>
                    <tr>
                        <td>Department</td>
                        <td>${dep}</td>
                    </tr>
                    <tr>
                        <td>Salary</td>
                        <td>${account.salary}</td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="txtAdr" value="${account.address}"/></td> (1-20 characters)           
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="txtEmail" value="${account.email}"/></td> (1-30 characters)
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input type="text" name="txtPhone" value="${account.phone}"/></td> (1-11 characters)
                    </tr>
                    <tr>
                        <td>Family</td>
                        <td><input type="text" name="txtFamily" value="${account.family}"/></td> (1-20 characters)
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="btAction" value="Update"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br>

            <c:set var="updateErr" value="${requestScope.UPDATEERR}"/>
            <c:if test="${not empty updateErr.addressLengthError}">
                <font color="red">
                <br>${updateErr.addressLengthError}
                </font>
            </c:if>
            <c:if test="${not empty updateErr.emailLengthError}">
                <font color="red">
                <br>${updateErr.emailLengthError}
                </font>
            </c:if>
            <c:if test="${not empty updateErr.phoneLengthError}">
                <font color="red">
                <br>${updateErr.phoneLengthError}
                </font>
            </c:if>
            <c:if test="${not empty updateErr.familyLengthErrror}">
                <font color="red">
                <br>${updateErr.familyLengthErrror}
                </font>
            </c:if>

            <c:if test="${not empty requestScope.UPDATESUCCESS}">
                <font color="green">
                <br>${requestScope.UPDATESUCCESS}
                </font>
            </c:if>


            <br><br>



            Leave date <input type="text" name="txtTotal" value="${requestScope.HOURS}" disabled="disabled" /> (working hours)<br>
            From <input type="date" name="txtFrom" value="" 
                        <c:if test="${account.status eq 1}">
                            disabled="disabled"
                        </c:if>
                        />
            To <input type="date" name="txtTo" value="" 
                      <c:if test="${account.status eq 1}">
                          disabled="disabled"
                      </c:if>
                      />
            <br> <input type="submit" value="Propose" name="btAction" 
                        <c:if test="${account.status eq 1}">
                            disabled="disabled"
                        </c:if>/><br>
            
            <c:if test="${account.status eq 1}">
                <font color="red">Your request is pending!</font>
            </c:if>

            <c:set var="leaveErr" value="${requestScope.LEAVEERR}"/>
            <c:if test="${not empty leaveErr.dateInvalidError}">
                <br><font color="red">${leaveErr.dateInvalidError}</font>
            </c:if>
            <c:if test="${not empty leaveErr.currentDateError}">
                <br><font color="red">${leaveErr.currentDateError}</font>
            </c:if>

            <c:if test="${not empty requestScope.PROPOSE}">
                <br><font color="green">${requestScope.PROPOSE}</font>
            </c:if>

        </form>

        <br><br>
        <c:set var="role" value="${sessionScope.ROLE}"/>
        <c:if test="${role}">
            <a href = "ManagerServlet"> Click here to back to Manager Control Panel </a>
        </c:if>



    </body>
</html>
